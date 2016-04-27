# Cycling Ireland Events HTML Scraper

This project will Scrape and Parse the HTML from the Cycling Ireland Events
into POJOs.

The POJOs will be useful for the Cycling Ireland Events REST Service.

[![Build Status](https://travis-ci.org/lukegjpotter/cycling-ireland-events-html-scraper.svg?branch=master)](https://travis-ci.org/lukegjpotter/cycling-ireland-events-html-scraper)
[![Coverage Status](https://coveralls.io/repos/github/lukegjpotter/cycling-ireland-events-html-scraper/badge.svg?branch=master)](https://coveralls.io/github/lukegjpotter/cycling-ireland-events-html-scraper?branch=master)
[![Issue Count](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper/badges/issue_count.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper)

## Build, Run and Test

1. To Build and Run the Application, open a Terminal and use:  
`./gradlew build && java -jar build/libs/cycling-ireland-events-html-scraper-*.jar`
1. To Test that the running Application is functional, open a new Terminal tab
and use:  
`curl localhost:8080/start`
1. To Stop the Application, in the first Terminal, use:  
`ctrl+C`

### Alpha Features - In Progress

* Parse a resource file to get the all information from an individual Cycling
Event.
* Be able to loop through the file to get all the information from all the
Cycling Events into POJOs

### Version 1.0 Features

Write the POJOs, from the parsed Resource File, into the Database Using Spring
Data and Heroku's PosgreSQL.

### Version 2.0 Features

* Be able to Screen Scrape directly from the Web Page.
* Expose a REST API to enable the screen scraping to happen when this is called.
* Patch the POJOs in the Database with new information gleamed from the screen
scraping.

### Version 3.0 Features

Set a Timer service that will gather the Event's Registration Link from the
Events Page, to make the link available in the database for end user to use to
sign up to the races.
