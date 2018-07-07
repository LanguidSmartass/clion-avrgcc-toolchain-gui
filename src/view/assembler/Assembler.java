package view.assembler;

import view.JPanelHolder;

import javax.swing.*;

public class Assembler implements JPanelHolder {
    private JPanel topPanel;
    private JFormattedTextField formattedTextField1;
    private JTextArea textArea1;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
