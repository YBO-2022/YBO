
import requests
from bs4 import BeautifulSoup
import pandas as pd
from sqlalchemy import create_engine
import sqlalchemy
from dotenv import load_dotenv
import os
from datetime import datetime
import time
import pymysql

# 환경 변수 설정
load_dotenv()
user = os.getenv('DB_USERNAME')
password = os.getenv('DB_PASSWORD')
host = os.getenv('DB_HOST')
port = 3306
database = "ybo_db"



def realtime_game():
    print("host:", host)
    response = requests.get("https://sports.news.naver.com/kbaseball/schedule/index.nhn")
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    today = datetime.today().date()
    n = time.localtime().tm_wday
    score_list = []

    if n == 0:
        message = str(today) + "는 월요일로 야구 경기가 없습니다"
        return {"statusCode": 404, "message": message, "data": None}

    message = str(today) + "의 경기 진행 상황입니다"
    for i in range(1, 6):
        left_team = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > p > strong').get_text()
        right_team = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > p > strong').get_text()
        left_pitcher = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > p > span > a').get_text()
        right_pitcher = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > p > span > a').get_text()
        state = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_cnt > em').get_text().strip()
        if state == "취소":
            game_state = "경기 취소"
            left_score = " "
            right_score = " "
        elif ":" in state:
            game_state = " 시작 전"
            left_score = " "
            right_score = " "
        elif state == "종료":
            game_state = "경기 종료"
            left_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > strong').get_text()
            right_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > strong').get_text()
        else:
            game_state = " 경기 중"
            left_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > strong').get_text()
            right_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > strong').get_text()

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
