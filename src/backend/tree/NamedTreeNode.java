package backend.tree;

public class NamedTreeNode extends TreeNode {
    private final String name;
    private boolean isLeaf;
    private ExtendedSettings settings;

    public NamedTreeNode(String name) {
        this.name = name;
        this.settings = null;
    }

    public NamedTreeNode(String name, ExtendedSettings settings) {
        this.name = name;
        this.settings = settings;
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

    public ExtendedSettings getSettings() { return settings; }
}
