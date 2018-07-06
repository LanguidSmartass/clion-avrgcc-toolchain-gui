package view;


import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

// temporarily hardcoded tree structure with names etc.
public class TreeModel implements javax.swing.tree.TreeModel {
    private final TreeNodeWithJPanel root;

    public TreeModel() {
        root = new TreeNodeWithJPanel("Root");

        TreeNodeWithJPanel device = new TreeNodeWithJPanel("Device");
        device.makeAsLeaf();
        root.addChild(device);

        TreeNodeWithJPanel common = new TreeNodeWithJPanel("AVR/GNU Common");
        root.addChild(common);
        {
            TreeNodeWithJPanel general  = new TreeNodeWithJPanel("General");
            TreeNodeWithJPanel outfiles = new TreeNodeWithJPanel("Output Files");
            general.makeAsLeaf();
            outfiles.makeAsLeaf();
            common.addChild(general);
            common.addChild(outfiles);
        }

        TreeNodeWithJPanel ccomp = new TreeNodeWithJPanel("AVR/GNU C Compiler");
        root.addChild(ccomp);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel("General");
            TreeNodeWithJPanel preproc = new TreeNodeWithJPanel("Preprocessor");
            TreeNodeWithJPanel symb    = new TreeNodeWithJPanel("Symbols");
            TreeNodeWithJPanel dirs    = new TreeNodeWithJPanel("Directories");
            TreeNodeWithJPanel optim   = new TreeNodeWithJPanel("Optimization");
            TreeNodeWithJPanel debug   = new TreeNodeWithJPanel("Debugging");
            TreeNodeWithJPanel warns   = new TreeNodeWithJPanel("Warnings");
            TreeNodeWithJPanel misc    = new TreeNodeWithJPanel("Miscellaneous");
            general.makeAsLeaf();
            preproc.makeAsLeaf();
            symb.makeAsLeaf();
            dirs.makeAsLeaf();
            optim.makeAsLeaf();
            debug.makeAsLeaf();
            warns.makeAsLeaf();
            misc.makeAsLeaf();
            ccomp.addChild(general);
            ccomp.addChild(preproc);
            ccomp.addChild(symb);
            ccomp.addChild(dirs);
            ccomp.addChild(optim);
            ccomp.addChild(debug);
            ccomp.addChild(warns);
            ccomp.addChild(misc);
        }

