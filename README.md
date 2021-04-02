# Tdd practice starter
TDD practice done into XP course using Cucumber. 

# Start app

Mysql database and Sonarque can be started using 
`docker-compose up -d`

To connect to mysql database: `mysql -h 127.0.0.1 -u course -P 3306 -p course`

To stop docker: `docker-compose down -d`

To start application : `mvn spring-boot:run`

# Doing a new test

Include new cucumber test in [this folder](src/test/resources/features)

All tests run over H2 database, so it's not needed to start mysql database

# Some examples

Examples are in different branchs:

## 01-issue-creation-without-test

All classes related to issue but without cucumber tests

## 02-issue-creation-final

All classes related to issue with creation issue cucumber tests

## 03-issue-close-open-final

All classes related to issue with closing and opening actions over an issue cucumber tests
