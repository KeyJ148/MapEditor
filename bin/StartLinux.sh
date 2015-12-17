#!/bin/bash
java logic/MapEditor
SETTINGS=`stty -g` 
stty -echo 
read -n 1 
stty $SETTINGS 
