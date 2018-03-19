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

### Alpha 0.1 Features - Released

* [x] Be able to loop through the file to get all the information from all the
      Cycling Events into POJOs.
* [x] Expose a REST API to enable the screen scraping to happen when this is called.
* [x] Parse a resource file to get the all information from an individual Cycling
      Event.
* [x] Possible to add Route URL Links from separate CSV File to the Cycling Event. 

### Version 1.0 Features - Released

* [x] Write the POJOs, from the parsed Resource File, into a local Postgres
      Database Using Spring Data.

### Version 1.1 Features - In Progress

* [x] Remove all the 2016 Parsing Code.
* [x] Remove all the 2016 Test Code and Resource Files.
* [ ] Be able to Screen Scrape directly from the Web Page.
* [ ] Parse the 2017 events into the Local Database.

### Version 2.0 Features

* [ ] Make a production Spring Profile to write Events into Heroku's PosgreSQL.

### Version 3.0 Features

* [ ] Patch the POJOs in the Database with new information gleamed from the
      screen scraping.

### Version 4.0 Features

* [ ] Set a Timer service that will gather the Event's Registration Link from
      the Events Page, to make the link available in the database for end user
      to use to sign up to the races.
