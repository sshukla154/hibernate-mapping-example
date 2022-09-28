package sshukla.hibernate.onetomany;

import lombok.*;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {

    String name;
    String productName;

}
