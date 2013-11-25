all: build run

build:
	echo 'here1'
	gradle build

run:
	echo 'here2'
	java -jar build/libs/gs-serving-web-content-0.1.0.jar

clean:
	gradle clean
