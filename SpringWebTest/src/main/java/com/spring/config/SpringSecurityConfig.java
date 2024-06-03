package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String encodePass = passwordEncoder().encode("nimda");
		auth.inMemoryAuthentication().withUser("admin").password(encodePass).authorities("ROLE_ADMIN");
		auth.inMemoryAuthentication().withUser("user").password(encodePass).authorities("ROLE_ADMIN", "ROLE_USER");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//@formatter:off
		http.csrf(c-> c.disable());
		http.authorizeHttpRequests(r-> r
		 .requestMatchers("/login*").permitAll()
		 .requestMatchers("//**").hasAnyRole("USER","ADMIN")
		 .anyRequest().authenticated()
		 );
		
		http.formLogin(f->f.loginPage("/login.html").loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/home.html")
				.failureUrl("/login.html?error=true"))
				.logout(l-> l.logoutUrl("/perform_logout").deleteCookies("JSESSIONID"));
		
		http.sessionManagement(s-> s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).maximumSessions(1)
				.expiredUrl("/sessionExpiredPage.html"));
		

		//@formatter:on
		return http.build();
	}

}
