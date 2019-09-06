package es.ual.acg;

import org.junit.Test;

import static org.junit.Assert.*;

import java.net.http.WebSocket;
import java.util.HashMap;

public class WsReqTest{

    @Test
    public void TestWsReq() {
        String address = "wss://echo.websocket.org";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> headers2 = new HashMap<>();
        headers.put("content-type", "text/plain");
        headers.put("Authorization", "no me jodas");
        headers2.put("content-type", "application/json");
        headers2.put("Authorization", "no me jodas");
        
        String payload = "test";

        WsReq tester = new WsReq();
        
        try{
            var response = (WebSocket)tester.sendText(address, payload).get();
            var response2 = (WebSocket)tester.sendText(address, payload).get();  
            response.sendClose(505, "vaya");
            assertNotEquals(response,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

}


