package com.igor.repository;

import com.igor.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository <Customer, Integer> {

}
