package sshukla.hibernate.onetoone.unidirectional;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "tutorial", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Tutorial implements Serializable {

    private static final long serialVersionUID = -6790693372846798580L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tutorial_details_id", referencedColumnName = "id")
    private TutorialDetails tutorialDetails;

}
