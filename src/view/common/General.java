package view.common;

import view.JPanelHolder;

import javax.swing.*;

public class General implements JPanelHolder {
    private JCheckBox relaxBranchesMrelaxCheckBox;
    private JCheckBox externalRamCheckForCheckBox;
    private JPanel topPanel;
    private JList incPathsList;
    private JTextField devNameTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
