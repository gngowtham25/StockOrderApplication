#!/bin/sh

INPUT=$1

if [ "$INPUT" == "prod" ]; then
   java -jar out/artifacts/StockOrderApplication_jar/StockOrderApplication.jar
elif [ "$INPUT" == "Compile" ]; then
    cd src
    javac StockOrderMain.java
fi