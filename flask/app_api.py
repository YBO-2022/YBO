# app.py
from re import I
from turtle import left
from flask import Flask, jsonify
import requests
from bs4 import BeautifulSoup
from pymongo import MongoClient
import time
from datetime import datetime

# Flask 객체 인스턴스 생성
print(f"__name__: {__name__}")
app = Flask(__name__)

app.config["JSON_AS_ASCII"] = False


@app.route('/rank')  # 접속하는 url
def rank():
    data = rank()
    return jsonify(data)


@app.route('/game')  # 접속하는 url
def index():
    data = real_time_score()
    return jsonify(data)


@app.route('/game/monday')  # 접속하는 url
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
                     "gameNumber": game,
                     "winNumber": win,
                     "loseNumber": lose,
                     "drawNumber": draw,
                     "winRate": winRate,
                     "gameDiff": gameDiff,
                     "continuity": continuity
                     }
        rank_list.append(rank_dict)
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
            "id": i,
            "gameState": game_state,
            "leftTeam": left_team,
            "rightTeam": right_team,
            "leftScore": left_score,
            "rightScore": right_score,
            "state": state,
            "leftPitcher": left_pitcher,
            "rightPitcher": right_pitcher
        }
        score_list.append(score)
    return {"statusCode": 200, "message": message, "data": score_list}


if __name__ == '__main__':
    print("run as main")
    # app.run(host="0.0.0.0", port=5000)

# python -m flask run
