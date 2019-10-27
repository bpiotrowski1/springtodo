package pl.bpiotrowski.springtodo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("test").password(passwordEncoder.encode("test")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER","ADMIN");
    }
}
