package frontend.tree;

import backend.tree.NamedTreeNode;
import com.intellij.openapi.Disposable;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class ToolchainPanel extends JPanel implements Disposable {
    private final Tree uiTree;

    public ToolchainPanel() {
        uiTree = new Tree(new frontend.tree.TreeModel());
        uiTree.addTreeSelectionListener(
            new TreeSelectionListener() {
                /**
                 * Called whenever the value of the selection changes.
                 *
                 * @param e the event that characterizes the change.
                 */
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    NamedTreeNode node = (NamedTreeNode)e.getPath().getLastPathComponent();
                    System.out.println(node.toString());
                    node.getSettings();
                }
            }
        );
        this.add(uiTree);
    }

    @Override
    public void dispose() {

    }
}
