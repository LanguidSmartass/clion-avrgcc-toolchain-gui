package view.linker;

import view.JPanelHolder;

import javax.swing.*;

public class Miscellaneous implements JPanelHolder {
    private JPanel topPanel;
    private JFormattedTextField flagsTextField;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
