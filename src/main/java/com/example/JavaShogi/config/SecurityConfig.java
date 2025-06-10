package com.example.JavaShogi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/login", "/public/**").permitAll()  // 誰でもOKなパス
        .anyRequest().authenticated()              // それ以外は認証必須
      )
      .formLogin(form -> form
        .loginPage("/login")                        // ログイン画面URL
        .permitAll()
      )
      .logout(logout -> logout.permitAll());
      
    return http.build();
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public UserDetailsService userDetailsService() {
      UserDetails user = User.withUsername("user")
              .password(passwordEncoder().encode("password"))
              .roles("USER")
              .build();
      return new InMemoryUserDetailsManager(user);
  }

}
