import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tree {

    private String filename;
    List<Tree> childrens ;

    public Tree(String value) {
        this.filename = value;
        this.childrens = new ArrayList<Tree>();
    }

    public void addChild(Tree child) {
        childrens.add(child);
    }

    public String getValue() {
        return filename;
    }

    public List<Tree> getChildren() {
        return childrens;
    }
}


