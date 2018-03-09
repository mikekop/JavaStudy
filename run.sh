#!/usr/bin/env bash

ant publish && ant tomcat-restart

#rm -rf ./target/
#mvn package &&
#mv ./target/app-1.war ./target/app.war &&
#cp ./target/app.war $CATALINA_HOME/webapps &&
#${CATALINA_HOME}/bin/catalina.sh stop &&
#${CATALINA_HOME}/bin/catalina.sh start