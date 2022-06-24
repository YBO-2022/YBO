from flask import Flask, jsonify
from game import realtime_game
from ranking import realtime_ranking


# Flask 객체 인스턴스 생성
print(f"__name__: {__name__}")
app = Flask(__name__)

app.config["JSON_AS_ASCII"] = False


@app.route('/ranking')
def rank():
    data = realtime_ranking()
    return jsonify(data)


@app.route('/game')
def index():
    data = realtime_game()
    return jsonify(data)



if __name__ == '__main__':
    print("run as main")
    # app.run(host="0.0.0.0", port=5000)

# python -m flask run
