package view.linker;

import model.persistence.ProjectSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

public class MemorySettings implements JPanelHolder {
    private JPanel topPanel;
    private JPanel stackAddrPanel;
    private JPanel segmValSyntPanel;
    private JPanel avrPortGccPanel;

    private JTextField stackAddrTextField;
    private JTextField segValSyntTextField;
    private JTextArea AVRportOfGccTextArea;
    private RecordsList flashRecords;
    private RecordsList sramRecords;
    private RecordsList eepromRecords;

    public MemorySettings() {
        initImmutableComponents();
        initMutableComponents();

        stackAddrTextField.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been released.
             *
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    private void initStackAddrTextField() {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        String text = projectSettings.getLinkerInitStackAddr();
        if (text == null) return;
        stackAddrTextField.setText(text);
    }

    private void initRecords() {
        ResourceBundle bundle = PluginBundle.getProjectsSettingsLabelsBundle();
        String flashLabel = bundle.getString("avrgnu.linker.memsettings.label.flash");
        String sramLabel = bundle.getString("avrgnu.linker.memsettings.label.sram");
        String eepromLabel = bundle.getString("avrgnu.linker.memsettings.label.eeprom");
        flashRecords.setLabelText(flashLabel);
        sramRecords.setLabelText(sramLabel);
        eepromRecords.setLabelText(eepromLabel);
    }

    private void initMutableComponents() {
        initStackAddrTextField();
        initRecords();
    }

    private void initImmutableComponents() {
        ResourceBundle immutableBundle = PluginBundle.getImmutableTextContents();
        segValSyntTextField.setText(immutableBundle.getString("avrgnu.linker.memsettings.segment.value.syntax"));
        AVRportOfGccTextArea.setText(immutableBundle.getString("avrgnu.linker.memsettings.avr.port.of.gcc"));
    }

    private void saveTextField(String text) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        projectSettings.setLinkerInitStackAddr(text);
    }
}
