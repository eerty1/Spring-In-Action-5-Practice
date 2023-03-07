//package tacos.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class ReactiveSecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
//        return serverHttpSecurity
//                    .authorizeExchange()
//                    .pathMatchers("/design", "/orders").hasAnyAuthority("USER")
//                    .anyExchange().permitAll()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                .and()
//                    .logout()
//                .and()
//                    .build();
//    }
//}
