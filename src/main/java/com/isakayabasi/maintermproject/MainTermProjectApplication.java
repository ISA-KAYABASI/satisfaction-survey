package com.isakayabasi.maintermproject;

import com.isakayabasi.maintermproject.model.Result;
import com.isakayabasi.maintermproject.model.User;
import com.isakayabasi.maintermproject.repository.IUserRepository;
import com.isakayabasi.maintermproject.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainTermProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainTermProjectApplication.class, args);
    }

}

