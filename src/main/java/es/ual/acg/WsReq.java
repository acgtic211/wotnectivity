package es.ual.acg;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

public class WsReq {


    private HttpClient client;

    public WsReq() {
        this.client = HttpClient.newHttpClient();
    }

    public CompletableFuture sendText(String address, String text) {
        
        var builder = client.newWebSocketBuilder().buildAsync(
	             URI.create(address),
                 new WebSocketClient()).join();;
                 
        return builder.sendText(text, false);
    }

}