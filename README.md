# Cycling Ireland Events HTML Scraper

This project will Scrape and Parse the HTML from Cycling Ireland Events
into POJOs. Persist them in the database.

The POJOs will be useful for the
[Cycling Ireland Events REST Service](https://github.com/lukegjpotter/cycling-ireland-events-rest-service).

[![Build Status](https://travis-ci.org/lukegjpotter/cycling-ireland-events-html-scraper.svg?branch=master)](https://travis-ci.org/lukegjpotter/cycling-ireland-events-html-scraper)
[![Coverage Status](https://coveralls.io/repos/github/lukegjpotter/cycling-ireland-events-html-scraper/badge.svg?branch=master)](https://coveralls.io/github/lukegjpotter/cycling-ireland-events-html-scraper?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/59f4497115f0d71f1c237de2/badge.svg)](https://www.versioneye.com/user/projects/59f4497115f0d71f1c237de2)
[![Issue Count](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper/badges/issue_count.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper)
[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)


## Database and PhantomJsDriver Setup

Please follow the instruction on the [Setup page](https://github.com/lukegjpotter/cycling-ireland-events-rest-service/wiki/Setup)
of the *Cycling Ireland Events REST Service* wiki.

## Build, Run and Test

1. To Build and Run the Application, open a Terminal and use:  
   `./gradlew build bootRun`  
   To skip the tests, if they're failing, use:  
   `./gradlew build -x test`
1. To Test that the running Application is functional, open a new Terminal tab
   and use:  
   `curl localhost:8080/start`
1. To Stop the Application, in the first Terminal, use:  
   `ctrl+C`

## Current Status

For the current status, please check the [Project Tab](https://github.com/lukegjpotter/cycling-ireland-events-html-scraper/projects).

## API Documentation

Swagger Documentation is available via the Heroku app.  
For the [CyclingIrelandEventsHtmlScraperController](https://cyclingirelandeventscraper.herokuapp.com/swagger-ui.html).

The Postman Collection to make these calls is available: [BikeRaceIreland Scraper
](https://documenter.getpostman.com/view/3947605/RVnZgxhn).
