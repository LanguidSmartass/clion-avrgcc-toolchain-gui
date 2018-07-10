package view.util;

import model.persistence.ProjectSettings;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class JCheckBoxPersistence {

    public static void initCheckBox(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectsSettingsFlagsBundle();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getCommonFlags();
        Boolean state = flags.get(projectsSettingsFlagsBundle.getString(resourceTag));
        if (state == null) return;
        checkBox.setSelected(state);
    }

    public static void processCheckBoxAction(JCheckBox checkBox, String tag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectsSettingsFlagsBundle();
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
