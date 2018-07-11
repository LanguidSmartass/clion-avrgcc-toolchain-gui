package view.compiler;

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
    private CompilerSelector compiler;

    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel dbgLvlComboBoxPanel;
    private JPanel dbgFlagsTextFieldPanel;

    private JComboBox<String> dbgLvlComboBox;
    private ArrayList<String> dbgLevelLabels;
    private ArrayList<String> dbgLevelFlags;

    private final String dbgLvlnnLabelTag = "avrgnu.compiler.debug.combobox.dbglevel.none";
    private final String dbgLvlg1LabelTag = "avrgnu.compiler.debug.combobox.dbglevel.g1";
    private final String dbgLvlg2LabelTag = "avrgnu.compiler.debug.combobox.dbglevel.g2";
    private final String dbgLvlg3LabelTag = "avrgnu.compiler.debug.combobox.dbglevel.g3";
    // there is no 'none' tag
    private final String dbgLvlg1FlagTag = "avrgnu.compiler.debug.combobox.dbglevel.g1";
    private final String dbgLvlg2FlagTag = "avrgnu.compiler.debug.combobox.dbglevel.g2";
    private final String dbgLvlg3FlagTag = "avrgnu.compiler.debug.combobox.dbglevel.g3";

    private JTextField flagsTextField;

    public Debugging(CompilerSelector compiler) {
        this.compiler = compiler;

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
        ResourceBundle labelsBundle = PluginBundle.getProjectSettingsLabelsBundle();
        ResourceBundle flagsBundle  = PluginBundle.getProjectSettingsFlagsBundle();
        dbgLevelLabels = new ArrayList<>();
        dbgLevelLabels.add(labelsBundle.getString(dbgLvlnnLabelTag));
        dbgLevelLabels.add(labelsBundle.getString(dbgLvlg1LabelTag));
        dbgLevelLabels.add(labelsBundle.getString(dbgLvlg2LabelTag));
        dbgLevelLabels.add(labelsBundle.getString(dbgLvlg3LabelTag));

        for (String lvl : dbgLevelLabels) {
            dbgLvlComboBox.addItem(lvl);
        }

        dbgLevelFlags = new ArrayList<>();
        dbgLevelFlags.add("");
        dbgLevelFlags.add(flagsBundle.getString(dbgLvlg1FlagTag));
        dbgLevelFlags.add(flagsBundle.getString(dbgLvlg2FlagTag));
        dbgLevelFlags.add(flagsBundle.getString(dbgLvlg3FlagTag));

        String selectedDbgLvlFlag = compiler.getCompilerDebugLevel();//projectSettings.getCompCDebugLevel();
        if (selectedDbgLvlFlag == null) return;

        int idx = -1;
        for (int i = 0; i < dbgLevelFlags.size(); ++i) {
            if (dbgLevelFlags.get(i).equals(selectedDbgLvlFlag)) {
                idx = i;
                break;
            }
        }

        // reset the default data if 'selectedDbgLvlFlag' is incorrect
        if (idx == -1) {
            compiler.setCompilerDebugLevel(dbgLevelFlags.get(0));
            idx = 0;
        }
        dbgLvlComboBox.setSelectedIndex(idx);
    }

    private void initTextField() {
        String text = compiler.getCompilerOtherDebugFlags();
        if (text == null) return;
        flagsTextField.setText(text);
    }

    private void initMutableComponents() {
        initComboBox();
        initTextField();
    }

    private void saveComboBox(int idx) {
        if ((idx < 0) || (idx >= dbgLevelFlags.size())) return;
        compiler.setCompilerDebugLevel(dbgLevelFlags.get(idx));
    }

    private void saveTextField(String text) {
        compiler.setCompilerOtherDebugFlags(text);
    }
}
