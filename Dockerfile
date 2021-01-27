FROM tomcat:9-jre10

LABEL maintainer='<shdkpr2008@gmail.com>'

ARG JAR_FILE=target/*.war
RUN rm -rf /usr/local/tomcat/webapps/*

COPY ${JAR_FILE} /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

ENTRYPOINT catalina.sh run
