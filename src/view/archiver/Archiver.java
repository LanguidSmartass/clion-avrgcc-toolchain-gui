package view.archiver;

import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.ResourceBundle;

public class Archiver implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextField commandTextField;
    private JTextArea optionsTextArea;

    public Archiver() {
        initImmutableComponents();
    }

    private void initImmutableComponents() {
        ResourceBundle immutableBundle = PluginBundle.getImmutableTextContents();
        commandTextField.setText(immutableBundle.getString("avrgnu.executable.name.archiver"));
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }


}
