package ru.kustikov.cakes.configuration;

//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Configuration
//@EnableGlobalAuthentication
//@Slf4j
//public class SecurityConfiguration {

    /**
     * Настраиваем доступ к API сервиса.
     */
//    @Bean
//    public SecurityFilterChain resources(
//            HttpSecurity http
//    ) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> {
////                    addPermitAllEndpoint(authorize, applicationConfiguration);
//                    // все остальные запросы - только для аутентифицированных пользователей
//                    authorize
//                            .anyRequest()
//                            .authenticated();
//                }).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//
//        return http.build();
//    }

    /**
     * Добавляем URL из конфига в список игнорируемых Spring Security.
     */
//    private void addPermitAllEndpoints(
//            AuthorizeHttpRequestsConfigurer<?>.AuthorizationManagerRequestMatcherRegistry authorize,
//            ApplicationConfiguration applicationConfiguration
//    ) {
//        List<SpringSecurityEndpointIgnoreConfig> toIgnore = Optional.of(applicationConfiguration)
//                .map(ApplicationConfiguration::springSecurityEndpointsIgnore)
//                .orElseGet(Collections::emptyList);
//        for (SpringSecurityEndpointIgnoreConfig ignoreConfig : toIgnore) {
//
//            String antMatcher = ignoreConfig.antMatcher();
//            if (StringUtils.isBlank(antMatcher)) {
//                throw new RuntimeException("Found empty spring security ignore config!");
//            }
//
//            HttpMethod method = ignoreConfig.method();
//            if (method == null) {
//                log.warn("Allow any HTTP request for URL '{}' to anyone!", antMatcher);
//                authorize
//                        .antMatchers(antMatcher)
//                        .permitAll();
//            } else {
//                log.warn("Allow HTTP '{}' request for URL '{}' to anyone!", method, antMatcher);
//                authorize
//                        .antMatchers(method, antMatcher)
//                        .permitAll();
//            }
//        }
//    }
//}
