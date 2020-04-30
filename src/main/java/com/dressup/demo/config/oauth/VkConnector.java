package com.dressup.demo.config.oauth;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

@Component
public class VkConnector {

    @Value("${vk.app.client-id}")
    private String APP_ID;

    @Value("${vk.app.security-key}")
    private String SECURITY_KEY;


    public URL getLoginUrl() throws MalformedURLException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("http://oauth.vk.com/authorize?client_id=")
                .append(APP_ID)
                .append("&redirect_uri=")
                .append("localhost")
                .append(MvcUriComponentsBuilder.fromMappingName("MC#enterWithVk").build())
                .append("&response_type=code&scope=email,photos&v=5.103");

        return new URL(urlBuilder.toString());

    }
    public URL getPhotoUrl() throws MalformedURLException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("http://oauth.vk.com/authorize?client_id=")
                .append(APP_ID)
                .append("&redirect_uri=")
                .append("localhost")
                .append(MvcUriComponentsBuilder.fromMappingName("MC#enterWithVk").build())
                .append("&response_type=code&scope=email,photos&v=5.103");

        return new URL(urlBuilder.toString());

    }

    public URL getAccessToken(String code) throws MalformedURLException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://oauth.vk.com/access_token?client_id=")
                .append(APP_ID)
                .append("&client_secret=")
                .append(SECURITY_KEY)
                .append("&code=")
                .append(code)
                .append("&redirect_uri=localhost")
                .append(MvcUriComponentsBuilder.fromMappingName("MC#enterWithVk").build());
        return new URL(urlBuilder.toString());
    }

    public String sendRequest(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        String content = getContent(url);
        return content;
    }

    private String getContent(URL url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }
}