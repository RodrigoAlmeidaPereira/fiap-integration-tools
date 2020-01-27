#!/bin/bash

function down_app_container() {
    echo "Deleting latest running image"
    docker-compose down

    echo "Clean old java build"
    rm -rf java-consumer/target

    echo "Deleting latest docker image..."
    docker rmi -f integration-tools-python-producer-ms:latest
    docker rmi -f integration-tools-java-consumer-ms:latest
}

function build_application() {
    echo "Building java api..."
    cd java-consumer/
    mvn clean install  
    cd ..
}

function build_docker_image() {
    echo "Building docker image..."
    docker-compose build --compress --force-rm
}

function up_app_container() {
    echo "Deleting latest docker image"
    docker-compose up --force-recreate
}

time (down_app_container)
time (build_application)
time (build_docker_image)
time (up_app_container)