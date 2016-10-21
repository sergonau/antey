package lab02a.common;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public enum CommonConsts {
    DUMMY("DUMMY");

    // inner message field
    private String msg;
    // hidden constructor
    private CommonConsts(String message) {
        this.msg = message;
    }
    @Override
    public String toString() {
        return this.msg;
    }
}
