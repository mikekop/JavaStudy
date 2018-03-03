#!/usr/bin/env bash

rm -rf ./target/

mvn package &&
cp ./target/app-1.war $CATALINA_HOME/webapps &&
${CATALINA_HOME}/bin/catalina.sh stop &&
${CATALINA_HOME}/bin/catalina.sh start