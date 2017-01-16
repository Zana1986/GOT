package db;

/**
 * Created by Yafei on 13/01/2017.
 */
public class PersonLink {
    private int source;
    private int target;
    private int value;

    public PersonLink() {}
    public PersonLink(int source, int target, int value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
