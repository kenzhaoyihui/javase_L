package springboot_mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot_mongodb.bean.Customer;
import springboot_mongodb.dao.CustomerRepository;

/**
 * First step: Start mongodb
 * Cmd: # mongod --dbpath /home/yzhao_sherry/data/mongodbdata/
 */

@SpringBootApplication
public class SpringBootMongodbapplication implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMongodbapplication.class, args);
    }

    @Override
    public void run(String... args) {

        repository.deleteAll();

        //Save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        //Fetch all customers
        System.out.println("Customers found with findAll(): ");
        System.out.println("--------------------------------");

        for (Customer customer: repository.findAll()) {
            System.out.println(customer);
        }

        System.out.println();


        // Fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'): ");
        System.out.println("----------------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println();
        System.out.println("Customer found with findByLastName('Smith')");
        System.out.println("=================================");

        for (Customer customer: repository.findByLastName("Smith")) {
            System.out.println(customer);
        }



//        From the Console:
//        Customers found with findAll():
//        --------------------------------
//                Customer{id=5b42c1f928235c598f8647b0, firstName=Alice, lastName=Smith}
//        Customer{id=5b42c1f928235c598f8647b1, firstName=Bob, lastName=Smith}
//
//        Customer found with findByFirstName('Alice'):
//        ----------------------------------------
//                Customer{id=5b42c1f928235c598f8647b0, firstName=Alice, lastName=Smith}
//
//        Customer found with findByLastName('Smith')
//                =================================
//        Customer{id=5b42c1f928235c598f8647b0, firstName=Alice, lastName=Smith}
//        Customer{id=5b42c1f928235c598f8647b1, firstName=Bob, lastName=Smith}
    }
}
