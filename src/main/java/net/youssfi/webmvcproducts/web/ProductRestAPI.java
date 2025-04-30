package net.youssfi.webmvcproducts.web;

import net.youssfi.webmvcproducts.entities.Product;
import net.youssfi.webmvcproducts.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductRestAPI {
    private ProductRepository productRepository;

    public ProductRestAPI(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable(name = "id") Long id){
        return productRepository.findById(id).get();
    }
    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        productRepository.deleteById(id);
    }
}
