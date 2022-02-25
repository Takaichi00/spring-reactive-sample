package com.takaichi00.springreactivesample.infrastructure;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleWebClientTest {

  protected final static WireMockServer wiremock = new WireMockServer(options().port(18080));

  @BeforeAll
  static void setupVariables() {
    wiremock.start();
    WireMock.configureFor(18080);
  }

  @BeforeEach
  void setUp() {
    wiremock.resetAll();
  }

  @AfterEach
  void restartWireMockServer() {
    if (!wiremock.isRunning()) {
      wiremock.start();
    }
  }

  @AfterAll
  static void tearDown() {
    wiremock.stop();
  }

  @Test
  void sampleTest() {
    wiremock.stubFor(get(urlEqualTo("/get"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("{\"item1\":\"value1\"}")));
  }
}
