FROM python:3.10-slim

COPY . /app

RUN apt-get update < /dev/null
RUN echo "y" | apt-get install python3-tk
RUN pip3 install flask 
RUN pip3 install requests
RUN pip3 install bs4
RUN pip3 install pandas
RUN pip3 install sqlalchemy
RUN pip3 install pymysql
RUN pip3 install python-dotenv

WORKDIR /app

CMD flask run -h 0.0.0.0 -p 5000