#!/bin/bash
set -e

export EXIT_STATUS=0

./gradlew check || EXIT_STATUS=$?

if [[ $EXIT_STATUS -eq 0 && $TRAVIS_BRANCH == 'master' && $TRAVIS_PULL_REQUEST == 'false' ]]; then
    echo "Publishing to PWS" 
fi

exit $EXIT_STATUS
