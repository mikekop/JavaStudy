export PATH=$PATH:"/c/Program Files/Java/jdk1.8.0_161/bin/"
rm -rf ./out
mkdir out
javac -sourcepath ./src -d out ./src/ru/logrocon/lesson2/Main.java
java  -classpath   ./out/ ru.logrocon.lesson2.Main 

read