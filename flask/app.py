# app.py
from re import I
from turtle import left
from flask import Flask, jsonify
import requests
from bs4 import BeautifulSoup
from pymongo import MongoClient
import time
from datetime import datetime

#Flask 객체 인스턴스 생성
print(f"__name__: {__name__}")
app = Flask(__name__)

app.config["JSON_AS_ASCII"] = False

# client = MongoClient('localhost', 27017)
# db = client.dbsparta

@app.route('/') # 접속하는 url
def index():
  data = real_time_score()
  return jsonify(data)

@app.route('/rank') # 접속하는 url
def rank():
  data = rank()
  return jsonify(data)


def rank():
    rank_list =[]
    response = requests.get(f'https://sports.news.naver.com/kbaseball/record/index?category=kbo')
    html = response.text
    soup = BeautifulSoup(html,'html.parser')
    message = "실시간 구단 순위 전송 성공"

    for i in range(10):
        k = i + 1
        j=  i + 2
        ranking = soup.select("#regularTeamRecordList_table > tr >th > strong")[i].get_text()
        team = soup.select("#regularTeamRecordList_table > tr > td > div > span.emblem")[i].next_sibling.next_sibling.get_text()
        game = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(3) > span').get_text()
        win = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(4) > span').get_text()
        lose = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(5) > span').get_text()
        draw = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(6) > span').get_text()
        winRate = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(7) > strong').get_text()
        GameDiff = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(8) > span').get_text()
        Continuity = soup.select_one(f'#regularTeamRecordList_table > tr:nth-child({k}) > td:nth-child(9) > span').get_text()
        rank_dict = {"ranking":ranking, 
            "team": team,
            "game":game, 
            "win":win, 
            "lose":lose,
             "draw":draw,
             "win_rate":winRate,
             "game_diff":GameDiff,
             "continuity":Continuity
             }
        rank_list.append(rank_dict)
    return {"message":message,"score":rank_list}

def real_time_score():
      
  response = requests.get("https://sports.news.naver.com/kbaseball/schedule/index.nhn")
  html = response.text
  soup = BeautifulSoup(html,'html.parser')

  today = datetime.today().date()
  n= time.localtime().tm_wday
  score_list = []
  if n==0 :
    message = str(today) + "는 월요일로 야구 경기가 없습니다"
    for i in range(1, 6):
      score={
        "id" : i,
        "game_state" : None,
        "left_team" : None,
        "right_team" : None,
        "left_score" :None,
        "right_score" :None,
        "state" : None,
        "left_pitcher" : None,
        "right_pitcher" : None
       }
      score_list.append(score)
    return {"message":message,"data":score_list}
  
  else :
      message = str(today) +"의 경기 진행 상황입니다"
      for i in range(1,6):
        left_team = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > p > strong').get_text()
        right_team = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > p > strong').get_text()
        left_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > strong').get_text()
        right_score = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > strong').get_text()
        left_pitcher = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_lft > p > span > a').get_text()
        right_pitcher = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_rgt > p > span > a').get_text()
        state = soup.select_one(f'#todaySchedule > li:nth-child({i}) > div.vs_cnt > em').get_text().strip()
        if ":" in state :
            game_state = "시작 전"
            left_score = " "
            right_score = " "
        elif state=="종료" :
            game_state = "경기 종료"
        else :
            game_state = "경기 중"
        score={
            "id" : i,
            "game_state" : game_state,
            "left_team" : left_team,
            "right_team" : right_team,
            "left_score" :left_score,
            "right_score" :right_score,
            "state" : state,
            "left_pitcher" : left_pitcher,
            "right_pitcher" : right_pitcher
       }
        score_list.append(score)
  return {"message":message,"data":score_list}

if __name__ == '__main__' :
    app.run(debug=True)

# python -m flask run