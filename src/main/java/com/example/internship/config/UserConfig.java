package com.example.internship.config;

import com.example.internship.model.User;
import com.example.internship.repository.UserRepository;
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
            User a = new User(1L,false);
            User b = new User(56L,true);
            System.out.println(a);
            System.out.println(b);


            repository.saveAll(
                    List.of(a,b)
            );
        };
    }
}
