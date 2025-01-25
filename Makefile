run-compose: build-java
	docker compose up -d

build-java:
	cd collector/java && ./gradlew bootBuildImage