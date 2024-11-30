package com.minerva.fortuna.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;


@Configuration
public class TomcatConfig {
    
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((connector) -> {
            connector.setProperty("relaxedQueryChars", "[]|{}^\\`\"<>");
            connector.setProperty("rejectIllegalHeader", "true");
        });
        return tomcat;
    }
} 