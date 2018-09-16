# TravianBot

A bot for Travian (Web Game).



## Development

The application is written using:
 * Java (Spring)
 * Javascript (React)
 * [Font Awsome Icons](https://www.w3schools.com/icons/fontawesome_icons_brand.asp)



### Requisites

 * Install JDK 1.8
 * Install maven
 * Install npm

### Build & Run

#### Build on Travis

 [![Build Status](https://travis-ci.com/antonioalonzi/TravianBot.svg?branch=master)](https://travis-ci.com/antonioalonzi/TravianBot)

#### Build locally
    
Build js:

    npm install
    npm run build-dev

Run tests:
    
    mvn clean test
    npm run test

Run from command line:

    mvn spring-boot:run


## Deployment

Application is deployed at: https://travian-bot.herokuapp.com/

The deploy happens automatically after each commit on master if the build passed. 

 * Heroku: https://dashboard.heroku.com/apps/travian-bot
 * Travis CI: https://travis-ci.com/antonioalonzi/TravianBot
