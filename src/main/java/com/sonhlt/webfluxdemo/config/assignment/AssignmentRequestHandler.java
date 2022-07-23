package com.sonhlt.webfluxdemo.config.assignment;

import com.sonhlt.webfluxdemo.dto.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
public class AssignmentRequestHandler {

    public Mono<ServerResponse> generalHandler(ServerRequest serverRequest) {
        String op = serverRequest.headers().firstHeader("OP");
        switch (Objects.requireNonNull(op)) {
            case "+":
                return this.addHandler(serverRequest);
            case "-":
                return this.subtractHandler(serverRequest);
            case "*":
                return this.multiplyHandler(serverRequest);
            case "/":
                return this.divideHandler(serverRequest);
            default:
                return ServerResponse.badRequest().bodyValue("invalid operator!");
        }
    }

    public Mono<ServerResponse> addHandler(ServerRequest serverRequest) {
        int first = Integer.parseInt(serverRequest.pathVariable("first"));
        int second = Integer.parseInt(serverRequest.pathVariable("second"));

        return ServerResponse.ok().bodyValue(new Response(first + second));
    }

    public Mono<ServerResponse> subtractHandler(ServerRequest serverRequest) {
        int first = Integer.parseInt(serverRequest.pathVariable("first"));
        int second = Integer.parseInt(serverRequest.pathVariable("second"));

        return ServerResponse.ok().bodyValue(new Response(first - second));
    }

    public Mono<ServerResponse> multiplyHandler(ServerRequest serverRequest) {
        int first = Integer.parseInt(serverRequest.pathVariable("first"));
        int second = Integer.parseInt(serverRequest.pathVariable("second"));

        return ServerResponse.ok().bodyValue(new Response(first * second));
    }

    public Mono<ServerResponse> divideHandler(ServerRequest serverRequest) {
        int first = Integer.parseInt(serverRequest.pathVariable("first"));
        int second = Integer.parseInt(serverRequest.pathVariable("second"));
        if (second == 0) {
            return ServerResponse.badRequest().bodyValue("divided by 0!");
        }

        return ServerResponse.ok().bodyValue((double) first / (double) second);
    }
}
