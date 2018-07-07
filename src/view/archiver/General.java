package view.archiver;

import view.JPanelHolder;

import javax.swing.*;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextField flagsTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