        TreeNodeWithJPanel cppcomp = new TreeNodeWithJPanel("AVR/GNU C++ Compiler");
        root.addChild(cppcomp);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel("General");
            TreeNodeWithJPanel preproc = new TreeNodeWithJPanel("Preprocessor");
            TreeNodeWithJPanel symb    = new TreeNodeWithJPanel("Symbols");
            TreeNodeWithJPanel dirs    = new TreeNodeWithJPanel("Directories");
            TreeNodeWithJPanel optim   = new TreeNodeWithJPanel("Optimization");
            TreeNodeWithJPanel debug   = new TreeNodeWithJPanel("Debugging");
            TreeNodeWithJPanel warns   = new TreeNodeWithJPanel("Warnings");
            TreeNodeWithJPanel misc    = new TreeNodeWithJPanel("Miscellaneous");
            general.makeAsLeaf();
            preproc.makeAsLeaf();
            symb.makeAsLeaf();
            dirs.makeAsLeaf();
            optim.makeAsLeaf();
            debug.makeAsLeaf();
            warns.makeAsLeaf();
            misc.makeAsLeaf();
            cppcomp.addChild(general);
            cppcomp.addChild(preproc);
            cppcomp.addChild(symb);
            cppcomp.addChild(dirs);
            cppcomp.addChild(optim);
            cppcomp.addChild(debug);
            cppcomp.addChild(warns);
            cppcomp.addChild(misc);
        }

        TreeNodeWithJPanel linker = new TreeNodeWithJPanel("AVR/GNU Linker");
        root.addChild(linker);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel("General");
            TreeNodeWithJPanel libs    = new TreeNodeWithJPanel("Libraries");
            TreeNodeWithJPanel optim   = new TreeNodeWithJPanel("Optimization");
            TreeNodeWithJPanel memset  = new TreeNodeWithJPanel("Memory Settings");
            TreeNodeWithJPanel misc    = new TreeNodeWithJPanel("Miscellaneous");
            general.makeAsLeaf();
            libs.makeAsLeaf();
            optim.makeAsLeaf();
            memset.makeAsLeaf();
            misc.makeAsLeaf();
            linker.addChild(general);
            linker.addChild(libs);
            linker.addChild(optim);
            linker.addChild(memset);
            linker.addChild(misc);
        }

        TreeNodeWithJPanel asm = new TreeNodeWithJPanel("AVR/GNU Assembler");
        root.addChild(asm);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel("General");
            TreeNodeWithJPanel debug   = new TreeNodeWithJPanel("Debugging");
            general.makeAsLeaf();
            debug.makeAsLeaf();
            asm.addChild(general);
            asm.addChild(debug);
        }

        TreeNodeWithJPanel arch = new TreeNodeWithJPanel("AVR/GNU Archiver");
        root.addChild(arch);
        {
            TreeNodeWithJPanel general  = new TreeNodeWithJPanel("General");
            general.makeAsLeaf();
            arch.addChild(general);
        }
    }

    /**
     * Returns the root of the tree.  Returns <code>null</code>
     * only if the tree has no nodes.
     *
     * @return the root of the tree
     */
    @Override
    public Object getRoot() {
        return root;
    }

    /**
     * Returns the child of <code>parent</code> at index <code>index</code>
     * in the parent's
     * child array.  <code>parent</code> must be a node previously obtained
     * from this data source. This should not return <code>null</code>
     * if <code>index</code>
     * is a valid index for <code>parent</code> (that is <code>index &gt;= 0 &amp;&amp;
     * index &lt; getChildCount(parent</code>)).
     *
     * @param parent a node in the tree, obtained from this data source
     * @param index  index of child to be returned
     * @return the child of {@code parent} at index {@code index}
     */
    @Override
    public Object getChild(Object parent, int index) {
        return ((TreeNodeWithJPanel)parent).getChild(index);
    }

    /**
     * Returns the number of children of <code>parent</code>.
     * Returns 0 if the node
     * is a leaf or if it has no children.  <code>parent</code> must be a node
     * previously obtained from this data source.
     *
     * @param parent a node in the tree, obtained from this data source
     * @return the number of children of the node <code>parent</code>
     */
    @Override
    public int getChildCount(Object parent) {
        return ((TreeNodeWithJPanel)parent).getChildCount();
    }

    /**
     * Returns <code>true</code> if <code>node</code> is a leaf.
     * It is possible for this method to return <code>false</code>
     * even if <code>node</code> has no children.
     * A directory in a filesystem, for example,
     * may contain no files; the node representing
     * the directory is not a leaf, but it also has no children.
     *
     * @param node a node in the tree, obtained from this data source
     * @return true if <code>node</code> is a leaf
     */
    @Override
    public boolean isLeaf(Object node) {
        return ((TreeNodeWithJPanel)node).isLeaf();
    }

    /**
     * Messaged when the user has altered the value for the item identified
     * by <code>path</code> to <code>newValue</code>.
     * If <code>newValue</code> signifies a truly new value
     * the model should post a <code>treeNodesChanged</code> event.
     *
     * @param path     path to the node that the user has altered
     * @param newValue the new value from the TreeCellEditor
     */
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    /**
     * Returns the index of child in parent.  If either <code>parent</code>
     * or <code>child</code> is <code>null</code>, returns -1.
     * If either <code>parent</code> or <code>child</code> don't
     * belong to this tree model, returns -1.
     *
     * @param parent a node in the tree, obtained from this data source
     * @param child  the node we are interested in
     * @return the index of the child in the parent, or -1 if either
     * <code>child</code> or <code>parent</code> are <code>null</code>
     * or don't belong to this tree model
     */
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        int index = -1;
        for (int i = 0; i < ((TreeNodeWithJPanel) parent).getChildCount(); ++i) {
            if (child == ((TreeNodeWithJPanel) parent).getChild(i)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Adds a listener for the <code>TreeModelEvent</code>
     * posted after the tree changes.
     *
     * @param l the listener to add
     * @see #removeTreeModelListener
     */
    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    /**
     * Removes a listener previously added with
     * <code>addTreeModelListener</code>.
     *
     * @param l the listener to remove
     * @see #addTreeModelListener
     */
    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}
