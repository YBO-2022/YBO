FROM openjdk:11-jdk

# ARG JAR_FILE=./build/libs/*.jar

# COPY ${JAR_FILE} /app.jar

VOLUME /tmp

RUN echo ${JAR_FILE}

ARG JAR_FILE

ADD ${JAR_FILE} /app.jar

CMD ["java","-jar","app.jar"]


