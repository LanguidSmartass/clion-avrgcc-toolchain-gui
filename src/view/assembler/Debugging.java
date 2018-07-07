package view.assembler;

import view.JPanelHolder;

import javax.swing.*;

public class Debugging implements JPanelHolder {
    private JComboBox comboBox1;
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
