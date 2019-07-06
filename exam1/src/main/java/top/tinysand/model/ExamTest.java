package top.tinysand.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
//import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity @Table(name = "exam_test")
public class ExamTest implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sub_id")
    private Integer subId;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "test_type_id")
    private ExamTestType examTestType;

    @Column(name = "content", length = 1024)
    private String content;

    @Column(name = "choose_a")
    private String chooseA;

    @Column(name = "choose_b")
    private String chooseB;

    @Column(name = "choose_c")
    private String chooseC;

    @Column(name = "choose_d")
    private String chooseD;

    @Column(name = "answer")
    private String answer;

//    @OneToMany(mappedBy = "examTest")
//    private Set<Student> students;

    private static final long serialVersionUID = 123L;
}
