# fantasy-football
Basic framework for a server side implementation of a salary cap based fantasy football game

# Technical details 
Dropwizard for REST interface,  Google Guice for dependency injection, and mockito + junit for unit tests

# Build
```bash
cd container/
make build
```

# Deploy
```bash
docker run -d --net=host fantasy-football-server:0.01
```

