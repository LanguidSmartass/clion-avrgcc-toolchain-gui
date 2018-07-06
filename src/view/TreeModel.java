package view;


import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.ResourceBundle;

// temporarily hardcoded tree structure with names etc.
public class TreeModel implements javax.swing.tree.TreeModel {
    private final TreeNodeWithJPanel root;

    public TreeModel() {
        ResourceBundle nodeNameBundle = PluginBundle.getNodeNamesBundle();
        ResourceBundle cardNameBundle = PluginBundle.getCardNamesBundle();

        root = new TreeNodeWithJPanel("Root");

        TreeNodeWithJPanel device = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.device"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.device")
        );
        device.makeAsLeaf();
        root.addChild(device);

        TreeNodeWithJPanel common = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.common"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.common")
        );
        root.addChild(common);
        {
            TreeNodeWithJPanel general  = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.common.general"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.common.general")
            );
            TreeNodeWithJPanel outfiles = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.common.outputfiles"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.common.outputfiles")
            );
            general.makeAsLeaf();
            outfiles.makeAsLeaf();
            common.addChild(general);
            common.addChild(outfiles);
        }

        TreeNodeWithJPanel ccomp = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler")
        );
        root.addChild(ccomp);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.general"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.general")
            );
            TreeNodeWithJPanel preproc = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.preproc"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.preproc")
            );
            TreeNodeWithJPanel symb    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.symbols"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.symbols")
            );
            TreeNodeWithJPanel dirs    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.directs"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.directs")
            );
            TreeNodeWithJPanel optim   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.optimzn"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.optimzn")
            );
            TreeNodeWithJPanel debug   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.debug"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.debug")
            );
            TreeNodeWithJPanel warns   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.warning"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.warning")
            );
            TreeNodeWithJPanel misc    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.misc"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.misc")
            );
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

        TreeNodeWithJPanel cppcomp = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.cppCompiler"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler")
        );
        root.addChild(cppcomp);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.general"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.general")
            );
            TreeNodeWithJPanel preproc = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.preproc"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.preproc")
            );
            TreeNodeWithJPanel symb    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.symbols"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.symbols")
            );
            TreeNodeWithJPanel dirs    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.directs"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.directs")
            );
            TreeNodeWithJPanel optim   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.optimzn"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.optimzn")
            );
            TreeNodeWithJPanel debug   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.debug"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.debug")
            );
            TreeNodeWithJPanel warns   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.warning"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.warning")
            );
            TreeNodeWithJPanel misc    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.cCompiler.misc"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.misc")
            );
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

        TreeNodeWithJPanel linker = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.linker"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.linker")
        );
        root.addChild(linker);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.linker.general"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.linker.general")
            );
            TreeNodeWithJPanel libs    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.linker.libraries"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.linker.libraries")
            );
            TreeNodeWithJPanel optim   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.linker.optimization"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.linker.optimization")
            );
            TreeNodeWithJPanel memset  = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.linker.memsettings"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.linker.memsettings")
            );
            TreeNodeWithJPanel misc    = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.linker.misc"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.linker.misc")
            );
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

        TreeNodeWithJPanel asm = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.assembler"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.assembler")
        );
        root.addChild(asm);
        {
            TreeNodeWithJPanel general = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.assembler.general"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.assembler.general")
            );
            TreeNodeWithJPanel debug   = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.assembler.debugging"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.assembler.debugging")
            );
            general.makeAsLeaf();
            debug.makeAsLeaf();
            asm.addChild(general);
            asm.addChild(debug);
        }

        TreeNodeWithJPanel arch = new TreeNodeWithJPanel(
                nodeNameBundle.getString("settings.toolchain.avrgnu.archiver"),
                cardNameBundle.getString("cardname.toolchain.avrgnu.archiver")
        );
        root.addChild(arch);
        {
            TreeNodeWithJPanel general  = new TreeNodeWithJPanel(
                    nodeNameBundle.getString("settings.toolchain.avrgnu.archiver.general"),
                    cardNameBundle.getString("cardname.toolchain.avrgnu.archiver.general")
            );
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
