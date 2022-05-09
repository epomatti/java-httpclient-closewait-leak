# java-http-close-wait


```sh
export JAVA_HOME='/opt/java/jdk-11.0.15+10'
```

```sh
export JAVA_HOME='/opt/java/jdk-11.0.5'
```

Server:

```sh
cd server

mvn install
mvn compile exec:java

mvn exec:java -pl server
mvn exec:java -pl client
```

Client:

```sh
cd server

mvn install
mvn compile exec:java
```

```sh
ss -np | grep '<PID>'
```