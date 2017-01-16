package db;

/**
 * Created by Yafei on 13/01/2017.
 */
public class D3NetworkJson {
    public PersonNode[] nodes;
    public PersonLink[] links;

    public D3NetworkJson(PersonNode[] nodes, PersonLink[] links) {
        this.nodes = nodes;
        this.links = links;
    }

    public PersonNode[] getNodes() {
        return nodes;
    }

    public void setNodes(PersonNode[] nodes) {
        this.nodes = nodes;
    }

    public PersonLink[] getLinks() {
        return links;
    }

    public void setLinks(PersonLink[] links) {
        this.links = links;
    }
}
