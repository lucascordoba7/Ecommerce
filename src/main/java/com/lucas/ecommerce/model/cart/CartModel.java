package com.lucas.ecommerce.model.cart;

import com.lucas.ecommerce.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date created;
    private Date modified;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal total;
    @ManyToOne
    private UserModel user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartEntryModel> entries;
}
