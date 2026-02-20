package com.yourname.servicezero.api;

import com.yourname.servicezero.core.ServiceInfo;
import com.yourname.servicezero.core.ServiceInfoProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final ServiceInfoProvider provider;

    public InfoController(ServiceInfoProvider provider) {
        this.provider = provider;
    }

    @GetMapping("/info")
    public ServiceInfo info() {
        return provider.getInfo();
    }
}
