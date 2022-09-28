package sshukla.hibernate.onetomany;

import lombok.*;

import javax.persistence.*;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;

}
