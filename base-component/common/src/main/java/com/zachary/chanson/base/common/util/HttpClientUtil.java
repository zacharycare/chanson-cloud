package com.zachary.chanson.base.common.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientUtil {

    public static void main(String[] args) {
        String uri = "";
        String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx4c64219d831d2c96&secret=7c6c5c0636b3a39ff387d30cee15c429&js_code=001sReWI1JdBo10HFBTI13LiWI1sReW3&grant_type=authorization_code";
        try {
            HttpResponse response = get(code2SessionUrl);
            System.out.println(response);
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpResponse get(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(uri)).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
