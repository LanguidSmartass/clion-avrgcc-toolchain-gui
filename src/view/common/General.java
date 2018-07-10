package view.common;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import model.persistence.ProjectSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class General implements JPanelHolder {
    private JPanel topPanel;

    private JTextField devNameTextField;

    private JList<String> incPathsList;
    private DefaultListModel<String> includePathListModel;

    private JCheckBox relaxBranchesMrelaxCheckBox;
    private JCheckBox externalRamCheckForCheckBox;
    private final String relaxBranchesResourceTag = "avrgnu.common.general.chbox.mrelax";
    private final String externalRamCheckResourceTag = "avrgnu.common.general.chbox.ramovfcheck";

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    public General() {
        initMutableElements();
        relaxBranchesMrelaxCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(relaxBranchesMrelaxCheckBox, relaxBranchesResourceTag);
            }
        });
        externalRamCheckForCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(externalRamCheckForCheckBox, externalRamCheckResourceTag);
            }
        });
    }

    private void initList() {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        ArrayList<String> includePaths = projectSettings.getCommonDefaultIncludePaths();
        includePathListModel = new DefaultListModel<>();
        int i = 0;
        for (String path : includePaths)
            includePathListModel.add(i++, path);
        incPathsList.setModel(includePathListModel);
    }

    private void initCheckBoxes() {
        JCheckBoxPersistence.initCheckBox(relaxBranchesMrelaxCheckBox, relaxBranchesResourceTag);
        JCheckBoxPersistence.initCheckBox(externalRamCheckForCheckBox, externalRamCheckResourceTag);
    }

    private void initMutableElements() {
        initList();
        initCheckBoxes();
    }

}
