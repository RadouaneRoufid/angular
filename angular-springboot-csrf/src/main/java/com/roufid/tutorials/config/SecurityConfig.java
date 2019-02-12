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
				.csrf()
				.ignoringAntMatchers(CSRF_IGNORE)
				.csrfTokenRepository(csrfTokenRepository())
				.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName(CsrfHeaderFilter.CSRF_COOKIE_NAME);
		return repository;
	}
}
