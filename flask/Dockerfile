FROM python:3.10-slim

COPY . /app

RUN apt-get update < /dev/null
RUN echo "y" | apt-get install python3-tk
RUN pip3 install flask 
RUN pip3 install requests
RUN pip3 install bs4
RUN pip3 install pymongo

WORKDIR /app

CMD ["python3", "-m", "flask", "run"]

# http://127.0.0.1:5000