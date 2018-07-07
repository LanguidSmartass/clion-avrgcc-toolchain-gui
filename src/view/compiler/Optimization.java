package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Optimization implements JPanelHolder {
    private JPanel topPanel;
    private JFormattedTextField formattedTextField2;
    private JComboBox comboBox1;
    private JCheckBox prepareFunctionsForGarbageCheckBox;
    private JCheckBox prepareDataForGarbageCheckBox;
    private JCheckBox pachStructureMembersTogetherCheckBox;
    private JCheckBox allocateOnlyAsManyCheckBox;
    private JCheckBox useRjmpRcallLimitedCheckBox;
    private JPanel vertAlignPanel;
    private JPanel optimComboBoxPanel;
    private JPanel otherFlagsTextFieldPanel;
    private JPanel checkBoxPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
