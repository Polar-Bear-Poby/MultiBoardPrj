package com.example.app.config;

import java.util.Locale;

import org.aopalliance.intercept.Interceptor;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// import com.example.app.common.filter.LogingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean(value="localeResolver")
    SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREAN);
        return slr;
    }

    @Bean(value="messageSource")
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i8n:/messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean(value="localeChangeInterceptor")
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    @Override
    public void addInterceptors(InterceptorterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
