package com.example.prometheus.exporter.resource;

import java.io.IOException;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.prometheus.exporter.collector.SampleCollector;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.common.TextFormat;

@Path("/metrics")
public class MetricsResource {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CollectorRegistry collectorRegistry;

    public MetricsResource() {
        log.debug("MetricsResource#constructor");

        collectorRegistry = new CollectorRegistry();
        collectorRegistry.register(new SampleCollector());
    }

    @GET
    @Produces(TextFormat.CONTENT_TYPE_004)
    public String get() throws IOException {
        StringWriter writer = new StringWriter();
        TextFormat.write004(writer, collectorRegistry.metricFamilySamples());
        return writer.toString();
    }
}
