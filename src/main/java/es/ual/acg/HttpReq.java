package es.ual.acg;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.StringJoiner;

public class HttpReq {

    private HttpURLConnection con;

    public HttpReq() {

    }

    public String sendPostRequest(String address, HashMap<String, String> headers, HashMap<String, String> payload) {
        
        try {
            URL myurl = new URL(address);

            con = (HttpURLConnection) myurl.openConnection();
            con.setRequestMethod("POST");
            headers.forEach((k, v) -> con.setRequestProperty(k, v));
            StringJoiner sj = new StringJoiner("&");
            payload.forEach((k, v) -> {
                try {
                    sj.add(URLEncoder.encode(k, "UTF-8") + "=" + URLEncoder.encode(v, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });

            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            con.setFixedLengthStreamingMode(length);
            con.connect();
            try(OutputStream os = con.getOutputStream()) {
                os.write(out);
            }
            return con.getInputStream().toString();

        }catch(Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }finally {
            con.disconnect();
        }
    }

}