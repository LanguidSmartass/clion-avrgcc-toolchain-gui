package view.compiler;

import model.persistence.ProjectSettings;
import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Miscellaneous implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel otherFlagsTextFieldPanel;
    private JPanel checkBoxPanel;

    private JTextField flagsTextField;

    private JCheckBox verboseVCheckBox;
    private JCheckBox supportANSIProgramsAnsiCheckBox;
    private JCheckBox doNotDeleteTemporaryCheckBox;

    private final String verboseVResourceTag = "avrgnu.compiler.misc.chbox.verbose";
    private final String supportANSIProgramsAnsiResourceTag = "avrgnu.compiler.misc.chbox.ansisupport";
    private final String doNotDeleteTemporaryResourceTag = "avrgnu.compiler.misc.chbox.savetemps";

    public Miscellaneous() {
        initTextField();
        JCheckBoxPersistence.initCheckBox(verboseVCheckBox, verboseVResourceTag);
        JCheckBoxPersistence.initCheckBox(supportANSIProgramsAnsiCheckBox, supportANSIProgramsAnsiResourceTag);
        JCheckBoxPersistence.initCheckBox(doNotDeleteTemporaryCheckBox, doNotDeleteTemporaryResourceTag);
        verboseVCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(verboseVCheckBox, verboseVResourceTag);
            }
        });
        supportANSIProgramsAnsiCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(supportANSIProgramsAnsiCheckBox, supportANSIProgramsAnsiResourceTag);
            }
        });
        doNotDeleteTemporaryCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(doNotDeleteTemporaryCheckBox, doNotDeleteTemporaryResourceTag);
            }
        });
        flagsTextField.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been released.
             *
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                saveTextField(flagsTextField.getText());
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    private void initTextField() {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        String text = projectSettings.getCompCOtherMiscFlags();
        if (text == null) return;
        flagsTextField.setText(text);
    }

    private void saveTextField(String text) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        projectSettings.setCompCOtherMiscFlags(text);
    }
}
