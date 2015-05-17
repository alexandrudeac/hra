package ro.adc.hra;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import ro.adc.hra.fmt.BooleanFormatter;
import ro.adc.hra.fmt.LocalDateTimeFormatter;
import ro.adc.hra.fmt.PersonNameFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = HraMvcConfiguration.class)
public class HraMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addFormatter(localDateTimeFormatter());
        registry.addFormatter(booleanFormatter());
        registry.addFormatter(personNameFormatter());
    }

    @Bean
    public TemplateResolver templateResolver() {
        final ClassLoaderTemplateResolver tmlRslv = new ClassLoaderTemplateResolver();
        tmlRslv.setPrefix("templates/");
        tmlRslv.setSuffix(".html");
        tmlRslv.setTemplateMode("HTML5");
        tmlRslv.setCacheable(false);
        return tmlRslv;
    }

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
       registry.viewResolver(thymeleafViewResolver());
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        final SpringTemplateEngine tmlEngn = new SpringTemplateEngine();
        tmlEngn.setTemplateResolver(templateResolver());
        tmlEngn.addDialect(new LayoutDialect());
        return tmlEngn;
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        final ThymeleafViewResolver viewRslv = new ThymeleafViewResolver();
        viewRslv.setTemplateEngine(templateEngine());
        return viewRslv;
    }

    @Bean
    public LocalDateTimeFormatter localDateTimeFormatter() {
        return new LocalDateTimeFormatter(messageSource());
    }

    @Bean
    public BooleanFormatter booleanFormatter() {
        return new BooleanFormatter(messageSource());
    }

    @Bean
    public PersonNameFormatter personNameFormatter() {
        return new PersonNameFormatter(messageSource());
    }

}
