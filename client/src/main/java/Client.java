import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Client {

  public static void main(String[] args) throws Exception {
    System.out.println(System.getProperty("java.runtime.version"));
    System.out.println("App is running... pid: " + ProcessHandle.current().pid());
    HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();
    for (int i = 0; i < 10; ++i) {
      HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/")).build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      System.out.println(String.format("Response HTTP status: %s", response.statusCode()));
    }
    System.out.println("Finish");
    System.in.read();
  }
}