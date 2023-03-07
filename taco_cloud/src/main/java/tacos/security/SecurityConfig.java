package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(DataSource dataSource, UserDetailsService userDetailsService) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
    }

    @Override   //рабочая охрана
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/design", "/orders").hasRole("USER").and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST);
        web.ignoring().antMatchers(HttpMethod.PATCH);
        web.ignoring().antMatchers(HttpMethod.PUT);
        web.ignoring().antMatchers(HttpMethod.DELETE);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }


    //Гига важный метод для конфигурации соединения с базой данных
    //Здесь программа понимает, что пользователей, которых надо залогинить нужно искать в UserDetailsService
    //(Дальше расписываю все в UserRepositoryUserDetailsService)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("configure(AuthenticationManagerBuilder auth) ДО auth.userDetailsService(userDetailsService)");
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
        System.out.println("configure(AuthenticationManagerBuilder auth) ПОСЛЕ auth.userDetailsService(userDetailsService)");
    }

    //По сути вышеописаный метод это шорткат для того, что я приведу снизу
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("SELECT username, password, is_active FROM user_pool WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT up.username, ur.role FROM user_pool up INNER JOIN user_role ur ON up.id = ur.user_id WHERE up.username=?");
//    }
}
