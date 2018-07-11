package view;


import view.resources.PluginBundle;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.ResourceBundle;

// temporarily hardcoded tree structure with names etc.
public class TreeModel implements javax.swing.tree.TreeModel {
    private final NodeWithCardName root;

    public TreeModel() {
        ResourceBundle applicationSettingsLabels = PluginBundle.getApplicationSettingsLabelsBundle();
        ResourceBundle projectSettingsLabels = PluginBundle.getProjectSettingsLabelsBundle();
        ResourceBundle cardNamesEbmedded = PluginBundle.getCardNamesEmbeddedBundle();

        root = new NodeWithCardName("Root");

        NodeWithCardName toolchain = new NodeWithCardName(
                applicationSettingsLabels.getString("toolchain"),
                cardNamesEbmedded.getString("toolchain")
        );
        toolchain.makeAsLeaf();
        root.addChild(toolchain);

        NodeWithCardName device = new NodeWithCardName(
                projectSettingsLabels.getString("device"),
                cardNamesEbmedded.getString("device")
        );
        device.makeAsLeaf();
        root.addChild(device);

        NodeWithCardName common = new NodeWithCardName(
                projectSettingsLabels.getString("avrgnu.common"),
                cardNamesEbmedded.getString("avrgnu.common")
        );
        root.addChild(common);
        {
            NodeWithCardName general  = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.common.general"),
                    cardNamesEbmedded.getString("avrgnu.common.general")
            );
            NodeWithCardName outfiles = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.common.outputfiles"),
                    cardNamesEbmedded.getString("avrgnu.common.outputfiles")
            );
            general.makeAsLeaf();
            outfiles.makeAsLeaf();
            common.addChild(general);
            common.addChild(outfiles);
        }

        NodeWithCardName ccomp = new NodeWithCardName(
                projectSettingsLabels.getString("avrgnu.compiler.c"),
                cardNamesEbmedded.getString("avrgnu.compiler.c")
        );
        root.addChild(ccomp);
        {
            NodeWithCardName general = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.general"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.general")
            );
            NodeWithCardName preproc = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.preproc"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.preproc")
            );
            NodeWithCardName symb    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.symbols"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.symbols")
            );
            NodeWithCardName dirs    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.directs"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.directs")
            );
            NodeWithCardName optim   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.optimzn"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.optimzn")
            );
            NodeWithCardName debug   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.debug"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.debug")
            );
            NodeWithCardName warns   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.warning"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.warning")
            );
            NodeWithCardName misc    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.misc"),
                    cardNamesEbmedded.getString("avrgnu.compiler.c.misc")
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

        NodeWithCardName cppcomp = new NodeWithCardName(
                projectSettingsLabels.getString("avrgnu.compiler.cpp"),
                cardNamesEbmedded.getString("avrgnu.compiler.cpp")
        );
        root.addChild(cppcomp);
        {
            NodeWithCardName general = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.general"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.general")
            );
            NodeWithCardName preproc = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.preproc"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.preproc")
            );
            NodeWithCardName symb    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.symbols"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.symbols")
            );
            NodeWithCardName dirs    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.directs"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.directs")
            );
            NodeWithCardName optim   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.optimzn"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.optimzn")
            );
            NodeWithCardName debug   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.debug"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.debug")
            );
            NodeWithCardName warns   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.warning"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.warning")
            );
            NodeWithCardName misc    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.compiler.misc"),
                    cardNamesEbmedded.getString("avrgnu.compiler.cpp.misc")
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

        NodeWithCardName linker = new NodeWithCardName(
                projectSettingsLabels.getString("avrgnu.linker"),
                cardNamesEbmedded.getString("avrgnu.linker")
        );
        root.addChild(linker);
        {
            NodeWithCardName general = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.linker.general"),
                    cardNamesEbmedded.getString("avrgnu.linker.general")
            );
            NodeWithCardName libs    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.linker.libraries"),
                    cardNamesEbmedded.getString("avrgnu.linker.libraries")
            );
            NodeWithCardName optim   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.linker.optimization"),
                    cardNamesEbmedded.getString("avrgnu.linker.optimization")
            );
            NodeWithCardName memset  = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.linker.memsettings"),
                    cardNamesEbmedded.getString("avrgnu.linker.memsettings")
            );
            NodeWithCardName misc    = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.linker.misc"),
                    cardNamesEbmedded.getString("avrgnu.linker.misc")
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

        NodeWithCardName asm = new NodeWithCardName(
                projectSettingsLabels.getString("avrgnu.assembler"),
                cardNamesEbmedded.getString("avrgnu.assembler")
        );
        root.addChild(asm);
        {
            NodeWithCardName general = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.assembler.general"),
                    cardNamesEbmedded.getString("avrgnu.assembler.general")
            );
            NodeWithCardName debug   = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.assembler.debugging"),
                    cardNamesEbmedded.getString("avrgnu.assembler.debugging")
            );
            general.makeAsLeaf();
            debug.makeAsLeaf();
            asm.addChild(general);
            asm.addChild(debug);
        }

        NodeWithCardName arch = new NodeWithCardName(
                projectSettingsLabels.getString("avrgnu.archiver"),
                cardNamesEbmedded.getString("avrgnu.archiver")
        );
        root.addChild(arch);
        {
            NodeWithCardName general  = new NodeWithCardName(
                    projectSettingsLabels.getString("avrgnu.archiver.general"),
                    cardNamesEbmedded.getString("avrgnu.archiver.general")
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
        return ((NodeWithCardName)parent).getChild(index);
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
        return ((NodeWithCardName)parent).getChildCount();
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
        return ((NodeWithCardName)node).isLeaf();
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
        for (int i = 0; i < ((NodeWithCardName) parent).getChildCount(); ++i) {
            if (child == ((NodeWithCardName) parent).getChild(i)) {
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
