package br.com.fefproject.FefProjectApplication.repository;

import br.com.fefproject.FefProjectApplication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
