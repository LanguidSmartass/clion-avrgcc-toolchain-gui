package view.compiler;

import view.JPanelHolder;
import view.resources.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class Directories implements JPanelHolder {
    private JPanel topPanel;
    private RecordsList directoriesRecords;

    public Directories() {
        ResourceBundle bundle = PluginBundle.getProjectsSettingsLabelsBundle();
        String dirslabel = bundle.getString("avrgnu.cCompiler.directs.label.incpath");
        directoriesRecords.setLabelText(dirslabel);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
