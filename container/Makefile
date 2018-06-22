TOPDIR = $(shell cd ..; pwd)
SERVICE_NAME=fantasy-football-server
SERVICE_TAG=0.01
include $(TOPDIR)/include/Makefile.inc


env:
	$(call get-build-env)

module: env
	$(call docker-run-build-container, mvn package)
	(cp ../target/fantasy-football-server-1.0-SNAPSHOT.jar ./)
	(cp ../config/server.yml ./)

build: module
	docker build -t $(SERVICE_NAME):$(SERVICE_TAG) .

test: env
	$(call docker-run-build-container, mvn test)

push: build
	docker tag $(SERVICE_NAME):$(SERVICE_TAG) $(DEPLOY_REGISTRY)/$(SERVICE_NAME):$(SERVICE_TAG)
	docker push $(DEPLOY_REGISTRY)/$(SERVICE_NAME):$(SERVICE_TAG)

clean: env
	$(call docker-run-build-container, mvn clean)
	rm -f *~ ../dependency-reduced-pom.xml fantasy-football-server-1.0-SNAPSHOT.jar server.yml