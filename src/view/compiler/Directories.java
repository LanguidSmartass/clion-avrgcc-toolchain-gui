package view.compiler;

import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class Directories {
    private JPanel topPanel;
    private RecordsList directoriesRecords;

    Directories() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String dirslabel = bundle.getString("settings.toolchain.avrgnu.cCompiler.directs.label.incpath");
        directoriesRecords.setLabelText(dirslabel);
    }
}
