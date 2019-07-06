package top.tinysand.model;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "exam_user_role")
public class UserRole {
    @Column(name = "role_id")
    private Integer roleId;

    @Id @GeneratedValue @Column(name = "user_id")
    private String userId;
}
