function down_app_container() {
    echo "Stoping docker-compose"
    docker-compose down
}

function delete_latest_docker_image() {
    echo "Deleting latest docker image..."
    docker rmi -f integration-tools-python-producer-ms:latest
}

function build_docker_image() {
    echo "Building docker image..."
    docker-compose build
}

function up_app_container() {
    echo "Starting docker-compose"
    docker-compose up
}

time (down_app_container)
time (delete_latest_docker_image)
time (build_docker_image)
time (up_app_container)

