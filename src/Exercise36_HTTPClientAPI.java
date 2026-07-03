import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exercise36_HTTPClientAPI {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.github.com/users/octocat"))
                    .GET()
                    .build();
            
            System.out.println("Sending request to GitHub API...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Response Status Code: " + response.statusCode());
            System.out.println("\nResponse Body:");
            System.out.println(response.body());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
