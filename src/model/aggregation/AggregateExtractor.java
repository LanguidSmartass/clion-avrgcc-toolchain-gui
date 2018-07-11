package model.aggregation;

import model.persistence.ApplicationSettings;
import model.persistence.ProjectSettings;
import view.compiler.CompilerSelector;
import view.resources.PluginBundle;

import java.util.ResourceBundle;

public class AggregateExtractor {
    private static ApplicationSettings applicationSettings = ApplicationSettings.getInstance();
    private static ProjectSettings projectSettings = ProjectSettings.getInstance();
    private static ResourceBundle projectsSettingsFlagsBundle = PluginBundle.getProjectSettingsFlagsBundle();

    public static String getProjectToolchainPath() {
        String toolchainName = projectSettings.getSelectedToolchain();
        String flavourName = projectSettings.getSelectedFlavour();
        return applicationSettings.getToolchainFlavourPath(toolchainName, flavourName);
    }

    public static String getDeviceName() {
        return projectSettings.getDeviceName();
    }

    public static Boolean generateHex() {
        String key = projectsSettingsFlagsBundle.getString("avrgnu.common.general.chbox.hex");
        return projectSettings.getCommonFlags().get(key);
    }

    public static Boolean generateLss() {
        String key = projectsSettingsFlagsBundle.getString("avrgnu.common.general.chbox.lss");
        return projectSettings.getCommonFlags().get(key);
    }

    public static Boolean generateEep() {
        String key = projectsSettingsFlagsBundle.getString("avrgnu.common.general.chbox.eep");
        return projectSettings.getCommonFlags().get(key);
    }

    public static Boolean generateSrec() {
        String key = projectsSettingsFlagsBundle.getString("avrgnu.common.general.chbox.srec");
        return projectSettings.getCommonFlags().get(key);
    }

    public static Boolean generateUsing() {
        String key = projectsSettingsFlagsBundle.getString("avrgnu.common.general.chbox.usersignatures");
        return projectSettings.getCommonFlags().get(key);
    }

    public static String getCommomArguments() {
        return null;
    }

    public static String getCompilerArguments(CompilerSelector compiler) {
        return null;
    }

    public static String getLinkerArguments() {
        return null;
    }

    public static String getAssemblerArguments() {
        return null;
    }

    public static String getArchiverArguments() {
        return null;
    }
}
