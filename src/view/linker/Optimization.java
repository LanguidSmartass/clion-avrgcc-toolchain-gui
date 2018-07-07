package view.linker;

import view.JPanelHolder;

import javax.swing.*;

public class Optimization implements JPanelHolder {
    private JPanel topPanel;
    private JCheckBox garbageCollectUnusedSectionsCheckBox;
    private JCheckBox putReadOnlyDataCheckBox;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
