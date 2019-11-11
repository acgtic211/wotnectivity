package es.ual.acg;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;

import es.ual.acg.utils.WsListener;

public class WsReq {

    private HttpClient client;
    private WebSocket wsConnection;
    private WebSocket.Listener listener;

    public WsReq(String address, WebSocket.Listener listener) {
        this.client = HttpClient.newHttpClient();
        this.listener = listener;
        this.wsConnection = this.client.newWebSocketBuilder().buildAsync(URI.create(address), this.listener).join();
        ;
        
    }
    public WsReq(String address) {
        this.client = HttpClient.newHttpClient();
        this.listener = new WsListener();
        this.wsConnection = this.client.newWebSocketBuilder().buildAsync(URI.create(address), this.listener).join();
        ;
        
    }

    public CompletableFuture<WebSocket> sendText(String text) {
        
        return this.wsConnection.sendText(text, true);
    }

    public CompletableFuture<WebSocket> sendClose(){

        return this.wsConnection.sendClose(WebSocket.NORMAL_CLOSURE, "Finished communication");
    }

}