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
