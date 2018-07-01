package backend.tree;
// temporarily hardcoded tree structure with names etc.
public class TreeModel {
    private final NamedTreeNode root;
    public TreeModel() {
        root = new NamedTreeNode("Root");

        for (int i = 0; i < 10; ++i) {
            NamedTreeNode child = new NamedTreeNode("Child #" + i);
            child.makeAsLeaf();
            root.addChild(child);
        }
    }
    public NamedTreeNode getRoot() { return root; }
    public NamedTreeNode getChild(NamedTreeNode parent, int i) { return (NamedTreeNode) parent.getChild(i); }
    public int       getChildCount(NamedTreeNode parent) { return parent.getChildCount(); }
}
