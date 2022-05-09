# Java HttpClient CLOSE_WAIT Troubleshoot

Sample project to track [JDK-8221395](https://bugs.openjdk.java.net/browse/JDK-8221395) and [JDK-8236596](https://bugs.openjdk.java.net/browse/JDK-8236596) bug fixes.

Download the desired distributions from the [archive](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) to test the scenarios. Reference:



- `jdk-11.0.5` - Bug reported
- `jdk-11.0.6` - Fix backported from JDK 13
- `jdk-11.0.15+10` - Most recent version (as of today)



Get the dependencies and compile the project:

```sh
mvn install
mvn compile
```

Set the `JAVA_HOME` environment according to the desired test. Must be set on both client and server bash sessions.


```sh
# Issue should happen
export JAVA_HOME='/opt/java/jdk-11.0.5'

# Issue should NOT happen
export JAVA_HOME='/opt/java/jdk-11.0.15+10'
```

Execute the code to generate the connections:

```sh
# Start the mock server
mvn exec:java -pl server

# Trigger client connections using HttpClient
mvn exec:java -pl client
```


Display connections to check if they are in a lock state:

```sh
ss -np | grep '<PID>'
```