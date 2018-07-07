package view.linker;

import view.JPanelHolder;

import javax.swing.*;

public class Linker implements JPanelHolder {
    private JPanel topPanel;
    private JFormattedTextField avrGFormattedTextField;
    private JTextArea allOptionsTextArea;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
