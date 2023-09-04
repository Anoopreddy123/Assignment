import java.io.File;
import java.util.List;

public class Main {

    public static void printingTree(Tree node, String prefix) {
        System.out.println(prefix + node.getValue());
        List<Tree> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Tree child = children.get(i);
            if (i == children.size() - 1) {
                printingTree(child, prefix + "|--");
            } else {
                printingTree(child, prefix + "|--");
            }
        }
    }
    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.out.println("Enter a directory where length is greater than 0");
            return;
        }
        Tree tree = null;
        String directoryPath = args[0];
        File rootDirectory = new File(directoryPath);
        try {
             tree= directoryTree(rootDirectory);

        } catch (Exception e) {
            System.err.println();
        }
        if(tree!=null)
            printingTree(tree,"");
    }

    public static Tree directoryTree(File directory) {
        Tree node = new Tree(directory.getName());
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    Tree childNode = directoryTree(file);
                    node.addChild(childNode);
                } else {
                    node.addChild(new Tree(file.getName()));
                }
            }
        }

        return node;
    }


}