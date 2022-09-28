package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sshukla.hibernate.onetomany.Customer;
import sshukla.hibernate.onetomany.OrderResponse;
import sshukla.hibernate.repo.CustomerRepository;
import sshukla.hibernate.repo.ProductRepository;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */

@RestController
@RequestMapping("/v1/cp")
@Slf4j
public class CustomerAndProductController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Customer createCustomerAndProduct(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
    }

    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
        customerRepository.deleteById(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomerAndProduct(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
        Customer updatedCustomer = Customer.builder().id(savedCustomer.getId()).name(customer.getName()).email(customer.getEmail()).gender(customer.getGender()).productList(customer.getProductList()).build();
        return customerRepository.save(updatedCustomer);
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation() {
        return customerRepository.getJoinInformation();
    }
}
