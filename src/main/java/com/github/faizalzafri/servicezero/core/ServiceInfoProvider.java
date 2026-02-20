package com.github.faizalzafri.servicezero.core;

public class ServiceInfoProvider {

    public ServiceInfo getInfo() {
        return new ServiceInfo(
                "Service Zero",
                "0.0.1",
                System.getProperty("java.version")
        );
    }
}
