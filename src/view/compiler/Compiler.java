package view.compiler;

import view.JPanelHolder;

import javax.swing.*;

public class Compiler implements JPanelHolder {
    private CompilerSelector compiler;

    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JTextArea optionsTextArea;
    private JTextField commandTextField;

    public Compiler(CompilerSelector compiler) {
        this.compiler = compiler;
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
