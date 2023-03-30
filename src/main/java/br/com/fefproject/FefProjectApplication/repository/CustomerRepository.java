package br.com.fefproject.FefProjectApplication.repository;

import br.com.fefproject.FefProjectApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustumerRepository extends JpaRepository<Customer, Long> {
}