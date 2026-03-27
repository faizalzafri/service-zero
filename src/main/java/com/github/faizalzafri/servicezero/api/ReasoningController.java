package com.github.faizalzafri.servicezero.api;

import com.github.faizalzafri.servicezero.client.ReasoningClient;
import com.github.faizalzafri.servicezero.client.ServiceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ReasoningController {

    private final ReasoningClient client;

    public ReasoningController(ReasoningClient client) {
        this.client = client;
    }

    @GetMapping("/python-info")
    public CompletableFuture<ServiceInfo> pythonInfo() {
        return client.fetchInfo();
    }
}
