package org.example;

import DAO.Roledao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"DAO"})
@Import({DBConfig.class})
public class ApplicationConfig {

}