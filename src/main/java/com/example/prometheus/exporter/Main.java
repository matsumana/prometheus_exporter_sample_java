package com.example.prometheus.exporter;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer().start();
        server.deploy(MyApp.class);

        log.info("exporter started.");
    }
}
