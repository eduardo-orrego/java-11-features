package org.duna.jep321.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class HttpClientDemo01 {

  public static void main(String[] args) {
    Logger logger = Logger.getLogger(HttpClientDemo01.class.getName());

    HttpClient httpClient = HttpClient.newHttpClient();

    URI requestURI = URI.create("https://dummyapi.online/api/users/1");
    HttpRequest request = HttpRequest.newBuilder()
      .uri(requestURI)
      .build();

    HttpResponse<String> response = null;
    int statusCode = 0;

    try {
      response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      statusCode = response.statusCode();
    } catch (IOException | InterruptedException e) {
      logger.warning("Interrupted!\n" + e);
      Thread.currentThread().interrupt();
    }

    if (statusCode == 200) {
      String responseBodyString = response.body();
      System.out.println("Response body: " + responseBodyString);
    } else {
      System.out.println("Error: Http Status Code " + statusCode);
    }

  }

}