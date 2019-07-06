package top.tinysand.model;


public class PagerContext {
    private static ThreadLocal<Integer> offset = new ThreadLocal<>();

    private static ThreadLocal<Integer> size = new ThreadLocal<>();

    public static Integer getOffset() {
        return offset.get();
    }

    public static void setOffset(Integer _offset) {
        offset.set(_offset);
    }

    public static void removeOffset() {
        offset.remove();
    }

    public static Integer getSize() {
        return size.get();
    }

    public static void setSize(Integer _size) {
        size.set(_size);
    }

    public static void removeSize() {
        size.remove();
    }
}
