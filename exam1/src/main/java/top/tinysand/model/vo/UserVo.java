package top.tinysand.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    @NotNull(message = "请填写学号")
    @Length(min = 1, max = 18, message = "用户ID不能为空")
    private String userId;

    @Column(name = "password")
    @NotNull(message = "密码不能为空")
    @Length(min = 1, max = 18, message = "密码不能为空")
    private String password;
}
