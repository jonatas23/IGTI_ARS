#!/bin/bash
echo "Build Config-Server"
cd ./config-server
mvn clean install -DskipTests

echo "Build service-discovery"
cd ../service-discovery
mvn clean install -DskipTests

echo "Build user"
cd ../user
mvn clean install -DskipTests

echo "Build auth"
cd ../auth
mvn clean install -DskipTests

echo "Build consumidor"
cd ../consumidor
mvn clean install -DskipTests

echo "Build prestadorservico"
cd ../prestadorservico
mvn clean install -DskipTests

echo "Build gateway"
cd ../gateway
mvn clean install -DskipTests

echo "Create data..."
mkdir -p ./DATA

echo "Create network..."
docker network create back-network

echo "Docker-compose..."
docker-compose up --build --force-recreate -d
