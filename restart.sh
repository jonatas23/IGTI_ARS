#!/bin/bash
option="${1}"
case ${option} in
-config)
  echo "Build Config-Server"
  cd ./config-server
  mvn clean install -DskipTests
  echo "Restart container Config-Server"
  docker container kill config-server
  docker container rm config-server
  docker-compose -f "..\docker-compose.yml" up -d config-server
  ;;
-discovery)
  echo "Build service-discovery"
  cd ./service-discovery
  mvn clean install -DskipTests
  echo "Restart container service-discovery"
  docker container kill discovery
  docker container rm discovery
  docker-compose -f "..\docker-compose.yml" up -d discovery
  ;;
-user)
  echo "Build user"
  cd ./user
  mvn clean install -DskipTests
  echo "Restart container user"
  docker stop user
  docker rm user
  docker build -t user --link config-server --link discovery -p 9002:9002
  ;;
-auth)
  echo "Build auth"
  cd ./auth
  mvn clean install -DskipTests
  echo "Restart container auth"
  docker stop auth
  docker rm auth
  docker build -t auth --link config-server --link discovery --link user -p 9004:9004
  ;;
-consumidor)
  echo "Build consumidor"
  cd ./consumidor
  mvn clean install -DskipTests
  echo "Restart container consumidor"
  docker stop consumidor
  docker rm consumidor
  docker build -t consumidor --link config-server --link discovery --link db -p 8082:8082
  ;;
-prestadorservico)
  echo "Build prestadorservico"
  cd ./prestadorservico
  mvn clean install -DskipTests
  echo "Restart container prestadorservico"
  docker stop prestadorservico
  docker rm prestadorservico
  docker build -t prestadorservico --link config-server --link discovery -p 8081:8081
  ;;
-gateway)
  echo "Build gateway"
  cd ./gateway
  mvn clean install -DskipTests
  echo "Restart container gateway"
  docker container kill gateway
  docker container rm gateway
  docker-compose -f "..\docker-compose.yml" up --force-recreate -d gateway
  ;;

*)
  echo "Use exemplos:"
  echo "sh $(basename ${0}) -config"
  echo "sh $(basename ${0}) -gateway"
  echo "sh $(basename ${0}) -consumidor"
  echo "sh $(basename ${0}) -prestadorservico"
  exit 1 # Command to come out of the program with status 1
  ;;
esac
