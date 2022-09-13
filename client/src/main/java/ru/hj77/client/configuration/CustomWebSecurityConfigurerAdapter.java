package ru.hj77.client.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.hj77.client.security.HeaderAuthenticationFilter;

@Configuration
public class CustomWebSecurityConfigurerAdapter
        extends WebSecurityConfigurerAdapter  {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterAfter(
                new HeaderAuthenticationFilter(),
                BasicAuthenticationFilter.class);
    }
}
