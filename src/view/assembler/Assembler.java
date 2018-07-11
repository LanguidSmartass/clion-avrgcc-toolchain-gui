package view.assembler;

import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.ResourceBundle;

public class Assembler implements JPanelHolder {
    private JPanel topPanel;
    private JTextField commandTextField;
    private JTextArea optionsTextArea;

    public Assembler() {
        initImmutableComponents();
    }

    private void initImmutableComponents() {
        ResourceBundle immutableBundle = PluginBundle.getImmutableTextContents();
        commandTextField.setText(immutableBundle.getString("avrgnu.executable.name.assembler"));
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
