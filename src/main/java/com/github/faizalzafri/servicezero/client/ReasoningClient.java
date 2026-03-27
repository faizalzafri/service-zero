package com.github.faizalzafri.servicezero.client;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.concurrent.CompletableFuture;

@Component
public class ReasoningClient {

    private final RestClient client = RestClient.create("http://localhost:8000");

    @Retry(name = "reasoningService", fallbackMethod = "fallback")
    @TimeLimiter(name = "reasoningService")
    public CompletableFuture<ServiceInfo> fetchInfo() {
        return CompletableFuture.supplyAsync(() -> client.get()
                .uri("/info")
                .retrieve()
                .body(ServiceInfo.class));
    }

    private CompletableFuture<ServiceInfo> fallback(Throwable ex) {
        ServiceInfo fallback = new ServiceInfo(
                "reasoning-service",
                "unavailable",
                "fallback"
        );
        return CompletableFuture.completedFuture(fallback);
    }
}