package com.utbm.lo54.webapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class JsonFeignResponseHelper {
    private final ObjectMapper json = new ObjectMapper();

    public <T> Optional<T> decode(Response response, Class<T> clazz) {
        if(response.status() >= 200 && response.status() < 300) {
            try {
                return Optional.of(json.readValue(response.body().asReader(), clazz));
            } catch(IOException e) {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public <T, U> ResponseEntity<U> toResponseEntity(Response response, Class<T> clazz, Function<? super T, ? extends U> mapper) {
        Optional<U> payload = decode(response, clazz).map(mapper);

        return new ResponseEntity(
                payload.orElse(null),//didn't find a way to feed body with original content if payload is empty
                convertHeaders(response.headers()),
                HttpStatus.valueOf(response.status()));
    }

    public MultiValueMap<String, String> convertHeaders(Map<String, Collection<String>> responseHeaders) {
        MultiValueMap<String, String> responseEntityHeaders = new LinkedMultiValueMap<>();
        responseHeaders.entrySet().stream().forEach(e ->
                responseEntityHeaders.put(e.getKey(), new ArrayList<>(e.getValue())));
        return responseEntityHeaders;
    }
}
