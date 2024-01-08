package com.teamfillin.fillin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FillinApplication {

    public static void main(String[] args) {
        SpringApplication.run(FillinApplication.class, args);
    }

}
