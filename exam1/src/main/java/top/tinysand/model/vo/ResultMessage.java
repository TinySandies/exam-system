package top.tinysand.model.vo;

import lombok.*;

import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
public class ResultMessage {
    private Map<String, String> messageMap;
    private boolean success;
}
