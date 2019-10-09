package com.lallu.lal.downstreamCalls;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HttpsDownStreamCall {

  public String httpsCall(String url, String methodType){
    WebClient webClient = WebClient.builder()
        .baseUrl(url)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
    String clientResponse = webClient
        .method(HttpMethod.valueOf(methodType))
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .exchange()
        .block()
        .bodyToMono(String.class)
        .block();

    return clientResponse;
  }
}
