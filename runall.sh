#!/bin/bash

function down_app_container() {
    echo "Deleting latest running image"
    docker-compose rm -svf

    echo "Clean old java build and logs"
    rm -rf ./java-consumer/target
    rm -f ./java-consumer/logs

    echo "Deleting kafka workspace"
    rm -rf ./kafka-server/zk-single-kafka-single

}

function build_application() {
    cd kafka-server
    docker-compose up &
    cd ..

    sleep 3

    echo "Building java api..."
    cd java-consumer/
    mvn clean install  
    cd ..

    sleep 3

    cd kafka-server
    docker-compose rm -svf
    cd ..
}

function build_docker_image() {
    echo "Building docker image..."
    docker-compose build 
}

function up_app_container() {
    echo "Running docker compose"
    docker-compose up --force-recreate &
}

function up_app_python_container() {
    echo "Running python docker compose"
    sleep 100
    docker-compose restart integration-tools-python-producer-ms
}

time (down_app_container)
time (build_application)
time (build_docker_image)
time (up_app_container)
time (up_app_python_container)


