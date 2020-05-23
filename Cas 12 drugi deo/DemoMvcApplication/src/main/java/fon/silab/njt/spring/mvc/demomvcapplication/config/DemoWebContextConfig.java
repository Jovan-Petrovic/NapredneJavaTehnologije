package fon.silab.njt.spring.mvc.demomvcapplication.config;

import fon.silab.njt.spring.mvc.demomvcapplication.formater.CountryDtoFormater;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//konfigurisanje binova u web kontekstu za konkretni dispatcher
@Configuration
@Import(DatabaseConfiguration.class)
@EnableWebMvc
@ComponentScan(basePackages = {
    "fon.silab.njt.spring.mvc.demomvcapplication.controller",
    "fon.silab.njt.spring.mvc.demomvcapplication.repository",
    "fon.silab.njt.spring.mvc.demomvcapplication.service",
    "fon.silab.njt.spring.mvc.demomvcapplication.validator",
    "fon.silab.njt.spring.mvc.demomvcapplication.formater"
}
)
public class DemoWebContextConfig implements WebMvcConfigurer {

    private final CountryService countryService;

    @Autowired
    public DemoWebContextConfig(CountryService countryService) {
        this.countryService = countryService;
    }

    // configure Viewesolver
    @Bean
    public ViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(0);
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesCongigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(
                new String[]{"/WEB-INF/pages/tiles/tiles.xml"}
        );
        return tilesConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("validation");
        return messageSource;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CountryDtoFormater(countryService));
    }
    
    

}
