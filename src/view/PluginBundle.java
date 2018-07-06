package view;

import java.util.ResourceBundle;

public class PluginBundle {
    // hardcoded file name
    private static final String bundleFileName = "Plugin";

    public static ResourceBundle get() {
        return ResourceBundle.getBundle(bundleFileName);
    }
}
