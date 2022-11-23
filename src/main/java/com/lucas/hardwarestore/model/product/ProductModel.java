package com.lucas.hardwarestore.model.product;

import com.lucas.hardwarestore.model.cart.CartEntryModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    @OneToMany(mappedBy = "product")
    private List<CartEntryModel> entries;
}
