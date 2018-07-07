package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Miscellaneous implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel otherFlagsTextFieldPanel;
    private JPanel checkBoxPanel;
    private JCheckBox verboseVCheckBox;
    private JCheckBox supportANSIProgramsAnsiCheckBox;
    private JCheckBox doNotDeleteTemporaryCheckBox;
    private JTextField flagsTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
