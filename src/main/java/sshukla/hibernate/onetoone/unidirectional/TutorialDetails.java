package sshukla.hibernate.onetoone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@Entity
@Table(name = "tutorial_details", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class TutorialDetails implements Serializable {

    private static final long serialVersionUID = -6790693372846798580L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column
    private Date createdOn;

    @Column
    private String createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
