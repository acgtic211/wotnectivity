package es.ual.acg;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;

public class HttpReqTest{

    @Test
    public void TestPostReq() {
        String address = "https://postman-echo.com/post";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        HashMap<String, String> payload = new HashMap<>();
        payload.put("foo1","bar1");
        payload.put("foo2","bar2");
        HttpReq tester = new HttpReq();
        assertNotEquals(tester.sendPostRequest(address, headers, payload),"");
    }
}