package view.compiler;

import view.JPanelHolder;
import view.resources.PluginBundle;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Optimization implements JPanelHolder {
    private CompilerSelector compiler;
    
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel optimComboBoxPanel;
    private JPanel otherFlagsTextFieldPanel;
    private JPanel checkBoxPanel;

    private JComboBox<String> optLvlComboBox;
    private ArrayList<String> optLvlLabels;
    private ArrayList<String> optLvlFlags;

    private final String optLvlo0LabelTag = "avrgnu.compiler.optimzn.combobox.optlevel.O0";
    private final String optLvlo1LabelTag = "avrgnu.compiler.optimzn.combobox.optlevel.O1";
    private final String optLvlo2LabelTag = "avrgnu.compiler.optimzn.combobox.optlevel.O2";
    private final String optLvlo3LabelTag = "avrgnu.compiler.optimzn.combobox.optlevel.O3";
    private final String optLvlosLabelTag = "avrgnu.compiler.optimzn.combobox.optlevel.Os";
    private final String optLvlogLabelTag = "avrgnu.compiler.optimzn.combobox.optlevel.Og";

    private final String optLvlo0FlagTag = "avrgnu.compiler.optimzn.combobox.optlevel.O0";
    private final String optLvlo1FlagTag = "avrgnu.compiler.optimzn.combobox.optlevel.O1";
    private final String optLvlo2FlagTag = "avrgnu.compiler.optimzn.combobox.optlevel.O2";
    private final String optLvlo3FlagTag = "avrgnu.compiler.optimzn.combobox.optlevel.O3";
    private final String optLvlosFlagTag = "avrgnu.compiler.optimzn.combobox.optlevel.Os";
    private final String optLvlogFlagTag = "avrgnu.compiler.optimzn.combobox.optlevel.Og";

    private JTextField flagsTextField;

    private JCheckBox prepareFunctionsForGarbageCheckBox;
    private JCheckBox prepareDataForGarbageCheckBox;
    private JCheckBox packStructureMembersTogetherCheckBox;
    private JCheckBox allocateOnlyAsManyCheckBox;
    private JCheckBox useRjmpRcallLimitedCheckBox;

    private final String prepareFunctionsForGarbageResourceTag = "avrgnu.compiler.optimzn.chbox.ffuncsect";
    private final String prepareDataForGarbageResourceTag = "avrgnu.compiler.optimzn.chbox.fdatasect";
    private final String packStructureMembersTogetherResourceTag = "avrgnu.compiler.optimzn.chbox.fpackstruct";
    private final String allocateOnlyAsManyResourceTag = "avrgnu.compiler.optimzn.chbox.fshortenums";
    private final String useRjmpRcallLimitedResourceTag = "avrgnu.compiler.optimzn.chbox.mshortcalls";

    public Optimization(CompilerSelector compilerSel) {
        this.compiler = compilerSel; 
        initMutableComponents();
        prepareFunctionsForGarbageCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, prepareFunctionsForGarbageCheckBox, prepareFunctionsForGarbageResourceTag);
            }
        });
        prepareDataForGarbageCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, prepareDataForGarbageCheckBox, prepareDataForGarbageResourceTag);
            }
        });
        packStructureMembersTogetherCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, packStructureMembersTogetherCheckBox, packStructureMembersTogetherResourceTag);
            }
        });
        allocateOnlyAsManyCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, allocateOnlyAsManyCheckBox, allocateOnlyAsManyResourceTag);
            }
        });
        useRjmpRcallLimitedCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, useRjmpRcallLimitedCheckBox, useRjmpRcallLimitedResourceTag);
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
        optLvlComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                saveComboBox(optLvlComboBox.getSelectedIndex());
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
        optLvlLabels = new ArrayList<>();
        optLvlLabels.add(labelsBundle.getString(optLvlo0LabelTag));
        optLvlLabels.add(labelsBundle.getString(optLvlo1LabelTag));
        optLvlLabels.add(labelsBundle.getString(optLvlo2LabelTag));
        optLvlLabels.add(labelsBundle.getString(optLvlo3LabelTag));
        optLvlLabels.add(labelsBundle.getString(optLvlosLabelTag));
        optLvlLabels.add(labelsBundle.getString(optLvlogLabelTag));

        for (String lvl : optLvlLabels) {
            optLvlComboBox.addItem(lvl);
        }

        optLvlFlags = new ArrayList<>();
        optLvlFlags.add(flagsBundle.getString(optLvlo0FlagTag));
        optLvlFlags.add(flagsBundle.getString(optLvlo1FlagTag));
        optLvlFlags.add(flagsBundle.getString(optLvlo2FlagTag));
        optLvlFlags.add(flagsBundle.getString(optLvlo3FlagTag));
        optLvlFlags.add(flagsBundle.getString(optLvlosFlagTag));
        optLvlFlags.add(flagsBundle.getString(optLvlogFlagTag));
        
        String selectedDbgLvlFlag = compiler.getCompilerOptimLevel();
        if (selectedDbgLvlFlag == null) return;

        int idx = -1;
        for (int i = 0; i < optLvlFlags.size(); ++i) {
            if (optLvlFlags.get(i).equals(selectedDbgLvlFlag)) {
                idx = i;
                break;
            }
        }

        // reset the default data if 'selectedDbgLvlFlag' is incorrect
        if (idx == -1) {
            compiler.setCompilerOptimLevel(optLvlFlags.get(0));
            idx = 0;
        }
        optLvlComboBox.setSelectedIndex(idx);
    }

    private void initTextField() {
        String text = compiler.getCompilerOtherOptimFlags();
        if (text == null) return;
        flagsTextField.setText(text);
    }

    private void initCheckBoxes() {
        JCheckBoxPersistence.initCompilerCheckBox(compiler, prepareFunctionsForGarbageCheckBox, prepareFunctionsForGarbageResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, prepareDataForGarbageCheckBox, prepareDataForGarbageResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, packStructureMembersTogetherCheckBox, packStructureMembersTogetherResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, allocateOnlyAsManyCheckBox, allocateOnlyAsManyResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, useRjmpRcallLimitedCheckBox, useRjmpRcallLimitedResourceTag);
    }

    private void initMutableComponents() {
        initComboBox();
        initTextField();
        initCheckBoxes();
    }

    private void saveComboBox(int idx) {
        if ((idx < 0) || (idx >= optLvlFlags.size())) return;
        compiler.setCompilerOptimLevel(optLvlFlags.get(idx));
    }

    private void saveTextField(String text) {
        compiler.setCompilerOtherOptimFlags(text);
    }
}
