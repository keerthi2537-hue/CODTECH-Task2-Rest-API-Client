package keerthi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {

    public static void main(String[] args) {

        try {
            // API URL
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Print response
            System.out.println("API Response:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Error while calling REST API");
            e.printStackTrace();
        }
    }
}
