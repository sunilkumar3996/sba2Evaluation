package com.eval.coronakit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource);
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http.authorizeRequests() 
		.antMatchers("/").permitAll()
		.antMatchers("/home").hasAnyRole("ADMIN","USER")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/admin/**").hasRole("ADMIN")
	.and() 
		.formLogin() 
		.loginPage("/custom-login") 
		.loginProcessingUrl("/validate")
		.defaultSuccessUrl("/home")
		.permitAll() 
	.and()
		.logout() 
		.permitAll()
	.and()
		.exceptionHandling()
			.accessDeniedPage("/custom-error");
	}
}


/***********
 * {bcrypt}$2a$04$ON6IrjLRg7WWRB5k/E8sfOvHwBiCz.8kmDTVywU/WUC5UZoJm0OiO
 */









