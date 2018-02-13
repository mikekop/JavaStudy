#!/usr/bin/env bash

javac -sourcepath ./src -d out ./src/ru/logrocon/lesson1/kitchen/Kitchen.java &&
java -classpath ./out ru.logrocon.lesson1.kitchen.Kitchen