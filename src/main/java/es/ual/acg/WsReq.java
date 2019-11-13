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

    public WsReq(WebSocket.Listener listener) {
        this.client = HttpClient.newHttpClient();
        this.listener = listener;
        
    }
    public WsReq() {
        this.client = HttpClient.newHttpClient();
        this.listener = new WsListener();
        
    }

    public CompletableFuture<WebSocket> sendText(String address, String payload) {
        
        this.wsConnection = this.client.newWebSocketBuilder().buildAsync(URI.create(address), this.listener).join();;
        return this.wsConnection.sendText(payload, true);
    }

    public CompletableFuture<WebSocket> sendClose(){

        return this.wsConnection.sendClose(WebSocket.NORMAL_CLOSURE, "Finished communication");
    }

}