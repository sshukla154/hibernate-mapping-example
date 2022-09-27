package sshukla.hibernate.onetoone.bidirectional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userProfile")
    @JsonIgnore
    private User user;

}
