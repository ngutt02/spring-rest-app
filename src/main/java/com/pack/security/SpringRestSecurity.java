package com.pack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringRestSecurity extends WebSecurityConfigurerAdapter {

	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Bean
    public BCryptPasswordEncoder encoder()
    {
		return new BCryptPasswordEncoder();
    }
	
	public void configure(HttpSecurity http)throws Exception {
		http.authorizeRequests()
		.antMatchers("/books/all/**")
		.hasAnyRole("ADMIN")
		.anyRequest()
        .permitAll()
        
		.and()
        //.formLogin()
        .httpBasic()
        .and()
        .csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception
	{
		builder.inMemoryAuthentication().withUser("scott").password(encoder.encode("12345")).roles("ADMIN");
	}
	
}
