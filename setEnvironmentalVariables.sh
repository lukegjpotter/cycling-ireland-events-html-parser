#!/usr/bin/env bash

# Set Database URL for local testing
echo " [info] Setting DATABASE_URL"
export DATABASE_URL=postgres://postgres:@localhost:5432/cyclingirelandevents
echo " [info] Set DATABASE_URL to $DATABASE_URL"
