package com.github.faizalzafri.servicezero.api;

import com.github.faizalzafri.servicezero.client.ReasoningClient;
import com.github.faizalzafri.servicezero.client.ServiceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReasoningController {

    private final ReasoningClient reasoningClient = new ReasoningClient();

    @GetMapping("/python-info")
    public ServiceInfo getServiceInfo() {
        return reasoningClient.fetchInfo();
    }
}
