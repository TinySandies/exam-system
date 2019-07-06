package top.tinysand.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity @ToString
@Table(name = "exam_test_type")
public class ExamTestType implements Serializable {

    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "test_type", length = 45, nullable = false)
    private String testType;

    @Column(name = "test_type_score", nullable = false)
    private Integer testTypeScore;

    @OneToMany(mappedBy = "examTestType")
    private Set<ExamTest> examTest;

    private static final long serialVersionUID = -6530168542617015609L;
}
