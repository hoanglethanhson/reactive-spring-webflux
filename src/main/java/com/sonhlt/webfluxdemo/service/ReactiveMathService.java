package com.sonhlt.webfluxdemo.service;

import com.sonhlt.webfluxdemo.dto.MultiplyRequestDto;
import com.sonhlt.webfluxdemo.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {
    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }

    public Flux<Response> multiplicationTable(int input) {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                //.doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i -> System.out.println("reactive-math-service processing: " + i))
                .map(i -> input * i)
                .map(Response::new);
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> requestDto) {
        return requestDto
                .map(dto -> dto.getFirst() * dto.getSecond())
                .map(Response::new);
    }
}
