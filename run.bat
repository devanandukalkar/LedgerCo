rem @echo off

rem mvn clean install -DskipTests assembly:single -q
rem java -jar target\geektrust.jar sample_input\input1.txt

REM for local machine test
mvn compile exec:java -DskipTests -Dexec.arguments="sample_input\input1.txt"