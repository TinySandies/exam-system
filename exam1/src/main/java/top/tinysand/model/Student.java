package top.tinysand.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "exam_user") @ToString
public class Student {
    @Id @GeneratedValue(generator = "id") @Column(name = "user_id", nullable = false)
    @GenericGenerator(name = "id", strategy = "assigned")
    @NotNull(message = "请填写学号")
    @Length(min = 1, max = 18, message = "用户ID不能为空")
    private String userId;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "user_name")
    @NotNull(message = "请填写用户名")
    @Length(min = 1, max = 18, message = "请输入合法姓名")
    private String userName;

    @Column(name = "password")
    @NotNull(message = "密码不能为空")
    @Length(min = 1, max = 18, message = "密码不能为空")
    private String password;

    @Column(name = "tel")
    @NotNull(message = "请填写电话")
    @Digits(integer = 16, fraction = 0, message = "号码错误")
    private String tel;

    @Column(name = "email")
    @NotNull(message = "请填写邮箱")
    @Email(message = "邮箱不合法")
    private String email;

    @Column(name = "address")
    @NotNull(message = "请填写地址")
    private String address;

    @Column(name = "birthday")
    @NotNull(message = "生日不能为空")
    @Past(message = "请输入正确的生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "gender")
    @NotNull(message = "请填写性别")
    private Integer gender;

    @Column(name = "last_lock_time")
    private Date lastLockTime;

    @Column(name = "login_fail_count")
    private Integer loginFailCount;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "exam_test_id")
//    private ExamTest examTest;

}
