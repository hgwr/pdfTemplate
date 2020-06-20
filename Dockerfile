
FROM openjdk:14-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/pdfTemplate-0.0.1-SNAPSHOT.jar pdftemplate.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar pdftemplate.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar pdftemplate.jar
