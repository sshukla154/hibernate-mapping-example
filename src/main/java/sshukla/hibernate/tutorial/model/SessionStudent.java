package sshukla.hibernate.tutorial.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session_student")
public class SessionStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
