package view;

import java.util.ResourceBundle;

public class PluginBundle {
    // hardcoded file name
    private static final String bundleFileName = "Plugin";
    private static final String cardNamesFileName = "view.CardsNames";

    public static ResourceBundle getNodeNamesBundle() {
        return ResourceBundle.getBundle(bundleFileName);
    }

    public static ResourceBundle getCardNamesBundle() {
        return ResourceBundle.getBundle(cardNamesFileName);
    }
}
