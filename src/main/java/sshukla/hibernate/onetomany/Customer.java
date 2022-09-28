package sshukla.hibernate.onetomany;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String gender;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_product_fk", referencedColumnName = "id")
    private List<Product> productList;

}
