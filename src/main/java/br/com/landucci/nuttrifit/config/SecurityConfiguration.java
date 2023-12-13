package br.com.landucci.nuttrifit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebMvcSecurity
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsService users;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/nutricionista/**").hasAnyRole("ADMIN", "NUTRICIONISTA")
				.requestMatchers("/paciente/**").hasAnyRole("ADMIN", "PACIENTE")
				.requestMatchers("/comum/**").hasAnyRole("ADMIN", "NUTRICIONISTA", "PACIENTE")
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
//				.and().formLogin().loginPage("/login").permitAll()
//				.and().logout().logoutSuccessUrl("/").logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		).httpBasic(Customizer.withDefaults());
		return http.build();
	}

//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(users).
//		passwordEncoder(new Md5PasswordEncoder());
//	}
}
