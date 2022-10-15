package com.lucas.hardwarestore.model.order;

import com.lucas.hardwarestore.model.product.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantity;
    private BigDecimal total;
    @ManyToOne
    private ProductModel product;
    @ManyToOne
    private OrderModel order;
}
