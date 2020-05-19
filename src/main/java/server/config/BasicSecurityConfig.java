package server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import server.service.UserServiceImpl;

@Configuration
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userService;

    public BasicSecurityConfig(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/allUsers").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getOne").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/editUser").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/addUser").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deleteUser").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
