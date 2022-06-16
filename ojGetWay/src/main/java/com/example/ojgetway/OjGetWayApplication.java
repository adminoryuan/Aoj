package com.example.ojgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class OjGetWayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("Aoj_route_ojServer",
                r -> r.path("/ojServer")
                        .filters(o->o.stripPrefix(1))
                        .uri("http://127.0.0.1:8080")).build();

        routes.route("Aoj_route_api",
                r -> r.path("/api/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://127.0.0.1:9991")).build();
        return routes.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(OjGetWayApplication.class, args);
    }

}
