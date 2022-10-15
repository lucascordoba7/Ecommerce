package com.lucas.hardwarestore.model.order;

import com.lucas.hardwarestore.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Date created;
    private Date modified;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal total;
    @ManyToOne
    private UserModel user;
    @OneToMany(mappedBy = "order")
    private List<OrderEntryModel> entries;
}
