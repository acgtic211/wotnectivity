package es.ual.acg;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;

import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.URI;

public class HttpReq {

    private HttpClient client;

    public HttpReq() {
        this.client = HttpClient.newHttpClient();
    }

    public CompletableFuture sendPostRequest(String address, HashMap<String, String> headers, String payload) {
            

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
    
    public CompletableFuture sendPutRequest(String address, HashMap<String, String> headers, String payload) {


        List<String> headersArrayList =  new ArrayList<>();
        headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v);});
        String[] headersArray = new String[headersArrayList.size()];

        var request = HttpRequest.newBuilder()
                        .PUT(BodyPublishers.ofString(payload))
                        .uri(URI.create(address))
                        .headers(headersArrayList.toArray(headersArray))
                        .build();
                        
    
        return client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Error: " + e.getMessage());

    }

    public CompletableFuture sendDeleteRequest(String address, HashMap<String, String> headers) {

        List<String> headersArrayList =  new ArrayList<>();
        headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v);});
        String[] headersArray = new String[headersArrayList.size()];

        var request = HttpRequest.newBuilder()
                        .DELETE()
                        .uri(URI.create(address))
                        .headers(headersArrayList.toArray(headersArray))
                        .build();
                        
    
        return client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Error: " + e.getMessage());

    }

}