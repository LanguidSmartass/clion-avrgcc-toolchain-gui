package view.linker;

import view.JPanelHolder;
import view.resources.PluginBundle;
import view.formElements.RecordsList;
import java.util.ResourceBundle;

import javax.swing.*;

public class Libraries implements JPanelHolder {
    private JPanel topPanel;
    private RecordsList librariesRecords;
    private RecordsList libsearchpathRecords;

    public Libraries() {
        ResourceBundle bundle = PluginBundle.getProjectsSettingsLabelsBundle();
        String librariesstr = bundle.getString("settings.toolchain.avrgnu.linker.libraries.label.libraries");
        String libsearchpathstr = bundle.getString("settings.toolchain.avrgnu.linker.libraries.label.libsearchpath");
        librariesRecords.setLabelText(librariesstr);
        libsearchpathRecords.setLabelText(libsearchpathstr);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
