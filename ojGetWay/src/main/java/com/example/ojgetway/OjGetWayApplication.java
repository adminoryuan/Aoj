package com.example.ojgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OjGetWayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("Aoj_route_ojServer",
                r -> r.path("/ojServer")
                        .uri("http://127.0.0.1:8080")).build();

        routes.route("Aoj_route_api",
                r -> r.path("/api")
                        .uri("http://127.0.0.1:9991")).build();
        return routes.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(OjGetWayApplication.class, args);
    }

}
