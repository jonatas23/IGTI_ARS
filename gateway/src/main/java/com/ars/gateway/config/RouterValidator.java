package com.ars.gateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public List<String> getOpenApiEndpoints() {
        List<String> openApiEndpoints = new ArrayList<>();
        openApiEndpoints.add("/auth/register");
        openApiEndpoints.add("/auth/login");
        return openApiEndpoints;
    }

    public Predicate<ServerHttpRequest> isSecured =
            request -> getOpenApiEndpoints()
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
