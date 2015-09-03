package ru.megazlo.springtest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author paradoxfm - 02.09.2015
 */
@Configuration
@EnableAsync
@EnableWebMvc
@ComponentScan({"ru.megazlo.springtest.services", "ru.megazlo.springtest.controllers"})
public class SpringContext {
}
