package com.sonhlt.webfluxdemo.config.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AssignmentRouterConfig {
    @Autowired
    AssignmentRequestHandler requestHandler;

    @Bean
    public RouterFunction<ServerResponse> highLevelServerResponseFunction() {
        return RouterFunctions.route()
                .GET("calculator/{first}/{second}", requestHandler::generalHandler)
                .build();
    }

}
