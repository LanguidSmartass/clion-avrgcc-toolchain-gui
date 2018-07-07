package view.common;

import view.JPanelHolder;

import javax.swing.*;

public class Common implements JPanelHolder {
    private JPanel topPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
