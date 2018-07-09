package view.common;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import model.persistence.ProjectSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class General implements JPanelHolder {
    private JCheckBox relaxBranchesMrelaxCheckBox;
    private JCheckBox externalRamCheckForCheckBox;
    private final String relaxBranchesResourceTag = "avrgnu.common.general.chbox.mrelax";
    private final String externalRamCheckResourceTag = "avrgnu.common.general.chbox.ramovfcheck";

    private JPanel topPanel;
    private JList incPathsList;
    private JTextField devNameTextField;

    private HashMap<String, Boolean> flags;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    public General() {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        flags = projectSettings.getCommonFlags();

        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectsSettingsFlagsBundle();

        Boolean mrelax = flags.get(projectsSettingsFlagsBundle.getString(relaxBranchesResourceTag));
        Boolean ramChk = flags.get(projectsSettingsFlagsBundle.getString(externalRamCheckResourceTag));
        if (mrelax != null) relaxBranchesMrelaxCheckBox.setSelected(mrelax);
        if (ramChk != null) relaxBranchesMrelaxCheckBox.setSelected(ramChk);
    }
}
