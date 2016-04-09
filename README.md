# Cycling Ireland Events HTML Scraper
This project will Scrape and Parse the HTML from the Cycling Ireland Events into POJOs.
<br>The POJOs will be useful for the Cycling Ireland Events REST Service.

[![Build Status](https://travis-ci.org/lukegjpotter/cycling-ireland-events-html-scraper.svg?branch=master)](https://travis-ci.org/lukegjpotter/cycling-ireland-events-html-scraper)
[![Coverage Status](https://coveralls.io/repos/github/lukegjpotter/cycling-ireland-events-html-scraper/badge.svg?branch=master)](https://coveralls.io/github/lukegjpotter/cycling-ireland-events-html-scraper?branch=master)
[![Code Climate](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper/badges/gpa.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper)
[![Issue Count](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper/badges/issue_count.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-html-scraper)


### Version 0.1 Features - In Progress
Parse the Resource file to get the basic information from the initial Cycling Ireland Events page.
<br>Just the Event Titles, Date and Organiser Contact Details.

### Version 0.2 Features
Parse the Resource File to get the information on the different races/stages of the event, e.g. the start time and distance of the A4 Race.

### Version 1.0 Features
Write the POJOs, from the parsed Resource File, into the Database Using Spring Data and Heroku's PosgreSQL.

### Version 2.0 Features
* Be able to Screen Scrape directly from the Web Page.
* Expose a REST API to enable the screen scraping to happen when this is called.
* Patch the POJOs in the Database with new information gleamed from the screen scraping.

### Version 3.0 Features
Set a Timer service that will gather the Event's Regristration Link from the Events Page, to make the link available in the database for end user to use to sign up to the races.
