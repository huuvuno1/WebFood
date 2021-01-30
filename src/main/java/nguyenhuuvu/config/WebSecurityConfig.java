package nguyenhuuvu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nguyenhuuvu.repository.UserRepository;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserRepository userRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin**").access("hasRole('ROLE_ADMIN')");
	    http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

	    http.authorizeRequests().and().formLogin()
	        .loginProcessingUrl("/login")
	        .loginPage("/login")
			.successHandler(new CustomSuccessHandler())
	        .failureUrl("/login?message=error")//
	        .usernameParameter("username")//
	        .passwordParameter("password")
	        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?message=logout");
	  
	}
}
