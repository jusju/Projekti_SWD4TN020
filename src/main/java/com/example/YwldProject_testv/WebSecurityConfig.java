package com.example.YwldProject_testv;

import org.springframework.beans.factory.annotation.Autowired;

//kirjautumistoiminto sovellukseen, nyt automaattisesti ns etusivulla
//miten saa integroitua

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.YwldProject_testv.web.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
	@Autowired //tarkoittaa että injektoidaan luokkaan 
  private UserDetailServiceImpl userDetailsService;	
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
      .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
      .and()
      .authorizeRequests().antMatchers("/signup", "/saveuser","/h2-console/**").permitAll()
      .and()
      .authorizeRequests().anyRequest().authenticated()
      .and()
      
    .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/usersfirstview", true) //tässä määritellään sivu, jolle siirrytään kirjautumisen jälkeen
        .permitAll()
        .and()
    .logout()
        .permitAll();
      http.csrf().disable();
      http.headers().frameOptions().disable();
  }
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
 

    
      
}
