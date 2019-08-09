package es.ual.acg;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;

import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.URI;

public class HttpReq {

    private HttpURLConnection con;

    public HttpReq() {

    }

    public CompletableFuture sendPostRequest(String address, HashMap<String, String> headers, String payload) {
            var client = HttpClient.newHttpClient();

            List<String> headersArrayList =  new ArrayList<>();
            headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v);});
            String[] headersArray = new String[headersArrayList.size()];

            
            var request = HttpRequest.newBuilder()
                            .POST(BodyPublishers.ofString(payload))
                            .uri(URI.create(address))
                            .headers(headersArrayList.toArray(headersArray))
                            .build();
                            
        
            return client.sendAsync(request, BodyHandlers.ofString())
                            .thenApply(HttpResponse::body)
                            .exceptionally(e -> "Error: " + e.getMessage());

    }

    public CompletableFuture sendGetRequest(String address, HashMap<String, String> headers) {
        var client = HttpClient.newHttpClient();

        List<String> headersArrayList =  new ArrayList<>();
        headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v);});
        String[] headersArray = new String[headersArrayList.size()];

        
        var request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(address))
                        .headers(headersArrayList.toArray(headersArray))
                        .build();
                        
    
        return client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Error: " + e.getMessage());

    }
}