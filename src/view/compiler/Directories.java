package view.compiler;

import view.JPanelHolder;
import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class Directories implements JPanelHolder {
    private JPanel topPanel;
    private RecordsList directoriesRecords;

    public Directories() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String dirslabel = bundle.getString("settings.toolchain.avrgnu.cCompiler.directs.label.incpath");
        directoriesRecords.setLabelText(dirslabel);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
