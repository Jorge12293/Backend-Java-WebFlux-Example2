package com.reactivespring.util;

import com.reactivespring.exception.MoviesInfoServerException;
import com.reactivespring.exception.ReviewsServerException;

import reactor.core.Exceptions;
import reactor.util.retry.Retry;
import java.time.Duration;

public class RetryUtil {
    
    public static Retry retrySpec(){
        return Retry.fixedDelay(3, Duration.ofSeconds(2))
            .filter(ex-> ex instanceof MoviesInfoServerException ||
                ex instanceof ReviewsServerException)
            .onRetryExhaustedThrow(((retryBackOffSpec,retrySignal)->
                Exceptions.propagate(retrySignal.failure())));
    }

}
