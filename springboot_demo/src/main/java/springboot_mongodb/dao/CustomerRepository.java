package springboot_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import springboot_mongodb.bean.Customer;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
