package com.reactivespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repository.MovieInfoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviesInfoService {

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    public Mono<MovieInfo> adMovieInfo(MovieInfo movieInfo) {
        return movieInfoRepository.save(movieInfo);
    }

    public Flux<MovieInfo> getAllMovieInfos() {
        return movieInfoRepository.findAll();
    }

    public Mono<MovieInfo> getMovieInfoById(String id) {
        return movieInfoRepository.findById(id);
    }

    public Mono<MovieInfo> updateMovieInfo(MovieInfo updatedMovieInfo, String id) {
        return movieInfoRepository.findById(id)
            .flatMap(movieInfo->{
                movieInfo.setCast(updatedMovieInfo.getCast());
                movieInfo.setName(updatedMovieInfo.getName());
                movieInfo.setRelease_date(updatedMovieInfo.getRelease_date());
                movieInfo.setYear(updatedMovieInfo.getYear());
                return movieInfoRepository.save(movieInfo);
            });
    }

    public Mono<Void> deleteMovieInfo(String id) {
        return movieInfoRepository.deleteById(id);
    }

    public Flux<MovieInfo> getMovieInfoByYear(Integer year) {
        return movieInfoRepository.findByYear(year);
    }

}
