package com.project.Blogify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.Blogify.web.UserDetailsServiceImpl;
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	  private UserDetailsServiceImpl userDetailsService;	
	 
protected void configure(HttpSecurity http)throws Exception{
	//Give everyone permission to use css. Otherwise redirection will fail:
	http
	.authorizeRequests().antMatchers("/api/**","/images","api/posts/**","/images/**","/home","/","/post/**","post/","/css/**","/font-awesome/**","/vendor/**","/js/**","/fonts/**","/img/**","/toolbarconfigurator/**").permitAll()
    .anyRequest().authenticated()
    .and()
    .authorizeRequests()
	.antMatchers("/profile/**","post/**").hasAuthority("USER")
	.and()
	.authorizeRequests()
	.antMatchers("/add/","/admin/**","/save").hasAuthority("ADMIN")
	.and()
	.authorizeRequests().anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login")
	.defaultSuccessUrl("/home")
	.permitAll()
	.and()
	.logout()
	 .permitAll();
}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(new BCryptPasswordEncoder());
}
}
