package com.ex7.restfulapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.mob104.model")
@SpringBootApplication(scanBasePackages = {"com.ex7.restfulapi.DemoSqLInjection","com.ex7.restfulapi.model", "com.ex7.restfulapi.rowMapped","com.ex7.restfulapi.config","com.ex7.restfulapi.controller","com.ex7.restfulapi.service.implement","com.ex7.restfulapi.service.security"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
