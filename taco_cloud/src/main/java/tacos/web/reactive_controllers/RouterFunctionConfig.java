//package tacos.web.reactive_controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//import tacos.data.reactive_jpa_repositories.ReactiveTacoRepository;
//import tacos.domain.Taco;
//
//import java.net.URI;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//import static org.springframework.web.reactive.function.server.ServerResponse.ok;
//import static reactor.core.publisher.Mono.just;
//
//@Configuration
//public class RouterFunctionConfig {
//
//    private ReactiveTacoRepository reactiveTacoRepository;
//
//    @Autowired
//    public RouterFunctionConfig(ReactiveTacoRepository reactiveTacoRepository) {
//        this.reactiveTacoRepository = reactiveTacoRepository;
//    }
//
//    @Bean
//    public RouterFunction<?> helloAndBuyRouterFunction() {
//        return route(GET("/hello"), request -> ok().body(just("Hello"), String.class))
//                .andRoute(GET("/bye"), request -> ok().body(just("Bye"), String.class));
//    }
//
//    @Bean
//    public RouterFunction<?> getPostTacosRouterFunction() {
//        return route(GET("/design/taco"), this::recent)
//                .andRoute(POST("/design"), this::postTaco);
//    }
//
//    public Mono<ServerResponse> recent(ServerRequest serverRequest) {
//        return ServerResponse.ok().body(reactiveTacoRepository.findAll().take(1), Taco.class);
//    }
//
//    public Mono<ServerResponse> postTaco(ServerRequest request) {
//        Mono<Taco> tacoFromRequest = request.bodyToMono(Taco.class);
//        Mono<Taco> savedTaco = tacoFromRequest.flatMap(taco -> reactiveTacoRepository.save(taco));
//        return ServerResponse.created(URI.create("http://localhost:8080/design/taco/" + savedTaco.subscribe(Taco::getName))).body(savedTaco, Taco.class);
//    }
//}
