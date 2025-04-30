package net.youssfi.webmvcproducts.web;

import lombok.Getter;
import net.youssfi.webmvcproducts.entities.Product;
import net.youssfi.webmvcproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/index")
    public  String index(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("listProduits", products);
        return "products";
    }
    @GetMapping("/deleteProduct")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        return "redirect:/index";
    }
}
