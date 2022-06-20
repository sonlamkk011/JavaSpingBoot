package spingboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spingboot.example.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
