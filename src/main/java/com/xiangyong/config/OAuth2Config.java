package com.xiangyong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.Filter;

/**
 * Created by yuxiangyong on 2017/6/3.
 */
//@Configuration
//@EnableOAuth2Client
//@EnableAuthorizationServer
//@EnableGlobalMethodSecurity
//@EnableWebSecurity
/*public class OAuth2Config extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("oauthFilter")
    private Filter oauthFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity //csrf().disable()   //.csrfTokenRepository(csrfTokenRepository()).and() //API dont need this
                .authorizeRequests()
                .antMatchers("/contact/**","/other/index")
                .authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .antMatchers("/", "/login**", "/webjars/**")
                .permitAll()
                .anyRequest().permitAll()
                .and()
                    .logout() //POST: http://localhost:9999/logout
                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()) //only return status code
                    .permitAll()
                .and().exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterBefore(oauthFilter, BasicAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.inMemoryAuthentication()
                .passwordEncoder(new Md5PasswordEncoder())
                .withUser("user").password("5f4dcc3b5aa765d61d8327deb882cf99").roles("USER")
                .and()
                .withUser("admin").password("5f4dcc3b5aa765d61d8327deb882cf99").roles("ADMIN","USER","ACTUATOR");
    }
}
*/