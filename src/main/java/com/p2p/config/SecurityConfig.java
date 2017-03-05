package com.p2p.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.p2p.security.RestAuthenticationEntryPoint;

@Configuration
@ComponentScan("com.p2p.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	 private UserDetailsService userDetailsService;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	 
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	 } 

		@Bean public BCryptPasswordEncoder bCryptPasswordEncoder(){
		    return new BCryptPasswordEncoder();
		}
	
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable() .exceptionHandling()
      .authenticationEntryPoint(restAuthenticationEntryPoint).and()
      .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/p2p/**").authenticated()
        .antMatchers(HttpMethod.PUT, "/p2p/**").authenticated()
        .antMatchers(HttpMethod.DELETE, "/p2p/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin().loginPage("/logind")
        .usernameParameter("email").passwordParameter("password");
  }
  

	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
	     return new BCryptPasswordEncoder();
	    }

}