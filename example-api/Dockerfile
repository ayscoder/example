FROM tomcat:8.0.51-jre8-alpine
MAINTAINER Ayush

RUN rm -rf /usr/local/tomcat/webapps/*
ADD target/*.war /usr/local/tomcat/webapps/example.war

COPY src/scripts/* /opt/example-api/bin/

RUN chmod 755 /opt/example-api/bin/start.sh

#RUN rm -rf /usr/local/tomcat/webapps/*
#RUN mv /tmp/example.war /usr/local/tomcat/webapps

RUN addgroup -S appgroup && adduser -S appuser -G appgroup
RUN chown -R appuser:appgroup /usr/local/tomcat
USER appuser

ENTRYPOINT /bin/sh /opt/example-api/bin/start.sh