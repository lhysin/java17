package io.lhysin.java17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.lhysin.java17.entity.Customer;

@Repository
public interface CustomerRepoitory extends JpaRepository<Customer, String> {
}
