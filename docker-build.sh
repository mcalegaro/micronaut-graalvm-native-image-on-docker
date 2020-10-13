#!/bin/bash

docker build . -t mn

echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8090:8081 mn"
