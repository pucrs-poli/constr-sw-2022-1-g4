package com.jld.keycloackapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Component
@Configuration
@ConfigurationProperties(prefix = "rest.security")
public class SecurityProperties {

    private boolean enabled;
    private String apiMatcher;
    private Cors cors;
    private String issuerUri;

    public CorsConfiguration getCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(cors.getAllowedOrigins());
        corsConfiguration.setAllowedMethods(cors.getAllowedMethods());
        corsConfiguration.setAllowedHeaders(cors.getAllowedHeaders());
        corsConfiguration.setExposedHeaders(cors.getExposedHeaders());
        corsConfiguration.setAllowCredentials(cors.getAllowCredentials());
        corsConfiguration.setMaxAge(cors.getMaxAge());

        return corsConfiguration;
    }

    public static class Cors {

        private List<String> allowedOrigins;
        private List<String> allowedMethods;
        private List<String> allowedHeaders;
        private List<String> exposedHeaders;
        private Boolean allowCredentials;
        private Long maxAge;

        public Long getMaxAge() {
            return maxAge;
        }

        public Boolean getAllowCredentials() {
            return allowCredentials;
        }

        public List<String> getAllowedHeaders() {
            return allowedHeaders;
        }

        public List<String> getAllowedMethods() {
            return allowedMethods;
        }

        public List<String> getAllowedOrigins() {
            return allowedOrigins;
        }

        public List<String> getExposedHeaders() {
            return exposedHeaders;
        }

    }



}
