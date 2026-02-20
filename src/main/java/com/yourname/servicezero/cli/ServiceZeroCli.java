package com.yourname.servicezero.cli;

import com.yourname.servicezero.core.ServiceInfo;
import com.yourname.servicezero.core.ServiceInfoProvider;

public class ServiceZeroCli {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: service-zero <command>");
            return;
        }

        switch (args[0]) {
            case "info" -> printInfo();
            default -> System.out.println("Unknown command: " + args[0]);
        }


    }

    private static void printInfo() {
        ServiceInfoProvider provider = new ServiceInfoProvider();
        ServiceInfo info = provider.getInfo();
        System.out.println(info.name());
        System.out.println("Version: " + info.version());
        System.out.println("Java: " + info.javaVersion());
    }

}
