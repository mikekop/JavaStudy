#!/usr/bin/env bash

rm -rf ./out
mkdir out
if [ $1 = task3 ]
then
    javac -sourcepath ./src -d out ./src/ru/logrocon/task3/Main.java &&
    java -classpath ./out ru.logrocon.task3.Main
else
    javac -sourcepath ./src -d out ./src/ru/logrocon/shopwindow/Main.java &&
    java -classpath ./out ru.logrocon.shopwindow.Main $1
fi