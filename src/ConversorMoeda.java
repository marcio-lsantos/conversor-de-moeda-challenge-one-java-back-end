import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConversorMoeda {

    private String apiKey;
    private String baseUrl = "https://v6.exchangerate-api.com/v6/";
    private HttpClient httpClient;

    public ConversorMoeda(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
    }

    public JsonObject obterJsonDaApi(String moedaBase) throws IOException, InterruptedException {
        String urlStr = baseUrl + apiKey + "/latest/" + moedaBase;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(response.body());
            return root.getAsJsonObject();
        } else {
            System.err.println("Erro na requisição. Código de resposta: " + response.statusCode());
            return null;
        }
    }

    public Double obterTaxaEspecifica(JsonObject taxasJson, String moedaDestino) {
        if (taxasJson != null && taxasJson.has("conversion_rates")) {
            JsonObject conversionRates = taxasJson.getAsJsonObject("conversion_rates");
            if (conversionRates.has(moedaDestino)) {
                return conversionRates.get(moedaDestino).getAsDouble();
            } else {
                System.out.println("A moeda " + moedaDestino + " não foi encontrada nas taxas de câmbio.");
                return null;
            }
        } else {
            System.err.println("Objeto JSON de taxas de câmbio inválido.");
            return null;
        }
    }
}