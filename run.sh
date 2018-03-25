#!/bin/bash
if [ "$1" == "" ]; then
	echo "Please provide a file path of a CSV."
	exit 193
fi
filePath="$*"
className="app.Main"
mvn -q package
mvn exec:java -Dexec.mainClass="$className" -Dexec.args="$filePath"
