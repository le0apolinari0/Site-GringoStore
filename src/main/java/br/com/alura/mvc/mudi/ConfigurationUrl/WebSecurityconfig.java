package br.com.alura.mvc.mudi.ConfigurationUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;


@Configuration
@EnableWebSecurity

public class WebSecurityconfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
  
    @Override
    protected void configure(HttpSecurity http) throws Exception{
       http.authorizeRequests()
               .anyRequest().authenticated()
               .and()
               .formLogin(form -> form
                       .loginPage("/login")
                       .defaultSuccessUrl("/home", true)
                       .permitAll())
               .logout(sair -> sair.logoutUrl("/sair"))
               .csrf().disable();


   }
   @Override
   protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



     auth.jdbcAuthentication()
             .dataSource(dataSource)
             .passwordEncoder(encoder);


   }
}
