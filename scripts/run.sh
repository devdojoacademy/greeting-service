#!/bin/bash
SCRIPT_DIR="$(dirname "$0")"

"$SCRIPT_DIR"/build.sh

cd "$SCRIPT_DIR/../app"/

docker-compose up -d

cd "../client"/

http-server -c-1