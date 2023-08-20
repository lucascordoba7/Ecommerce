package com.lucas.ecommerce.model.product;

import com.lucas.ecommerce.model.cart.CartEntryModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    @OneToMany(mappedBy = "product")
    private List<CartEntryModel> entries;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CategoryModel> categories;
}
