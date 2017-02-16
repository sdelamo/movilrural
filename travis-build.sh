#!/bin/bash
set -e

export EXIT_STATUS=0

./gradlew test || EXIT_STATUS=$?

echo "Tag: $TRAVIS_TAG"

if [[ $EXIT_STATUS ]]; then
    if [[ ( $TRAVIS_BRANCH == master || $TRAVIS_TAG == prod_* ) && $TRAVIS_PULL_REQUEST == 'false' ]]; then
       echo "This will deploy!"
       echo "Publishing to PWS" 
       ./grailsw war || EXIT_STATUS=$?
       ./gradlew -PcfUsername=$CF_USERNAME -PcfPassword=$CF_PASSWORD cfPush || EXIT_STATUS=$i
    else
       echo "This will not deploy!"
    fi
fi
exit $EXIT_STATUS
