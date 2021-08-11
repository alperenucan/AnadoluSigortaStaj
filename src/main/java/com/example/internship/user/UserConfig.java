package com.example.internship.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository){
        return args -> {
            User a = new User(1L);
            User b = new User(56L);


            repository.saveAll(
                    List.of(a,b)
            );
        };
    }
}
