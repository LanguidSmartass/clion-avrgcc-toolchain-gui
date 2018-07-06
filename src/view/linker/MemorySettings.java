package view.linker;

import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class MemorySettings {
    private JPanel panel1;
    private JPanel stackAddrPanel;
    private JPanel segmValSyntPanel;
    private JPanel avrPortGccPanel;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JTextArea textArea1;
    private RecordsList flashRecords;
    private RecordsList sramRecords;
    private RecordsList eepromRecords;

    MemorySettings() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String flashLabel = bundle.getString("settings.toolchain.avrgnu.linker.memsettings.label.flash");
        String sramLabel = bundle.getString("settings.toolchain.avrgnu.linker.memsettings.label.sram");
        String eepromLabel = bundle.getString("settings.toolchain.avrgnu.linker.memsettings.label.eeprom");
        flashRecords.setLabelText(flashLabel);
        sramRecords.setLabelText(sramLabel);
        eepromRecords.setLabelText(eepromLabel);
    }

}
