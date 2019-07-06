package top.tinysand.model.vo;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ExamTestTypeVo {
    private Integer id;

    private String testType;

    private Integer testTypeScore;
}
