package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("Hello Spring boot!");
    }




    @Bean
    CommandLineRunner runner() {
        return args -> {

            //Owner
            Owner owner1 = new Owner("Mike", "Heny");
            Owner owner2 = new Owner("Mary", "Robinson");

            ownerRepository.save(owner1);
            ownerRepository.save(owner2);


            Car car1 = new Car("Hyundai", "Sonata", "Black", "HS-1111", 2020, 23_860_000, owner1);
            Car car2 = new Car("Kia", "K5", "Black", "KF-5123", 2020, 23_510_000, owner2);
            Car car3 = new Car("Chevrolet", "Malibu", "Black", "CH-5123", 2020, 23_640_000, owner2);


//            Set<Car> cars1 = new HashSet<>();
//            cars1.add(car1);
//            cars1.add(car2);
//
//            Set<Car> cars3 = new HashSet<>();
//            cars3.add(car3);
//
//            owner1.setCars(cars1);
//            owner2.setCars(cars3);


            carRepository.save(car1);
            carRepository.save(car2);
            carRepository.save(car3);

            // username: user password : user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));

            // username: admin password : admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));





        };
    }

}
