package view.linker;

import view.JPanelHolder;

import javax.swing.*;

public class Linker implements JPanelHolder {
    private JPanel topPanel;
    private JTextArea optionsTextArea;
    private JPanel vertAlignPanel;
    private JTextField commandTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
