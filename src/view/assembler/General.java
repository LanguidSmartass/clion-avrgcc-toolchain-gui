package view.assembler;

import view.JPanelHolder;
import view.resources.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JCheckBox announceVersionVCheckBox;
    private RecordsList incPathsRecords;
    private JTextField flagsTextField;

    public General() {
        ResourceBundle bundle = PluginBundle.getProjectsSettingsLabelsBundle();
        String incPathsLabel = bundle.getString("avrgnu.assembler.general.label.incpath");
        incPathsRecords.setLabelText(incPathsLabel);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
