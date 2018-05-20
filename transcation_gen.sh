#!/usr/bin/env bash
while sleep 5;
do
   timeStamp=$(($(date +%s"000"))) #For Get time into millisecond
   val=$RANDOM
   curl -d '{"amount": '${val}', "timestamp": '${timeStamp}'}' -H "Content-Type: application/json" -X POST http://localhost:8080/transactions
done