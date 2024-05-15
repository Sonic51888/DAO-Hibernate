package ru.netology.daohibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .requestMatchers("/persons/find-by-name-surname").hasRole("ADMIN")
                .requestMatchers("/persons/save").hasRole("ADMIN")
                .requestMatchers("/persons/delete-by-id").hasRole("ADMIN")
                .requestMatchers("/persons/find-by-id").hasRole("USER")
                .requestMatchers("/persons/find-by-age-less-than").hasRole("USER")
                .requestMatchers("/persons/find-by-city").permitAll()
                .and()
                .formLogin();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

}