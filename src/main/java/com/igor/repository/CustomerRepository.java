package com.igor.repository;

import com.igor.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository <Customer, Integer> {

}
