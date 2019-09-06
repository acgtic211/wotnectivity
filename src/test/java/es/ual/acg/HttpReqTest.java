package es.ual.acg;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;

public class HttpReqTest{

    @Test
    public void TestPostReq() {
        String address = "https://postman-echo.com/post";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> headers2 = new HashMap<>();
        headers.put("content-type", "text/plain");
        headers.put("Authorization", "no me jodas");
        headers2.put("content-type", "application/json");
        headers2.put("Authorization", "no me jodas");
        String payload = "{\"body\":\"vaya tela\"}";

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendPostRequest(address, headers, payload).get();
            var response2 = tester.sendPostRequest(address, headers2, payload).get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestGetReq() {
        String address = "https://postman-echo.com/get?q=hola";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> headers2 = new HashMap<>();
        headers.put("content-type", "text/plain");
        headers.put("Authorization", "no me jodas");
        headers2.put("content-type", "application/json");
        headers2.put("Authorization", "no me jodas");

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendGetRequest(address, headers).get();
            var response2 = tester.sendGetRequest(address, headers2).get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestPutReq() {
        String address = "https://postman-echo.com/put?q=adios";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> headers2 = new HashMap<>();
        headers.put("content-type", "text/plain");
        headers.put("Authorization", "no me jodas");
        headers2.put("content-type", "application/json");
        headers2.put("Authorization", "no me jodas");
        String payload = "{\"body\":\"vaya tela\"}";

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendPutRequest(address, headers, payload).get();
            var response2 = tester.sendPutRequest(address, headers2, payload).get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestDeleteReq() {
        String address = "https://postman-echo.com/delete";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> headers2 = new HashMap<>();
        headers.put("content-type", "text/plain");
        headers.put("Authorization", "no me jodas");
        headers2.put("content-type", "application/json");
        headers2.put("Authorization", "no me jodas");

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendDeleteRequest(address, headers).get();
            var response2 = tester.sendDeleteRequest(address, headers2).get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}