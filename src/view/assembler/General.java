package view.assembler;

import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class General {
    private JPanel panel1;
    private JFormattedTextField asmFlagsTextField;
    private JCheckBox announceVersionVCheckBox;
    private RecordsList incPathsRecords;

    General() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String incPathsLabel = bundle.getString("settings.toolchain.avrgnu.assembler.general.label.incpath");
        incPathsRecords.setLabelText(incPathsLabel);
    }
}
