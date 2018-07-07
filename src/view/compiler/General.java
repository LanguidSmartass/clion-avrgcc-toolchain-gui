package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class General implements JPanelHolder {
    private JCheckBox useSubroutinesForFunctionCheckBox;
    private JCheckBox changeTheStackPointerCheckBox;
    private JCheckBox defaultCharTypeIsCheckBox;
    private JCheckBox defaultBitfieldTypeIsCheckBox;
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
