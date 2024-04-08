package br.com.cpsoftware.finance.repository;

import br.com.cpsoftware.finance.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
