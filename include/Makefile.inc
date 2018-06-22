TOPDIR = $(shell cd ..; pwd)

define docker-run-build-container
	docker run -it --rm -v $(TOPDIR):/build/ --workdir=/build build-container $1
endef

define get-build-env
	docker pull docker.io/maven
	docker tag maven build-container
endef
