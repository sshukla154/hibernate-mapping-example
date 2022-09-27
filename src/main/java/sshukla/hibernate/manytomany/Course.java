package sshukla.hibernate.manytomany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fees;


    /**
     * We don't need to defined @JoinTable as we have defined in Student class as Student is my parent.
     * We are going to map Student with multiple course
     * <p>
     * To info the JPA that, between Student table and Course table, OWNER is Student table i.e. We are going to map Student with multiple course
     * mappedBy - Indicates that the entity is not the owner entity.
     */
    @ManyToMany(mappedBy = "courseSet", fetch = FetchType.LAZY)
//    @JoinTable(name = "student_course",
//            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
//            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Student> studentSet;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", modules=" + modules +
                ", fees=" + fees +
                '}';
    }
}
