package top.tinysand.model.vo;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ExamVo {
    private Integer id;

    private Integer subId;

    private String subjectName;

    private String content;

    private String chooseA;

    private String chooseB;

    private String chooseC;

    private String chooseD;

    private String answer;

    private String testType;

    private Integer testTypeScore;
}
