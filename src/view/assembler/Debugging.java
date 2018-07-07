package view.assembler;

import view.JPanelHolder;

import javax.swing.*;

public class Debugging implements JPanelHolder {
    private JComboBox dbgLvlComboBox;
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
