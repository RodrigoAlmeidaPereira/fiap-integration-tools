#!/bin/bash



cd kafka-server 
bash run.sh &
cd ..

sleep 3
cd java-consumer/
rm -rf target
bash run.sh
cd ..

sleep 3
cd python-producer
bash run.sh

exit 0