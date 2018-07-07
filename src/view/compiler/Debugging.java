package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Debugging implements JPanelHolder {
    private JPanel topPanel;
    private JComboBox comboBox1;
    private JFormattedTextField formattedTextField1;
    private JPanel vertAlignPanel;
    private JPanel dbgLvlComboBoxPanel;
    private JPanel dbgFlagsTextFieldPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
