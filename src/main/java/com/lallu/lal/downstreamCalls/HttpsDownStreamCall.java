package com.lallu.lal.downstreamCalls;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpsDownStreamCall {

  public Mono<String> httpsCall(String url, String methodType){

    ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
        .codecs(clientCodecConfigurer -> {
          clientCodecConfigurer.customCodecs().encoder(new Jackson2JsonEncoder());
          clientCodecConfigurer.customCodecs().decoder(new Jackson2JsonDecoder());
        })
        .build();


    WebClient webClient = WebClient.builder()
        .baseUrl(url)
        .exchangeStrategies(exchangeStrategies)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
    //    SslContext sslContext = SslContextBuilder.forClient().keyManager()
    return webClient
        .method(HttpMethod.valueOf(methodType))
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .exchange().block()
        .bodyToMono(String.class);

    /*  .body(BodyInserters.fromObject("{\n"
        + "\"payment_type\":\"credit_card\",\n"
        + "\"transaction_details\": {\n"
        + "   \"order_id\": \"C17604\",\n"
        + "   \"gross_amount\": 10000\n"
        + "},\n"
        + "\"credit_card\":{\n"
        + "    \"token_id\": \"481111-1114-1795591e-a0c7-48b0-992e-e453ce63ca75\",\n"
        + "       \"save_token_id\" : true,\n"
        + "    \"authentication\": true\n"
        + "}\n"
        + "}"))*/
  }
}
