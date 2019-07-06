package top.tinysand.model;

import lombok.*;

import javax.persistence.*;

@ToString @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "exam_user_subject")
public class ExamUserSubject {
    @Id @GeneratedValue @Column(name = "user_id")
    private String userId;

    @Column(name = "sub_id")
    private Integer subId;
}
