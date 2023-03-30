package br.com.fefproject.FefProjectApplication.repository;

import br.com.fefproject.FefProjectApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}