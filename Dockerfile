FROM java:8
WORKDIR /build/libs
ADD /build/libs/parcelsizeservice.jar /build/libs/parcelsizeservice.jar
EXPOSE 8000
CMD java -jar parcelsizeservice.jar