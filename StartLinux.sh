#!/bin/bash
java -classpath ./bin logic/MapEditor
SETTINGS=`stty -g` 
stty -echo 
read -n 1 
stty $SETTINGS 
