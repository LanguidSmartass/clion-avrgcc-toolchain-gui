package view.common;

import view.JPanelHolder;

import javax.swing.*;

public class General implements JPanelHolder {
    private JCheckBox relaxBranchesMrelaxCheckBox;
    private JCheckBox externalRamCheckForCheckBox;
    private JFormattedTextField formattedTextField1;
    private JTextArea textArea1;
    private JPanel topPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
