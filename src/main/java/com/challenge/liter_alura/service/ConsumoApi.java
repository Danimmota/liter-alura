package com.challenge.liter_alura.service;

import com.challenge.liter_alura.dto.ResponseAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumoApi {

    private static final String ENDPOINT = "https://gutendex.com/books/";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    private final ConverteDados converteDados;

    public ConsumoApi(ConverteDados converteDados) {
        this.converteDados = converteDados;
    }

    public ResponseAPI obterDados(String tituloLivro) {
        try {
            String url = ENDPOINT + "?search=" + tituloLivro.replace(" ", "+");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro: A API retornou o status " + response.statusCode());
            }

            String json = response.body();

            return converteDados.obterDados(json, ResponseAPI.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir a API do Gutendex", e);
        }
    }
}