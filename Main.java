import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;



class CLIStockRetriever {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to the CLI Currency Convertor");
        System.out.println("=====================================\n\n");

        while (true){
            Scanner ticker = new Scanner(System.in);
            System.out.print("What is the starting Currency?: ");
            String starting = ticker.nextLine();
            if(starting.equals("EXIT")){
                System.out.println("\nGoodbye!");
                System.exit(0);
            }
            System.out.print("What is the ending Currency?: ");
            String ending = ticker.nextLine();

            System.out.print("What is the Amount?: $");
            int amount = ticker.nextInt();

            String url = String.format("https://api.exchangerate.host/convert?from=%s&to=%s&amount=%f&callback=result", starting, ending, amount);

            //API request
            String url_str = url;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("X-RapidAPI-Key", "2ccc7188camsh18158cd983ad020p1002b0jsn75cd7c208eab")
                    .header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println("\n\n=====================================\n");


            //JsonParser jp = new JsonParser();
            //JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            //JsonObject jsonobj = root.getAsJsonObject();

            //String req_result = jsonobj.get("result").getAsString();

        }
        }
}
