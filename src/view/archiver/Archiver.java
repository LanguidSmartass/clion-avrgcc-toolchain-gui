package view.archiver;

import view.JPanelHolder;

import javax.swing.*;

public class Archiver implements JPanelHolder {
    private JPanel topPanel;
    private JFormattedTextField formattedTextField1;
    private JTextArea textArea1;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
