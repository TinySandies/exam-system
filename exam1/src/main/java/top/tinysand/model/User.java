package top.tinysand.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Digits(integer = 10, fraction = 0, message = "请输入整数！")
    @Min(value = 0)
    @NotNull(message = "ID不可以为空！")
    private String id;

    @Getter
    @Setter
    @NotNull(message = "姓名不可以为空！")
    @Length(min = 1, max = 15)
    private String name;

    @Getter
    @Setter
    @Range(min = 1, max = 150, message = "年龄数值在1到150之间")
    private Integer age;
}
