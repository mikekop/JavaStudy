#!/usr/bin/env bash

rm -rf ./out
mkdir out
javac -sourcepath ./src -d out ./src/ru/logrocon/lesson2/Main.java
java -classpath ./out/production/Kitchen ru.logrocon.lesson2.Main