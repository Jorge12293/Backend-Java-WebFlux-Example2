package com.reactivespring.repository;

import reactor.core.publisher.Flux;
import com.reactivespring.domain.MovieInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieInfoRepository extends ReactiveMongoRepository<MovieInfo,String>{

    Flux<MovieInfo>findByYear(Integer year);

}
