package kg.inai.socfond.configs;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/notFound").setViewName("errorPages/error-404");
//        registry.addViewController("/forbidden").setViewName("errorPages/error-403");
//        registry.addViewController("/servererror").setViewName("errorPages/error-500");

    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:/home/webadmin/mzSite/uploads/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:C:/Users/tashbolotoff/Desktop/siteMZback/uploads/");
    }

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
//        return container -> {
//            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
//                    "/notFound"));
//            container.addErrorPages((new ErrorPage(HttpStatus.FORBIDDEN, "/forbidden")));
//            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/servererror"));
//        };
//    }
}
