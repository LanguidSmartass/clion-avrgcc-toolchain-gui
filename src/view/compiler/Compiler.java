package view.compiler;

import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.util.ResourceBundle;

public class Compiler implements JPanelHolder {
    private CompilerSelector compiler;

    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextField commandTextField;
    private JTextArea optionsTextArea;

    public Compiler(CompilerSelector compiler) {
        this.compiler = compiler;
        initImmutableComponents();
    }

    private void initImmutableComponents() {
        commandTextField.setText(compiler.getImmutableExecutableName());
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
