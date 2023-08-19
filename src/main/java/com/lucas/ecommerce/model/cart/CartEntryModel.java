package com.lucas.ecommerce.model.cart;

import com.lucas.ecommerce.model.product.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartEntryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantity;
    private BigDecimal total;
    @ManyToOne
    private ProductModel product;
    @ManyToOne
    private CartModel order;
}
