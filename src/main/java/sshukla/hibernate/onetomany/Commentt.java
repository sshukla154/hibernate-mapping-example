package sshukla.hibernate.onetomany;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commentt")
public class Commentt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String text;

}
