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

    public CompletableFuture sendPostRequestPlain(String address, HashMap<String, String> headers, String payload) {
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


            /*
             * URL myurl = new URL(address);
             * 
             * con = (HttpURLConnection) myurl.openConnection(); con.setDoOutput(true);
             * con.setRequestMethod("POST"); headers.forEach((k, v) ->
             * con.setRequestProperty(k, v)); StringJoiner sj = new StringJoiner("&");
             * payload.forEach((k, v) -> { try { sj.add(URLEncoder.encode(k, "UTF-8") + "="
             * + URLEncoder.encode(v, "UTF-8")); } catch (UnsupportedEncodingException e) {
             * e.printStackTrace(); } });
             * 
             * byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8); int length =
             * out.length;
             * 
             * con.setFixedLengthStreamingMode(length); con.connect(); try(OutputStream os =
             * con.getOutputStream()) { os.write(out); }
             * 
             * int responceCode = con.getResponseCode();
             * 
             * if (responceCode == HttpURLConnection.HTTP_OK) { String line; BufferedReader
             * br = new BufferedReader(new InputStreamReader(con.getInputStream())); while
             * ((line = br.readLine()) != null) { response = ""; response += line; } } else
             * { response = ""; } return response;
             * 
             * }catch(Exception e) { e.printStackTrace(); return e.getMessage(); }finally {
             * con.disconnect(); }
             */
    }
}