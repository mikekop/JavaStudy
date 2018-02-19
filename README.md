# JavaStudy

## Выдать права на запуск скрипта
```sh
$ chmod a+x run.sh
```

## Запуск по умолчанию (витрина)
```sh
$ ./run.sh
```
### Результат работы
```
Текущий тип хранилища: treeMap
        Заполняем хранилище: 1000000 элементов
        Время заполнения: 3079 мс.
        Поиск 1000000 случайных элементов
        Время поиска: 1223 мс.
Текущий тип хранилища: hashMap
        Заполняем хранилище: 1000000 элементов
        Время заполнения: 1458 мс.
        Поиск 1000000 случайных элементов
        Время поиска: 1197 мс.
```

## Для режима проверки очереди
```sh
$ ./run.sh testQueue
```
### Результат работы
```
В очередь 0aa3a8b0-14f4-4039-a921-8237f45bf271
В очередь aaeed2ee-54b8-4673-80df-9e8a566ecd5b
Из очереди 0aa3a8b0-14f4-4039-a921-8237f45bf271
В очередь da61c9b1-3488-4ef3-9eaf-88e7bc3f9cfe
В очередь c9fc4fed-26e0-4fa3-aba6-86b9768e6613
В очередь bcecf9f7-a708-44d3-9538-b8cc2c20f263
Из очереди aaeed2ee-54b8-4673-80df-9e8a566ecd5b
Из очереди da61c9b1-3488-4ef3-9eaf-88e7bc3f9cfe
Из очереди c9fc4fed-26e0-4fa3-aba6-86b9768e6613
В очередь 9e49208d-08c3-4a20-a319-5dedeb01dad4
Из очереди bcecf9f7-a708-44d3-9538-b8cc2c20f263
```

## Для режима проверки улучшения производительности 3-й задачи
```sh
$ ./run.sh task3
```
### Для получения только значений бенчмарка
```
```sh
$ ./run.sh task3 | grep ">"
```
```
>Заполнение на 1000 элементов
>До оптимизации: 47 мс.
>После оптимизации: 25 мс.
```