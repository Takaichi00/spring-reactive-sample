package com.takaichi00.springreactivesample.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Profile("test")
public class TestSampleWebClientConfig {

  @Bean
  public WebClient httpBinWebClient(ClientHttpConnector clientHttpConnector) {
    return WebClient
        .builder()
        .baseUrl("http://localhost:18080")
        .clientConnector(clientHttpConnector)
        .defaultHeader(HttpHeaders.SET_COOKIE, "test-cookie")
        .build();
  }
}
