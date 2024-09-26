
package com.xiker.conceptOauth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Xiker
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.oauth2Login(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());
        //http.authorizeHttpRequests(c->c.anyRequest().authenticated());
        http.authorizeHttpRequests(
                c->c.requestMatchers("/internal").hasRole("INTERNAL")
                    .requestMatchers("/external").hasRole("EXTERNAL")
                    .requestMatchers("/").hasAnyRole("EXTERNAL","INTERNAL")
        );
        
        //
        return http.build();
    }
    
    
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails usuario = User.withUsername("paco")
                .password("123")
                .roles("INTERNAL")
                .build();
        return  new InMemoryUserDetailsManager(usuario);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    
    
    
    
    
}
