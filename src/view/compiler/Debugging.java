package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Debugging implements JPanelHolder {
    private JPanel topPanel;
    private JComboBox dbgLvlComboBox;
    private JPanel vertAlignPanel;
    private JPanel dbgLvlComboBoxPanel;
    private JPanel dbgFlagsTextFieldPanel;
    private JTextField flagsTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
