#!/usr/bin/env bash

rm -rf ./out
mkdir out
javac -sourcepath ./src -d out ./src/ru/logrocon/lesson1/kitchen/Kitchen.java &&
java -classpath ./out ru.logrocon.lesson1.kitchen.Kitchen