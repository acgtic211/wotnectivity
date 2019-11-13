package es.ual.acg;

import org.junit.Test;

import es.ual.acg.utils.WsListener;

import static org.junit.Assert.*;




public class WsReqTest{

    String address = "wss://echo.websocket.org";
    String payload = "test";
    WsReq tester = new WsReq(new WsListener());
    WsReq tester2 = new WsReq();

    @Test
    public void TestWsReqSendText() {
        
        
        try{
            var response = this.tester.sendText(this.address, this.payload);

            System.out.println(response.toString());
            assertNotEquals(response,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestWsReqSendClose() {
        
        
        try{
            var response = this.tester.sendText(this.address, this.payload);
            System.out.println(response.get().toString());
            assertNotEquals(this.tester.sendClose().get().toString(),"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestWsReqSendTextDefaultListener() {
        
        
        try{
            var response = this.tester2.sendText(this.address, this.payload);

            System.out.println(response.toString());
            assertNotEquals(response,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

}


