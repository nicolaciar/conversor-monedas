package com.nicolaciar.conversormonedas.externo;

import com.google.gson.Gson;
import com.nicolaciar.conversormonedas.dto.TasaDeCambioDto;
import com.nicolaciar.conversormonedas.modelo.Divisa;
import com.nicolaciar.conversormonedas.modelo.TasaDeCambio;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPIConversor implements Conversor{


    private final Gson gson = new Gson();
    Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("API_KEY_CONVERSOR");;
    private final HttpClient client = HttpClient.newHttpClient();


    @Override
    public TasaDeCambio obtenerTasa(Divisa desde, Divisa hacia) {

        if (apiKey == null) {
            throw new IllegalStateException("API key no configurada.");
        }

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                + desde.codigo() + "/" + hacia.codigo();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);
            TasaDeCambioDto tasaDto = gson.fromJson(json, TasaDeCambioDto.class);
            return new TasaDeCambio(tasaDto.conversion_rate());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
