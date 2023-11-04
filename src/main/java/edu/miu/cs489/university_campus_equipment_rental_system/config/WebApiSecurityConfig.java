package edu.miu.cs489.university_campus_equipment_rental_system.config;


import edu.miu.cs489.university_campus_equipment_rental_system.filter.JWTAuthFilter;
import edu.miu.cs489.university_campus_equipment_rental_system.service.impl.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebApiSecurityConfig {
    private MyUserDetailsService myUserDetailsService;
    private JWTAuthFilter jwtAuthFilter;

    public WebApiSecurityConfig(MyUserDetailsService myUserDetailsService,
                                JWTAuthFilter jwtAuthFilter) {
        this.myUserDetailsService = myUserDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers("/api/addresses/**").permitAll()
                                    .requestMatchers("/api/equipments").hasRole("ADMIN")
                                    .requestMatchers("/api/students").permitAll()
                                    .requestMatchers("/api/transactions/**").permitAll()
                                    .requestMatchers("/api/equipment-types").permitAll()
                                    .requestMatchers("/api/faculties").permitAll()
                                    .requestMatchers("/api/graduate-students").permitAll()
                                    .requestMatchers("/api/manufacturers").hasRole("ADMIN")
                                    .requestMatchers("/api/erd-staff").authenticated();
                        }
                )
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
