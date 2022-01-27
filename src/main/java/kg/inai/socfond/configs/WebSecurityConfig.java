package kg.inai.socfond.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/adminStyles/css/**",
                        "/adminStyles/fonts/**",
                        "/adminStyles/images/**",
                        "/adminStyles/js/**",
                        "/adminStyles/scss/**",
                        "/adminStyles/scss/common/****",
                        "/adminStyles/vendors/****",
                        "/adminStyles/vendors/ace-builds/src-min/**",
                        "/adminStyles/vendors/bootstrap-datepicker/**",
                        "/adminStyles/vendors/bootstrap-maxlength/**",
                        "/adminStyles/vendors/chart.js/**",
                        "/adminStyles/vendors/codemirror/**",
                        "/adminStyles/vendors/colcade/**",
                        "/adminStyles/vendors/css/**",
                        "/adminStyles/vendors/datatables.net/**",
                        "/adminStyles/vendors/datatables.net-bs4/**",
                        "/adminStyles/vendors/feather/**",
                        "/adminStyles/vendors/flag-icon-css/**",
                        "/adminStyles/vendors/font-awesome/**",
                        "/adminStyles/vendors/inputmask/**",
                        "/adminStyles/vendors/jquery-asColor/**",
                        "/adminStyles/vendors/jquery-asColorPicker/**",
                        "/adminStyles/vendors/jquery-asGradient/**",
                        "/adminStyles/vendors/jquery-bar-rating/**",
                        "/adminStyles/vendors/jquery-contextmenu/**",
                        "/adminStyles/vendors/jquery-file-upload/**",
                        "/adminStyles/vendors/js/**",
                        "/adminStyles/vendors/mdi/**",
                        "/adminStyles/vendors/moment/**",
                        "/adminStyles/vendors/nouislider/**",
                        "/adminStyles/vendors/owl-carousel-2/**",
                        "/adminStyles/vendors/progressbar.js/**",
                        "/adminStyles/vendors/pwstabs/**",
                        "/adminStyles/vendors/quill/**",
                        "/adminStyles/vendors/raphael/**",
                        "/adminStyles/vendors/select2/**",
                        "/adminStyles/vendors/select2-bootstrap-theme/**",
                        "/adminStyles/vendors/simplemde/**",
                        "/adminStyles/vendors/sweetalert/**",
                        "/adminStyles/vendors/tempusdominus-bootstrap-4/**",
                        "/adminStyles/vendors/ti-icons/**",
                        "/adminStyles/vendors/tinymce/**",
                        "/adminStyles/vendors/twbs-pagination/**",
                        "/adminStyles/vendors/typeahead.js/**",
                        "/adminStyles/vendors/x-editable/**",
                        "/"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureHandler(authenticationFailureHandler())
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/success", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        http.sessionManagement().maximumSessions(70).sessionRegistry(sessionRegistry());
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
}
