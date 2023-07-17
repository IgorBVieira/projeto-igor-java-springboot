package com.igor;

import java.util.List;
import java.util.Optional;

import com.igor.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.igor.repository.CustomerRepository;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class ProjetoIgorApplication {
    @Autowired
    private final CustomerRepository customerRepository;

    public ProjetoIgorApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoIgorApplication.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {

        return customerRepository.findAll();    // retorna todos os clientes
    }

    @GetMapping("{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") final Integer id) {

       Optional <Customer>result = customerRepository.findById(id);

       if(result.isEmpty()){
           throw new RuntimeException("Customer not found");
       }

        return customerRepository.findById(id);
    }

    record NewCustomerRequest(String name, String email, Integer age) {

    }
    @PostMapping()
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);

    }
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }


}

