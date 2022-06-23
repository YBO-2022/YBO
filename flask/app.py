from flask import Flask, jsonify
import requests
from bs4 import BeautifulSoup
import time
from datetime import datetime
import pandas as pd
import sqlalchemy
from sqlalchemy import create_engine
import os
import pymysql
from dotenv import load_dotenv

# 환경 변수 설정
load_dotenv()
user = os.getenv('DB_USERNAME')
password = os.getenv('DB_PASSWORD')
host = os.getenv('DB_HOST')
port = 3306
database = "ybo_db"

# Flask 객체 인스턴스 생성
print(f"__name__: {__name__}")
app = Flask(__name__)

app.config["JSON_AS_ASCII"] = False


@app.route('/rank')
def rank():
    data = rank()
    return jsonify(data)


@app.route('/game')
def index():
    data = real_time_score()
    return jsonify(data)


@app.route('/game/monday')
def index_monday():
    data = real_time_score(True)
    return jsonify(data)


def rank():
    rank_list = []
    response = requests.get(f'https://sports.news.naver.com/kbaseball/record/index?category=kbo')
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')
    message = "실시간 구단 순위 전송 성공"

    for i in range(10):
        k = i + 1
        ranking = soup.select("#regularTeamRecordList_table > tr >th > strong")[i].get_text()
        team = soup.select("#regularTeamRecordList_table > tr > td > div > span.emblem")[
            i].next_sibling.next_sibling.get_text()
        game = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(3) > span').get_text()
        win = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(4) > span').get_text()
        lose = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(5) > span').get_text()
        draw = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(6) > span').get_text()
        winRate = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(7) > strong').get_text()
        gameDiff = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(8) > span').get_text()
        continuity = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(9) > span').get_text()
        rank_dict = {"ranking": ranking,
                     "team": team,
                     "game_number": game,
                     "win_number": win,
                     "lose_number": lose,
                     "draw_number": draw,
                     "win_rate": winRate,
                     "game_diff": gameDiff,
                     "continuity": continuity
                     }
        rank_list.append(rank_dict)
    df = pd.DataFrame(rank_list)
    df['realtime_ranking_id'] = df.index

    # DB 접속 엔진 객체 생성
    engine = create_engine(f'mysql+pymysql://{user}:{password}@{host}:{port}/{database}', encoding='utf-8')

    # DB 테이블 명
    table_name = "realtime_ranking"

    dtypesql = {'realtime_ranking_id': sqlalchemy.types.Integer,
                'ranking': sqlalchemy.types.Integer,
                'team': sqlalchemy.types.VARCHAR(255),
                'game_number': sqlalchemy.types.Integer,
                'win_number': sqlalchemy.types.Integer,
                'lose_number': sqlalchemy.types.Integer,
                'draw_number': sqlalchemy.types.Integer,
                'win_rate': sqlalchemy.types.Float,
                'game_diff': sqlalchemy.types.Float,
                'continuity': sqlalchemy.types.VARCHAR(255),
                }

    # DB에 DataFrame 적재
    df.to_sql(index=False,
              name=table_name,
              con=engine,
              if_exists='replace',
              method='multi',
              chunksize=10000,
              dtype=dtypesql)

    with engine.connect() as con:
        con.execute('ALTER TABLE `realtime_ranking` ADD PRIMARY KEY (`realtime_ranking_id`);')

    return {"statusCode": 200, "message": message, "data": rank_list}


def real_time_score(isMondayTest=False):
    response = requests.get("https://sports.news.naver.com/kbaseball/schedule/index.nhn")
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    today = datetime.today().date()
    n = time.localtime().tm_wday
    score_list = []

    if n == 0 or isMondayTest:
        message = str(today) + "는 월요일로 야구 경기가 없습니다"
        return {"statusCode": 404, "message": message, "data": None}

    message = str(today) + "의 경기 진행 상황입니다"
    for i in range(1, 6):
        left_team = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > p > strong').get_text()
        right_team = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > p > strong').get_text()
        left_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > strong').get_text()
        right_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > strong').get_text()
        left_pitcher = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > p > span > a').get_text()
        right_pitcher = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > p > span > a').get_text()
        state = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_cnt > em').get_text().strip()
        if ":" in state:
            game_state = "시작 전"
            left_score = " "
            right_score = " "
        elif state == "종료":
            game_state = "경기 종료"
        else:
            game_state = "경기 중"
        score = {
            "game_state": game_state,
            "left_team": left_team,
            "right_team": right_team,
            "left_score": left_score,
            "right_score": right_score,
            "state": state,
            "left_pitcher": left_pitcher,
            "right_pitcher": right_pitcher
        }
        score_list.append(score)
    df = pd.DataFrame(score_list)
    df['realtime_game_id'] = df.index

    # DB 접속 엔진 객체 생성
    engine = create_engine(f'mysql+pymysql://{user}:{password}@{host}:{port}/{database}', encoding='utf-8')

    # DB 테이블 명
    table_name = "realtime_game"

    dtypesql = {'realtime_game_id': sqlalchemy.types.Integer,
                'game_state': sqlalchemy.types.VARCHAR(255),
                'left_team': sqlalchemy.types.VARCHAR(255),
                'right_team': sqlalchemy.types.VARCHAR(255),
                'left_score': sqlalchemy.types.VARCHAR(255),
                'right_score': sqlalchemy.types.VARCHAR(255),
                'draw_number': sqlalchemy.types.VARCHAR(255),
                'state': sqlalchemy.types.VARCHAR(255),
                'left_pitcher': sqlalchemy.types.VARCHAR(255),
                'right_pitcher': sqlalchemy.types.VARCHAR(255)
                }

    # DB에 DataFrame 적재
    df.to_sql(index=False,
              name=table_name,
              con=engine,
              if_exists='replace',
              method='multi',
              chunksize=10000,
              dtype=dtypesql)

    with engine.connect() as con:
        con.execute('ALTER TABLE `realtime_game` ADD PRIMARY KEY (`realtime_game_id`);')

    return {"statusCode": 200, "message": message, "data": score_list}


if __name__ == '__main__':
    print("run as main")
    # app.run(host="0.0.0.0", port=5000)

# python -m flask run
