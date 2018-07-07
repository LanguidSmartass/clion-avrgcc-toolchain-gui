package view.assembler;

import view.JPanelHolder;
import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JCheckBox announceVersionVCheckBox;
    private RecordsList incPathsRecords;
    private JTextField flagsTextField;

    public General() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String incPathsLabel = bundle.getString("settings.toolchain.avrgnu.assembler.general.label.incpath");
        incPathsRecords.setLabelText(incPathsLabel);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
