package view.compiler;

import model.persistence.ProjectSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Debugging implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel dbgLvlComboBoxPanel;
    private JPanel dbgFlagsTextFieldPanel;

    private JComboBox<String> dbgLvlComboBox;
    private ArrayList<String> dbgLevels;

    private final String dbgLvlnnLabelTag = "avrgnu.compiler.debug.combobox.dbglevel.none";
    private final String dbgLvlg1LabelTag = "avrgnu.compiler.debug.combobox.dbglevel.g1";
    private final String dbgLvlg2LabelTag = "avrgnu.compiler.debug.combobox.dbglevel.g2";
    private final String dbgLvlg3LabelTag = "avrgnu.compiler.debug.combobox.dbglevel.g3";

    private JTextField flagsTextField;

    public Debugging() {
        initMutableComponents();
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
        dbgLvlComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                saveComboBox(dbgLvlComboBox.getSelectedIndex());
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    private void initComboBox() {
        ResourceBundle bundle = PluginBundle.getProjectsSettingsLabelsBundle();
        dbgLevels = new ArrayList<>();
        dbgLevels.add(bundle.getString(dbgLvlnnLabelTag));
        dbgLevels.add(bundle.getString(dbgLvlg1LabelTag));
        dbgLevels.add(bundle.getString(dbgLvlg2LabelTag));
        dbgLevels.add(bundle.getString(dbgLvlg3LabelTag));

        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        String selDbgLvl = projectSettings.getCompCDebugLevel();
        if (selDbgLvl == null) return;

        int i = 0;
        int idx = 0;
        for (String lvl : dbgLevels) {
            dbgLvlComboBox.addItem(lvl);
            if (lvl.equals(selDbgLvl)) idx = i;
            ++i;
        }
        // reset the default data if 'selDbgLvl' is incorrect
        if (idx >= dbgLevels.size()) {
            projectSettings.setCompCDebugLevel(dbgLevels.get(0));
            idx = 0;
        }
        dbgLvlComboBox.setSelectedIndex(idx);
    }

    private void initTextField() {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        String text = projectSettings.getCompCOtherDebugFlags();
        if (text == null) return;
        flagsTextField.setText(text);
    }

    private void initMutableComponents() {
        initComboBox();
        initTextField();
    }

    private void saveComboBox(int idx) {
        if ((idx < 0) || (idx >= dbgLevels.size())) return;
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        projectSettings.setCompCDebugLevel(dbgLevels.get(idx));
    }

    private void saveTextField(String text) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        projectSettings.setCompCOtherDebugFlags(text);
    }
}
