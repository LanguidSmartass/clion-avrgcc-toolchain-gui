package controller;

import view.TreeModel;
import view.NodeWithCardName;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class ToolchainPanel {
    private TreeModel model;
    private view.ToolchainPanel view;

    public ToolchainPanel(TreeModel model, view.ToolchainPanel view) {
        this.model = model;
        this.view = view;
        // add listeners
        view.addTreeListener(
            new TreeSelectionListener() {
                /**
                 * Called whenever the value of the selection changes.
                 *
                 * @param e the event that characterizes the change.
                 */
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    switchPanel(e);
                }
            }
        );
    }

    private void switchPanel(TreeSelectionEvent e) {
//        TreePath path = e.getPath();
//        for (int i = 0; i < path.getPathCount(); ++i) {
//            System.out.println(path.getPathComponent(i).toString());
//        }
        NodeWithCardName node = (NodeWithCardName)e.getPath().getLastPathComponent();
        view.updatePanelView(node.getCardName());
    }

}
