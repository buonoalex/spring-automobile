package org.learning.springautomobile.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .requestMatchers("/auto/admin/**").hasAuthority("ADMIN")
                .requestMatchers("/auto").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/acquistoCliente").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/admin/autoType/**").hasAuthority("ADMIN")
                .requestMatchers("/admin/acquistoRifornitore/**").hasAuthority("ADMIN")
                .requestMatchers("/", "/**", "/logout").permitAll()
                .and().formLogin().loginPage("/login").failureUrl("/login-error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").clearAuthentication(true).invalidateHttpSession(true)
                .and().exceptionHandling()
                .and().csrf().disable();

        return http.build();
    }


    @Bean
    public DatabaseUserDatailsService databaseUserDatailsService() {
        return new DatabaseUserDatailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(databaseUserDatailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
