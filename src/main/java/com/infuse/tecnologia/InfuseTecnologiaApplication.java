package com.infuse.tecnologia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.infuse.tecnologia")
@EntityScan(basePackages = "com.infuse.tecnologia.infrastructure.persistence.entities")
@EnableJpaRepositories(basePackages = "com.infuse.tecnologia.infrastructure.persistence.repositories")
public class InfuseTecnologiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfuseTecnologiaApplication.class, args);
    }

}
