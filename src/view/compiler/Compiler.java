package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Compiler implements JPanelHolder {
    private JFormattedTextField formattedTextField1;
    private JTextArea textArea1;
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
