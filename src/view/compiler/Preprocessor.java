package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Preprocessor implements JPanelHolder {
    private JCheckBox doNotSearchSystemCheckBox;
    private JCheckBox preprocessOnlyECheckBox;
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
