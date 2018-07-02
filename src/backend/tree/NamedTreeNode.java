package backend.tree;

public class NamedTreeNode extends TreeNode {
    private final String name;
    private boolean isLeaf;

    public NamedTreeNode(String name) {
        this.name = name;
    }

    public NamedTreeNode(TreeNode parent) {
        super(parent);
        this.name = "";
    }

    public NamedTreeNode(TreeNode parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void makeAsLeaf() {
        isLeaf = true;
    }

    public void makeAsBranch() {
        isLeaf = false;
    }
}
