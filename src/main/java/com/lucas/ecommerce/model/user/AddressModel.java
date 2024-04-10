package com.lucas.ecommerce.model.user;

import com.lucas.ecommerce.model.i18.CountryModel;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String line1;
    private String line2;
    @ManyToOne
    private CountryModel country;

}
