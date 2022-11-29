package com.example.afiliaciones;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AfiliacionesApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(AfiliacionesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AfiliacionesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>> INICIA");
    }

}
