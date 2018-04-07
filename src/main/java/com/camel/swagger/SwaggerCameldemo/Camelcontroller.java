package com.camel.swagger.SwaggerCameldemo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Camelcontroller {
	@GetMapping("/")
	public void ChangeFile() throws Exception
	{
		CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                from("file:resource/inbox").marshal().xmljson().to("file:resource/outbox");

            }
        });
        context.start();
        Thread.sleep(4000);
        context.stop();
	}
}
