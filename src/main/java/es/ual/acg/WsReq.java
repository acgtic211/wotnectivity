package es.ual.acg;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;

public class WsReq {

    private HttpClient client;
    private WebSocket wsConnection;
    private WebSocket.Listener listener;

    public WsReq(String address, WebSocket.Listener listener) {
        this.client = HttpClient.newHttpClient();
        this.wsConnection = this.client.newWebSocketBuilder().buildAsync(URI.create(address), this.listener).join();
        ;
        this.listener = listener;
    }
    public WsReq(String address) {
        this.client = HttpClient.newHttpClient();
        this.wsConnection = this.client.newWebSocketBuilder().buildAsync(URI.create(address), this.listener).join();
        ;
        this.listener = new WsListener();
    }

    public CompletableFuture<WebSocket> sendText(String text) {
        
        return this.wsConnection.sendText(text, true);
    }

    public CompletableFuture<WebSocket> sendClose(){

        return this.wsConnection.sendClose(WebSocket.NORMAL_CLOSURE, "Finished communication");
    }

}