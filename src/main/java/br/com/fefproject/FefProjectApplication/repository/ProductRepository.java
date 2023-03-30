package br.com.fefproject.FefProjectApplication.repository;

import br.com.fefproject.FefProjectApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}