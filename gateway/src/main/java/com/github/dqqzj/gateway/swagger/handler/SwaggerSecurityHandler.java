package com.github.dqqzj.gateway.swagger.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

import java.util.Optional;

/**
 * @author qinzhongjian
 * @date created in 2018/7/21 15:47
 * @since 1.0.0
 */
@Component
public class SwaggerSecurityHandler implements HandlerFunction {

    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(
                        Optional.ofNullable(securityConfiguration)
                                .orElse(new SecurityConfiguration(null,null,null,null,null,ApiKeyVehicle.HEADER,"api_key",","))));
    }

}
