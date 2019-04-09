package ru.zsoft.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("john").password("P12345").roles("USER");
		builder.inMemoryAuthentication().withUser("admin").password("P12345").roles("ADMIN","USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").usernameParameter("userId").passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/market/products/add").failureUrl("/login?error");
		
		http.logout().logoutSuccessUrl("/login?logout").invalidateHttpSession(true);
		
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/**/add").access("hasRole('ADMIN')")
			.antMatchers("/**/market/**").access("hasRole('USER')");
		
		http.csrf().disable();		
	}

}
