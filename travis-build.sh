#!/bin/bash
set -e

export EXIT_STATUS=0

./gradlew test || EXIT_STATUS=$?

echo "Tag: $TRAVIS_TAG"

if [[ $EXIT_STATUS -eq 0 && -n $TRAVIS_TAG && $TRAVIS_BRANCH == 'master' && $TRAVIS_PULL_REQUEST == 'false' ]]; then
    echo "Publishing to PWS" 
    
    ./grailsw war || EXIT_STATUS=$?

    ./gradlew -PcfUsername=$CF_USERNAME -PcfPassword=$CF_PASSWORD cfPush || EXIT_STATUS=$i
fi

exit $EXIT_STATUS
