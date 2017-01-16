package db;

/**
 * Created by Yafei on 13/01/2017.
 */
public class PersonNode {
    private String id;
    private String name;
    private int group;

    public PersonNode() {}

    public PersonNode(String id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
