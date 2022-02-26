package com.takaichi00.springreactivesample.infrastructure;

import org.springframework.stereotype.Service;

@Service
public class SampleWebClient {

  public String getHttpbin() {
    return "value1";
  }
}
