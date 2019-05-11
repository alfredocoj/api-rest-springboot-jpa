# api-rest-springboot-jpa
API rest exemplo com spring-boot, JPA e MySQL.

# Docker

Gerar imagem docker do projeto spring.
```
mvn install dockerfile:build -DskipTests
```

Executar imagem docker:
```
docker run --rm -p 8082:8082 --cpus=3 --cpuset-cpus="5,6,7" --network="host" --name="festa" springio/festa
```