package com.xiangyong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * Created by yuxiangyong on 2017/5/12.
 */
//disable form base authentication
//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()   //.csrfTokenRepository(csrfTokenRepository()).and() //API dont need this
                 .authorizeRequests()
                    .antMatchers("/contacts/**","/other/index").authenticated()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                    .anyRequest().permitAll()
                .and()
                    .formLogin() //POST: http://localhost:9999/login?username=user&password=password
                .and()
                    .logout() //POST: http://localhost:9999/logout
                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()); //only return status code
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
//        webSecurity.addSecurityFilterChainBuilder()
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.inMemoryAuthentication()
                .passwordEncoder(new Md5PasswordEncoder())
                .withUser("user").password("5f4dcc3b5aa765d61d8327deb882cf99").roles("USER")
                .and()
                .withUser("admin").password("5f4dcc3b5aa765d61d8327deb882cf99").roles("ADMIN","USER","ACTUATOR");
//        builder.jdbcAuthentication().dataSource(datasource);
//        builder.ldapAuthentication().userSearchBase("ou=people").userSearchFilter("(uid={0}")...
//        builder.userDetailsService(XXX)
    }

    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
}
