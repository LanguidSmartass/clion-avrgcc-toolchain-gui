package view.common;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import model.persistence.ProjectSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;

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

    private final ProjectSettings projectSettings;
    private final ResourceBundle projectsSettingsFlagsBundle;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    public General() {
        projectSettings = ProjectSettings.getInstance();
        projectsSettingsFlagsBundle = PluginBundle.getProjectsSettingsFlagsBundle();

        initMutableElements();

        relaxBranchesMrelaxCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                processCheckBoxAction(relaxBranchesMrelaxCheckBox, relaxBranchesResourceTag);
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
                processCheckBoxAction(externalRamCheckForCheckBox, externalRamCheckResourceTag);
            }
        });
    }

    private void initList() {
        if (projectSettings == null) return;
        ArrayList<String> includePaths = projectSettings.getCommonDefaultIncludePaths();
        includePathListModel = new DefaultListModel<>();
        int i = 0;
        for (String path : includePaths)
            includePathListModel.add(i++, path);
        incPathsList.setModel(includePathListModel);
    }

    private void initCheckBoxes() {
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getCommonFlags();
        Boolean mrelax = flags.get(projectsSettingsFlagsBundle.getString(relaxBranchesResourceTag));
        Boolean ramChk = flags.get(projectsSettingsFlagsBundle.getString(externalRamCheckResourceTag));
        if (mrelax != null) relaxBranchesMrelaxCheckBox.setSelected(mrelax);
        if (ramChk != null) externalRamCheckForCheckBox.setSelected(ramChk);
    }

    private void initMutableElements() {
        // Must follow strictly in that order
        initList();
        initCheckBoxes();
    }

    private void processCheckBoxAction(JCheckBox checkBox, String tag) {
        if (projectSettings == null) return;
        String key = projectsSettingsFlagsBundle.getString(tag);
        Boolean val = checkBox.isSelected();
        HashMap<String, Boolean> flags = projectSettings.getCommonFlags();
        if (!flags.containsKey(key)) {
            flags.put(key, val);
        } else {
            flags.replace(key, val);
        }
    }
}
