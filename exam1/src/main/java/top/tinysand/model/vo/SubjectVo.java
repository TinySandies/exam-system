package top.tinysand.model.vo;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
public class SubjectVo {
    private Integer subId;

    private Integer testCount;

    private Integer totalTime;

    private Integer status;

    private Double totalScore;

    private String subjectName;

    private String description;
}
