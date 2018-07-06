package view;

import model.NamedTreeNode;
import javax.swing.JPanel;

public class TreeNodeWithJPanel extends NamedTreeNode {
    private final PanelHolder panelHolder;

    public TreeNodeWithJPanel(String name) {
        super(name);
        this.panelHolder = null;
    }

    public TreeNodeWithJPanel(String name, PanelHolder panel) {
        super(name);
        this.panelHolder = panel;
    }

    public JPanel getPanel() {
        if (panelHolder == null)
            return null;
        return panelHolder.getPanel();
    }
}
