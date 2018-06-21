TOPDIR = $(shell cd ..; pwd)

define docker-run-build-container
	@echo "running build container: docker run --rm -v $(TOPDIR):/build/ build-container bash -c $1"
	docker run -it --rm -v $(TOPDIR):/build/ --workdir=/build build-container $1
endef

define get-build-env
	docker pull docker.io/maven
	docker tag maven build-container
endef
