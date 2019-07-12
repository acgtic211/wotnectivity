package es.ual.acg;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;

public class HttpReqTest{

    @Test
    public void TestPostReq() {
        String address = "https://postman-echo.com/post";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", "text/plain");
        headers.put("Authorization", "no me jodas");
        String payload = "foo";
        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendPostRequestPlain(address, headers, payload).get();
            System.out.println(response);
            assertNotEquals(response,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}