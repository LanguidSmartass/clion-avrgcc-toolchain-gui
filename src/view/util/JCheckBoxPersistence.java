package view.util;

import model.persistence.ProjectSettings;
import view.compiler.CompilerSelector;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class JCheckBoxPersistence {

    public static void initCommonCheckBox(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getCommonFlags();
        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        Boolean state = flags.get(projectsSettingsFlagsBundle.getString(resourceTag));
        if (state == null) return;
        checkBox.setSelected(state);
    }

    public static void processCommonCheckBoxAction(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getCommonFlags();

        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        String key = projectsSettingsFlagsBundle.getString(resourceTag);
        Boolean val = checkBox.isSelected();
        if (!flags.containsKey(key)) {
            flags.put(key, val);
        } else {
            flags.replace(key, val);
        }
    }

    public static void initCompilerCheckBox(CompilerSelector compiler, JCheckBox checkBox, String resourceTag) {
        HashMap<String, Boolean> flags = compiler.getCompilerFlags();
        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        Boolean state = flags.get(projectsSettingsFlagsBundle.getString(resourceTag));
        if (state == null) return;
        checkBox.setSelected(state);
    }

    public static void processCompilerCheckBoxAction(CompilerSelector compiler, JCheckBox checkBox, String resourceTag) {
        HashMap<String, Boolean> flags = compiler.getCompilerFlags();

        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        String key = projectsSettingsFlagsBundle.getString(resourceTag);
        Boolean val = checkBox.isSelected();
        if (!flags.containsKey(key)) {
            flags.put(key, val);
        } else {
            flags.replace(key, val);
        }
    }

    public static void initLinkerCheckBox(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getLinkerFlags();
        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        Boolean state = flags.get(projectsSettingsFlagsBundle.getString(resourceTag));
        if (state == null) return;
        checkBox.setSelected(state);
    }

    public static void processLinkerCheckBoxAction(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getLinkerFlags();

        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        String key = projectsSettingsFlagsBundle.getString(resourceTag);
        Boolean val = checkBox.isSelected();
        if (!flags.containsKey(key)) {
            flags.put(key, val);
        } else {
            flags.replace(key, val);
        }
    }

    public static void initAsmCheckBox(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getAsmFlags();
        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        Boolean state = flags.get(projectsSettingsFlagsBundle.getString(resourceTag));
        if (state == null) return;
        checkBox.setSelected(state);
    }

    public static void processAsmCheckBoxAction(JCheckBox checkBox, String resourceTag) {
        ProjectSettings projectSettings = ProjectSettings.getInstance();
        if (projectSettings == null) return;
        HashMap<String, Boolean> flags = projectSettings.getAsmFlags();

        ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();
        String key = projectsSettingsFlagsBundle.getString(resourceTag);
        Boolean val = checkBox.isSelected();
        if (!flags.containsKey(key)) {
            flags.put(key, val);
        } else {
            flags.replace(key, val);
        }
    }

}
