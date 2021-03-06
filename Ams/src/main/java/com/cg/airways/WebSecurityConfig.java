package com.cg.airways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//	.antMatchers("/userPage").hasAnyAuthority("USER")//.access("hasRole('USER')")
				.antMatchers("/addFlight","/addresult").hasAnyAuthority("ADMIN")//.access("hasRole('ADMIN')")
				.antMatchers("/resources/**","/admin","/bookFlight","/displayDetails","/displayFlights","/","/search","/bookTicket","/error1")
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/admin").successHandler(customSuccessHandler)
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
				.and()
				.logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}