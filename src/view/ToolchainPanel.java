package view;

import model.NamedTreeNode;
import com.intellij.openapi.Disposable;
import com.intellij.ui.treeStructure.Tree;
import view.archiver.General;
import view.common.Common;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;

public class ToolchainPanel extends JPanel implements Disposable {
    private JPanel topPanel;
    private Tree treeView;
    private JPanel cardsPanel;
    private Common common;
    private view.TreeModel model;

    public ToolchainPanel(view.TreeModel model) {
        this.model = model;
        treeView.setModel(model);


    }

    public void addTreeListener(TreeSelectionListener tl) {
        treeView.addTreeSelectionListener(tl);
    }

    public void updatePanelView(JPanel panel) {
    }

    @Override
    public void dispose() {
    }

    public JPanel getPanel() {
        return topPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

