FROM openjdk:17-alpine
LABEL description="Echo Hydra Client Application"
EXPOSE 8081
COPY ./build/libs/hydra-client-0.0.1-SNAPSHOT.jar /opt/hydra-client-0.0.1-SNAPSHOT.jar 
WORKDIR /opt
ENTRYPOINT ["java","-jar","hydra-client-0.0.1-SNAPSHOT.jar"]
