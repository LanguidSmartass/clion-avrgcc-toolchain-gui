package view.resources;

import java.util.ResourceBundle;

public class PluginBundle {
    // hardcoded file name
    private static final String applicationSettingsLabelsFileName = "view.resources.ApplicationSettingsLabels";
    private static final String cardNamesEmbeddedFileName = "view.resources.CardNamesEmbedded";
    private static final String projectSettingsFlagsFileName = "view.resources.ProjectSettingsFlags";
    private static final String projectSettingsLabelsFileName = "view.resources.ProjectSettingsLabels";

    public static ResourceBundle getApplicationSettingsLabelsBundle() {
        return ResourceBundle.getBundle(applicationSettingsLabelsFileName);
    }

    public static ResourceBundle getCardNamesEmbeddedBundle() {
        return ResourceBundle.getBundle(cardNamesEmbeddedFileName);
    }

    public static ResourceBundle getProjectsSettingsFlagsBundle() {
        return ResourceBundle.getBundle(projectSettingsFlagsFileName);
    }

    public static ResourceBundle getProjectsSettingsLabelsBundle() {
        return ResourceBundle.getBundle(projectSettingsLabelsFileName);
    }
}
