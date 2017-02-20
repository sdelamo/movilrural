#!/bin/bash
set -e

export EXIT_STATUS=0

./gradlew test || EXIT_STATUS=$?

echo "Tag: $TRAVIS_TAG"

if [[ $TRAVIS_BRANCH != master ]]; then exit 0
if [[ $TRAVIS_PULL_REQUEST == 'true' ]]; then exit 0

if [[ $EXIT_STATUS ]]; then

    echo "Checking if tag set"

    if [[-n "$TRAVIS_TAG"]]; then

        echo "Publishing to PWS" 

        ./grailsw war || EXIT_STATUS=$?

        if [[ $EXIT_STATUS ]]; then
            ./gradlew -PcfUsername=$CF_USERNAME -PcfPassword=$CF_PASSWORD cfPush || EXIT_STATUS=$i
        fi

    fi
fi
exit $EXIT_STATUS