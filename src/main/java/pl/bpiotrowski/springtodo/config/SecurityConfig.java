package pl.bpiotrowski.springtodo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
            .and()
                .formLogin().defaultSuccessUrl("/")
            .and()
                .httpBasic();
//            .and()
//                .rememberMe().tokenValiditySeconds(60 * 60 * 24);
    }
}
