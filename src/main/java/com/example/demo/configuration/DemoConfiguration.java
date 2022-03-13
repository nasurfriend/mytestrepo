package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({ "file:${CONFIG_LOCATION}/config.properties"})
public class DemoConfiguration {

}
