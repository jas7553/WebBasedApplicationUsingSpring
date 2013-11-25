all: build run

build:
	gradle build

run:
	java -jar build/libs/gs-serving-web-content-0.1.0.jar

clean:
	gradle clean
