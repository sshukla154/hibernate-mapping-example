package sshukla.hibernate.manytomany;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String department;

    //    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
    private Set<Course> courseSet;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", courseSet=" + courseSet +
                '}';
    }
}
