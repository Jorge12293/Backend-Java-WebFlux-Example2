package com.learnreactiveprogramming.service;


import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {
    
    FluxAndMonoGeneratorService fluxAndMonoGeneratorServiceTest = 
        new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {
        // given

        // when
        var namesFlux = fluxAndMonoGeneratorServiceTest.namesFlux();

        // then
        StepVerifier.create(namesFlux)
            .expectNext("Alex","Ben","Chloe")
            .verifyComplete();
    }   

    
    
}