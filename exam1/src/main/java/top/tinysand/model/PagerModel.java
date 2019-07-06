package top.tinysand.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PagerModel<T> {
    private int offset;
    private int pageSize;
    private long totalSize;
    private List<T> dates;
}
