package com.reactivespring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MoviesInfoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "v1")
public class MoviesInfoController {
    
    @Autowired
    private MoviesInfoService moviesInfoService;

    @GetMapping("movie-infos")
    public Flux<MovieInfo> getAllMovieInfos() {
        return moviesInfoService.getAllMovieInfos();
    }
    
    @GetMapping("movie-infos/{id}")
    public Mono<MovieInfo> getAllMovieInfoById(@PathVariable String id) {
        return moviesInfoService.getMovieInfoById(id);
    }

    @PostMapping("movie-infos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovieInfo> addMovieInfo(@RequestBody @Valid MovieInfo movieInfo) {
        return moviesInfoService.adMovieInfo(movieInfo);
    }
    

    @PutMapping("movie-infos/{id}")
    public Mono<ResponseEntity<MovieInfo>> updateMovieInfo(@RequestBody MovieInfo movieInfo,@PathVariable String id) {
        return moviesInfoService.updateMovieInfo(movieInfo,id)
            .map(ResponseEntity.ok()::body)
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
    @DeleteMapping("movie-infos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMovieInfo(@PathVariable String id) {
        return moviesInfoService.deleteMovieInfo(id);
    }
}
