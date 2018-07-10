package view.compiler;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Preprocessor implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JCheckBox nostdincCheckBox;
    private JCheckBox preprocessOnlyECheckBox;

    private final String nostdincResourceTag = "avrgnu.compiler.preproc.chbox.nostdinc";
    private final String preprocessOnlyEResourceTag = "avrgnu.compiler.preproc.chbox.preproconly";

    public Preprocessor() {
        JCheckBoxPersistence.initCheckBox(nostdincCheckBox, nostdincResourceTag);
        JCheckBoxPersistence.initCheckBox(preprocessOnlyECheckBox, preprocessOnlyEResourceTag);
        nostdincCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(nostdincCheckBox, nostdincResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(preprocessOnlyECheckBox, preprocessOnlyEResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
