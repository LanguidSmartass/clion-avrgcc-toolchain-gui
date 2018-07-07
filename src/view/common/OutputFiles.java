package view.common;

import view.JPanelHolder;

import javax.swing.*;

public class OutputFiles implements JPanelHolder {
    private JPanel topPanel;
    private JCheckBox hexGenerateHexFileCheckBox;
    private JCheckBox lssGenerateLssFileCheckBox;
    private JCheckBox eepGenerateEepFileCheckBox;
    private JCheckBox srecGenerateSrecFileCheckBox;
    private JCheckBox usersignaturesGenerateUsersignaturesFileCheckBox;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
