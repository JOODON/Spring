package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@ComponentScan(basePackages = {"src/main/java/DTO/DAO/RoleDao.java"})
@Configuration
@Import({DBConfig.class})
public class ApplicationConfig {

}