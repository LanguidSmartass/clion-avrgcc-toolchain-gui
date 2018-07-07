package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Optimization implements JPanelHolder {
    private JPanel topPanel;
    private JComboBox optLvlComboBox;
    private JCheckBox prepareFunctionsForGarbageCheckBox;
    private JCheckBox prepareDataForGarbageCheckBox;
    private JCheckBox pachStructureMembersTogetherCheckBox;
    private JCheckBox allocateOnlyAsManyCheckBox;
    private JCheckBox useRjmpRcallLimitedCheckBox;
    private JPanel vertAlignPanel;
    private JPanel optimComboBoxPanel;
    private JPanel otherFlagsTextFieldPanel;
    private JPanel checkBoxPanel;
    private JTextField flagsTextField;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
