package com.jd.jmq.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(basePackages = {"com.jd.jmq"},
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, RestController.class})})
@ImportResource({"classpath:spring-consumer.xml","classpath:spring-producer.xml"})
@PropertySource("classpath:/conf/mq.properties")
public class RootConfig {
}
