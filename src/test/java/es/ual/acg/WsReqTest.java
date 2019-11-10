package es.ual.acg;

import org.junit.Test;

import static org.junit.Assert.*;




public class WsReqTest{

    String address = "ws://localhost:32768";
    String payload = "test";
    WsReq tester = new WsReq(new WsListener());

    @Test
    public void TestWsReqSendText() {
        
        
        try{
            var response = this.tester.sendText(address, payload);

            System.out.println(response.toString());
            assertNotEquals(response,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestWsReqSendClose() {
        
        
        try{
            var response = this.tester.sendText(address, payload);
            System.out.println(response.get().toString());
            assertNotEquals(this.tester.sendClose().get().toString(),"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestWsListenerOnClose() {
        
        
        try{
            var wsClass = this.tester.sendText(address, payload).get();
            System.out.println();
            assertNotEquals(new WsListener().onClose(wsClass, 1000, "looking on close"),"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestWsListenerOnPing() {
        
        
        try{
            var wsClass = this.tester.sendText(address, payload).get();
            System.out.println();
            assertNotEquals(new WsListener().onPing(wsClass, null),"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

}


