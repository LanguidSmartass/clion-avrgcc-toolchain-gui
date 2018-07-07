package view.linker;

import view.JPanelHolder;
import view.resources.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class MemorySettings implements JPanelHolder {
    private JPanel topPanel;
    private JPanel stackAddrPanel;
    private JPanel segmValSyntPanel;
    private JPanel avrPortGccPanel;
    private JTextArea textArea1;
    private RecordsList flashRecords;
    private RecordsList sramRecords;
    private RecordsList eepromRecords;
    private JTextField stackAddrTextField;
    private JTextField segValSyntTextField;

    public MemorySettings() {
        ResourceBundle bundle = PluginBundle.getProjectsSettingsLabelsBundle();
        String flashLabel = bundle.getString("settings.toolchain.avrgnu.linker.memsettings.label.flash");
        String sramLabel = bundle.getString("settings.toolchain.avrgnu.linker.memsettings.label.sram");
        String eepromLabel = bundle.getString("settings.toolchain.avrgnu.linker.memsettings.label.eeprom");
        flashRecords.setLabelText(flashLabel);
        sramRecords.setLabelText(sramLabel);
        eepromRecords.setLabelText(eepromLabel);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
