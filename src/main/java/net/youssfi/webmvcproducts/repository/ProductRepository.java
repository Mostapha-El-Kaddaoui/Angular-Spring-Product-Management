package net.youssfi.webmvcproducts.repository;

import net.youssfi.webmvcproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
