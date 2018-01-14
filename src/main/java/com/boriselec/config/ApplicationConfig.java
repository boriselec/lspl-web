package com.boriselec.config;

import com.boriselec.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationConfig {
}
