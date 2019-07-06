package top.tinysand.model.vo;

import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
public class StudentVo {
    private String userId;
    private String userName;
    private String password;
    private String tel;
    private String email;
    private String address;
    private Integer gender;
    private Date birthday;
}
