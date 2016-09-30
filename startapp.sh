#!/bin/sh
server="npm run backend"
angular="npm start"

cd frontend/
npm install
$server &
$angular &