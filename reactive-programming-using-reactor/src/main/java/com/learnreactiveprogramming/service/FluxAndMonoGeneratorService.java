package com.learnreactiveprogramming.service;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux(){
        return Flux.fromIterable(List.of("Alex","Ben","Chloe")).log();
    }

    public Mono<String> namesMono(){
        return Mono.just("Alex").log();
    }

    public Flux<String> namesFluxMap(){
        return Flux.fromIterable(List.of("Alex","Ben","Chloe"))
            .map(String::toUpperCase)
            .log();
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
    
        
        fluxAndMonoGeneratorService.namesFlux()
            .subscribe(name->{
                System.out.println("Name is :"+name);
            });

        fluxAndMonoGeneratorService.namesMono()
            .subscribe(name->{
                System.out.println("Mono Name is :"+name);
            });
        

        fluxAndMonoGeneratorService.namesFluxMap()
            .subscribe(name->{
                System.out.println("Name is :"+name);
            });

    }

}
