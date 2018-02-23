#!/usr/bin/env bash

rm -rf ./out
mkdir out

packages=()

for i in ./src/ru/logrocon/*
    do
        if [ -f "$i/MainClass.java" ]
        then
            p=$(echo $i | cut -d '/' -f 5)
            packages+=(${p})
        fi
    done

count=${#packages[@]}
if [[ ${count} -eq 0 ]]
then
    echo "Не найдено пакетов для запуска"
    exit 1
fi

default_index=1
echo "Необходимо выбрать пакет для запуска"

for (( i=0, j=1; i<count; i++, j++ ))
    do
        p=${packages[i]}
        echo -e "\t$j. $p"
    done

read -p "Введите номер пакета [$default_index]:" index

if [[ -z ${index} ]]
then
    index=${default_index}
else
    if [[ ${index} -lt 1 ]] || [[ ${index} -gt ${count} ]]
    then
        echo "Номер введен неверно"
        exit 1
    fi
fi

index=${index}-1

javac -sourcepath ./src -d out ./src/ru/logrocon/${packages[index]}/MainClass.java &&
java -classpath ./out ru.logrocon.${packages[index]}.MainClass