package com.andynator.customerservice;

import com.andynator.customerservice.entities.Customer;
import com.andynator.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
       /* return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };*/
        return args -> {
            // Trois façons de creer un customer
            // -1 Pour creer une liste de customers
            List<Customer> customerList = List.of(
                    Customer.builder() // Avec le pattern Builder
                            .firstName("Nicolas")
                            .lastName("Cage")
                            .email("ncage@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Morgan")
                            .lastName("Freeman")
                            .email("mfreeman@gmail.com")
                            .build()

            );
            customerRepository.saveAll(customerList);

               // 1- Pour creer des customers individuellement
          /*  Customer customer1 = Customer.builder() // Avec le pattern Builder
                    .firstName("Nicolas")
                    .lastName("Cage")
                    .email("ncage@gmail.com")
                    .build();
            customerRepository.save(customer1);
            Customer customer2 = Customer.builder() // Avec le pattern Builder
                    .firstName("Morgan")
                    .lastName("Freeman")
                    .email("mfreeman@gmail.com")
                    .build();
            customerRepository.save(customer2);*/

            /* -2 Customer customer3 = new Customer(null, "", "", "");// Constructeur avec parametre
            customerRepository.save();*/

          /* -3 Customer customer = new Customer(); // Constructeur sans parametre
            customer.setId(1);
            customer.setFirstName("");
            customer.setLastName("");
            customer.setEmail("");
            customerRepository.save();*/
        };

    }

}
