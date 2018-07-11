package view.linker;

import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.ResourceBundle;

public class Linker implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextField commandTextField;
    private JTextArea optionsTextArea;

    public Linker() {
        initImmutableComponents();
    }

    private void initImmutableComponents() {
        ResourceBundle immutableBundle = PluginBundle.getImmutableTextContents();
        commandTextField.setText(immutableBundle.getString("avrgnu.executable.name.linker"));
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
