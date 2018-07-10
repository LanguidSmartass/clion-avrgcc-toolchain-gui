package view.compiler;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Preprocessor implements JPanelHolder {
    private CompilerSelector compiler;
    
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JCheckBox nostdincCheckBox;
    private JCheckBox preprocessOnlyECheckBox;

    private final String nostdincResourceTag = "avrgnu.compiler.preproc.chbox.nostdinc";
    private final String preprocessOnlyEResourceTag = "avrgnu.compiler.preproc.chbox.preproconly";

    public Preprocessor(CompilerSelector compiler) {
        this.compiler = compiler;
        
        JCheckBoxPersistence.initCompilerCheckBox(compiler, nostdincCheckBox, nostdincResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, preprocessOnlyECheckBox, preprocessOnlyEResourceTag);
        nostdincCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, nostdincCheckBox, nostdincResourceTag);
            }
        });
        preprocessOnlyECheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, preprocessOnlyECheckBox, preprocessOnlyEResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
