package view.archiver;

import view.JPanelHolder;

import javax.swing.*;

public class General implements JPanelHolder {
    private JFormattedTextField flagsTextField;
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
