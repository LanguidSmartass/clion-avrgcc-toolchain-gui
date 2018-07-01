package backend.tree;

import java.util.ArrayList;

public class TreeNode {
    private final TreeNode parent;
    private ArrayList<TreeNode> children;

    public TreeNode() {
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public TreeNode(TreeNode parent) {
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public TreeNode(TreeNode parent, ArrayList<TreeNode> children) {
        this.parent = parent;
        this.children = children;
    }

    public TreeNode getParent()      { return parent; }
    public TreeNode getChild(int n)  { return children.get(n); }
    public void    addChild(TreeNode c) { children.add(c); }

    public boolean hasChild(int n)  { return (0 <= n) && (n < children.size()); }
    public int     getChildCount()  { return children.size(); }
    public int     getChildIndex(TreeNode c)  {
        for (int i = 0; i < children.size(); ++i) {
            if (c == children.get(i)) return i;
        }
        throw new java.lang.RuntimeException("No such object in children list");
    }
}
