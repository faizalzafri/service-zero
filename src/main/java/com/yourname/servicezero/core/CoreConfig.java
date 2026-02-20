package com.yourname.servicezero.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    @Bean
    public ServiceInfoProvider serviceInfoProvider() {
        return new ServiceInfoProvider();
    }
}
