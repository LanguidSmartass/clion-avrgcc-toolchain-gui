package view.archiver;

import view.JPanelHolder;

import javax.swing.*;

public class Archiver implements JPanelHolder {
    private JPanel topPanel;
    private JTextArea optionsTextArea;
    private JPanel vertAlignPanel;
    private JTextField commandTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
