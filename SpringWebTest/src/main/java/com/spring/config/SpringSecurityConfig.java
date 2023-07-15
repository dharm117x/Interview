package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String encodePass = passwordEncoder().encode("nimda");
		auth.inMemoryAuthentication().withUser("admin").password(encodePass).authorities("ROLE_ADMIN");
		auth.inMemoryAuthentication().withUser("user").password(encodePass).authorities("ROLE_ADMIN","ROLE_USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		 
		http.authorizeRequests()
		     .antMatchers("/login*").permitAll()
		 	 .antMatchers("/**").hasAnyRole("USER","ADMIN")
		 	 
		 	 .anyRequest().authenticated()
		 	 .and()
		     
		 	 .formLogin()
		      .loginPage("/login.html")
		      .loginProcessingUrl("/perform_login")
//		      .successForwardUrl("/home.html")
		      .defaultSuccessUrl("/home.html")
//		      .successHandler(successHandler())
		      .failureUrl("/login.html?error=true")
//		      .failureHandler(authenticationFailureHandler())
		      .and()
		      .logout()
		      .logoutUrl("/perform_logout")
		      .deleteCookies("JSESSIONID");
//		      .logoutSuccessHandler(logoutSuccessHandler());
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.maximumSessions(1).expiredUrl("/sessionExpiredPage.html");
			
		}
		 	 
}
	
	
