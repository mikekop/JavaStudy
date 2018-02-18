#!/usr/bin/env bash

rm -rf ./out
mkdir out
javac -sourcepath ./src -d out ./src/ru/logrocon/kitchen/Kitchen.java &&
java -classpath ./out ru.logrocon.kitchen.Kitchen