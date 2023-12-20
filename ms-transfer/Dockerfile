
FROM openjdk:15-alpine
COPY ./target/AccToAccAPI-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
#  ---- build

ENTRYPOINT ["java"]
CMD ["-jar", "/app/AccToAccAPI-0.0.1-SNAPSHOT.jar"]

