package view.assembler;

import view.JPanelHolder;
import view.resources.PluginBundle;
import view.formElements.RecordsList;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JTextField flagsTextField;
    private RecordsList incPathsRecords;

    private JCheckBox announceVersionVCheckBox;

    private final String announceVersionVResourceTag = "avrgnu.assembler.general.chbox.anver";

    public General() {
        JCheckBoxPersistence.initAsmCheckBox(announceVersionVCheckBox, announceVersionVResourceTag);

        ResourceBundle bundle = PluginBundle.getProjectSettingsLabelsBundle();
        String incPathsLabel = bundle.getString("avrgnu.assembler.general.label.incpath");
        incPathsRecords.setLabelText(incPathsLabel);

        announceVersionVCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processAsmCheckBoxAction(announceVersionVCheckBox, announceVersionVResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
