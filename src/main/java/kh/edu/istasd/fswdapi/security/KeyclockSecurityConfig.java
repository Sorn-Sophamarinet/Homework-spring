package kh.edu.istasd.fswdapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class KeyclockSecurityConfig {

    String ROLE_ADMIN = "ADMIN";
    String ROLE_USER = "USER";
    String ROLE_STAFF = "STAFF";
    String ROLE_CUSTOMER = "CUSTOMER";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //TODO
        // make all endpoints secured
        httpSecurity.authorizeHttpRequests(endpoints->
                endpoints
                        .requestMatchers(HttpMethod.POST,"api/v1/customers/**").hasAnyRole(ROLE_CUSTOMER, ROLE_ADMIN,ROLE_USER)
                        .requestMatchers(HttpMethod.PATCH,"api/v1/customers/**").hasAnyRole(ROLE_STAFF, ROLE_ADMIN,ROLE_USER)
                        .requestMatchers(HttpMethod.DELETE,"api/v1/customers/**").hasAnyRole(ROLE_ADMIN,ROLE_USER)
                        .requestMatchers(HttpMethod.GET,"api/v1/customers/**").hasAnyRole(ROLE_ADMIN, ROLE_CUSTOMER,ROLE_STAFF, ROLE_USER)
                        .requestMatchers("api/v1/accounts/**").hasAnyRole(ROLE_ADMIN, ROLE_CUSTOMER,ROLE_STAFF,ROLE_USER)
                        .requestMatchers("/media/**").permitAll()
                        .requestMatchers("/api/v1/medias/download/**").permitAll()
                        .anyRequest()
                        .authenticated()
        );
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);

        httpSecurity.oauth2ResourceServer(oauth2->{
            oauth2.jwt(Customizer.withDefaults());
        });

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(session->
                session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverterForKeyCloak() {
        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
            Map<String, Collection<String>> realMAccess = jwt.getClaim("realm_access");
            Collection<String> roles = realMAccess.get("roles");

            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        };

        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

        return jwtConverter;
    }

}
