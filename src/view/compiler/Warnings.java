package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Warnings implements JPanelHolder {
    private JPanel topPanel;
    private JCheckBox allWarningsWallCheckBox;
    private JCheckBox extraWarningsWextraCheckBox;
    private JCheckBox warnUndefinedIdentifierInCheckBox;
    private JCheckBox warningsAsErrorsWerrorCheckBox;
    private JCheckBox checkSyntaxOnlyFsyntaxCheckBox;
    private JCheckBox pedanticPedanticCheckBox;
    private JCheckBox pedanticWarningsAsErrorsCheckBox;
    private JCheckBox inhibitAllWarningsWCheckBox;
    private JPanel checkBoxPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
