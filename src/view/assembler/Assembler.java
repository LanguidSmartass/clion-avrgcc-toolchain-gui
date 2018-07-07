package view.assembler;

import view.JPanelHolder;

import javax.swing.*;

public class Assembler implements JPanelHolder {
    private JPanel topPanel;
    private JTextArea optionsTextArea;
    private JTextField commandTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
