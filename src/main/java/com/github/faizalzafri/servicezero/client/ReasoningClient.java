package com.github.faizalzafri.servicezero.client;

import org.springframework.web.client.RestClient;

public class ReasoningClient {
    private final RestClient  restClient;

    public ReasoningClient() {
        this.restClient = RestClient.create("http://localhost:8000");
    }

    public ServiceInfo fetchInfo() {
        return restClient.get()
                .uri("/info")
                .retrieve()
                .body(ServiceInfo.class);
    }
}
