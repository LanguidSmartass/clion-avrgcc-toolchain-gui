package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Compiler implements JPanelHolder {
    private JTextArea optionsTextArea;
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextField commandTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
