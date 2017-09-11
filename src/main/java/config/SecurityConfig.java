package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.Uris;
import entities.users.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        
        // auth.inMemoryAuthentication().//
         //withUser("111").password("111").roles("ADMIN").and().
         //withUser("222").password("222").roles("MANAGER").and().
         //withUser("333").password("333").roles("ADMIN","MANAGER");
         
         
    
    }

    
    //seguridad centralizada a traves de uris
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()//
                .antMatchers(HttpMethod.GET, Uris.SERVLET_MAP + Uris.VERSION).permitAll()
               /* .antMatchers(HttpMethod.GET, Uris.SERVLET_MAP + Uris.VERSION + Uris.ALL).permitAll()//
                .antMatchers(HttpMethod.GET, Uris.SERVLET_MAP + Uris.VERSION + Uris.AUTHENTICATED).authenticated()
                .antMatchers(HttpMethod.GET, Uris.SERVLET_MAP + Uris.VERSION + Uris.ADMIN).hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.GET, Uris.SERVLET_MAP + Uris.VERSION + Uris.MANAGER).hasRole(Role.MANAGER.name()) */
                .and().httpBasic();//
    }

    //utilizo el encriptador de spring
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
