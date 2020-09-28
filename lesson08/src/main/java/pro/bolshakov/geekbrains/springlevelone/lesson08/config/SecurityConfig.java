package pro.bolshakov.geekbrains.springlevelone.lesson08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pro.bolshakov.geekbrains.springlevelone.lesson08.bootstrap.DataLoader;
import pro.bolshakov.geekbrains.springlevelone.lesson08.domain.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(DataLoader.USER.getName())
                .password(DataLoader.USER.getPassword())
                .roles(DataLoader.USER.getRole().name())
                .and()
                .withUser(DataLoader.ADMIN.getName())
                .password(DataLoader.ADMIN.getPassword())
                .roles(DataLoader.ADMIN.getRole().name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users","/users/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
