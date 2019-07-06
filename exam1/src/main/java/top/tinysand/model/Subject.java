package top.tinysand.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "exam_subject")
public class Subject {
    @Id @GeneratedValue @Column(name = "sub_id")
    private Integer subId;

    @Column(name = "test_count")
    private Integer testCount;

    @Column(name = "total_time")
    private Integer totalTime;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total_score")
    private Double totalScore;

    @Column(name = "name")
    private String subjectName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "subject")
    private Set<Student> students;
}
