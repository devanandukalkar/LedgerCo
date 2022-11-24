REM @echo off

REM mvn clean install -DskipTests assembly:single -q
REM java -jar target\geektrust.jar sample_input\input1.txt

REM for local machine test
mvn compile exec:java -DskipTests -Dexec.arguments="sample_input\test_input.txt"