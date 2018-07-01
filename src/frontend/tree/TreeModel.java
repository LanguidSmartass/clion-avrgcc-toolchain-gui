package frontend.tree;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import backend.tree.*;

public class TreeModel implements javax.swing.tree.TreeModel {
    private final backend.tree.TreeModel tree;

    public TreeModel() {
        this.tree = new backend.tree.TreeModel();
    }

    @Override
    public Object getRoot() {
        return tree.getRoot();
    }

    @Override
    public Object getChild(Object parent, int index) {
        return tree.getChild((NamedTreeNode)parent, index);
    }

    @Override
    public int getChildCount(Object parent) {
        return tree.getChildCount((NamedTreeNode)parent);
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((NamedTreeNode)node).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((TreeNode)parent).getChildIndex((TreeNode)child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}
