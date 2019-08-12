# api-rest-springboot-jpa
API rest example with spring-boot, JPA and MySQL.

# Docker

Generate docker image of the spring project.
```
mvn install dockerfile:build -DskipTests
```

Run docker image:
```
docker run --rm -p 8082:8082 --cpus=3 --cpuset-cpus="5,6,7" --network="host" --name="festa" springio/festa
```
