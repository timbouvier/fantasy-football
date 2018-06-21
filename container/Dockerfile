FROM java

ADD fantasy-football-server-1.0-SNAPSHOT.jar /usr/local/bin/
ADD entrypoint.sh /
ADD server.yml /usr/local/bin

RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]