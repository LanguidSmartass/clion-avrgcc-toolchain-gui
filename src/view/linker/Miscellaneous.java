package view.linker;

import view.JPanelHolder;

import javax.swing.*;

public class Miscellaneous implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextField flagsTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
