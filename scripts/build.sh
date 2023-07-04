#!/bin/bash
# build greeting-service image from app/Dockerfile

# Get the directory of the current script
SCRIPT_DIR="$(dirname "$0")"

# Navigate to the app directory
cd "$SCRIPT_DIR/../app"

mvn clean install

docker build -t brnnai/greeting-service .
