rms v0.1
========

Application Source Code & Checking runable

1. download playframework 1.6 (JDK1.7)
http://downloads.typesafe.com/play/1.2.6/play-1.2.6.zip

2. config the PATH variable

3. create database rms

4. run the rms.sql to setup the database rms

5. use git to checkout the project

6. use the command line to run the application
>cd rms
>play run

7. If it started successfully, you may access http://localhost:8080
username / password: 1 / 1

Eclipse setup

1. use the command line to setup the eclipse project
>cd rms
>play ec

2. Once you finish the step, you can use eclipse to import the project

3. please DO NOT check in the generated folders. Different user likes different IDE, so just keep the project as clean as we can. Currently the nessesary folders are:

app  (All the Java source code)
test (Junit test case)
conf (properties files, eg, db connection, url path)
lib  (3rd parties dependent liberaries)
public (All the javascript, css and images)
