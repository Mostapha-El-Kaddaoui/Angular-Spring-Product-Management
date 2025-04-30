package net.youssfi.webmvcproducts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Product {
    @Id @GeneratedValue
    private Long id;
    private  String name;
    private double price;
    private  int quantity;
    private boolean selected;
}
