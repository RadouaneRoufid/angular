package com.roufid.tutorials.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] CSRF_IGNORE = {"/signin/**", "/signup/**"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.httpBasic()
				.and()
				.csrf() // csrf config starts here
				.ignoringAntMatchers(CSRF_IGNORE) // URI where CSRF check will not be applied
				.csrfTokenRepository(csrfTokenRepository()) // defines a repository where tokens are stored
				.and()
				.addFilterAfter(new CustomCsrfFilter(), CsrfFilter.class); // Csrf filter in which we will add the cookie
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName(CustomCsrfFilter.CSRF_COOKIE_NAME);
		return repository;
	}
}
