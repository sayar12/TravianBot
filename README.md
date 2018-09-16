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
 
 
### Configuration

The following parameters needs to be configured:
 
 * TRAVIAN_SERVER_URL: login url of your travian server
 * TRAVIAN_USERNAME: username for your travain account
 * TRAVIAN_PASSWORD: password for your travian account
 * PASSWORD: for the basic authentication to the website (default user is admin)
 
These parameters can be added to heroku or to your IntelliJ startup or passed as -D in the maven commands.

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
