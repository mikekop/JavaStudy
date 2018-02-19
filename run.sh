#!/usr/bin/env bash

rm -rf ./out
mkdir out
javac -sourcepath ./src -d out ./src/ru/logrocon/shopwindow/Main.java &&
java -classpath ./out ru.logrocon.shopwindow.Main $1