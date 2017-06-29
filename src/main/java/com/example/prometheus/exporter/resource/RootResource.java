package com.example.prometheus.exporter.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RootResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        return "<html>"
               + "<head><title>Sample Exporter</title></head>"
               + "<body>"
               + "<h1>Sample Exporter</h1>"
               + "<p><a href='/metrics'>Metrics</a></p>"
               + "</body>"
               + "</html>";
    }
}
