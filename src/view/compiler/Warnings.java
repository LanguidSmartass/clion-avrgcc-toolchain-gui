package view.compiler;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warnings implements JPanelHolder {
    private CompilerSelector compiler;
    
    private JPanel topPanel;
    private JPanel checkBoxPanel;

    private JCheckBox allWarningsWallCheckBox;
    private JCheckBox extraWarningsWextraCheckBox;
    private JCheckBox warnUndefinedIdentifierInCheckBox;
    private JCheckBox warningsAsErrorsWerrorCheckBox;
    private JCheckBox checkSyntaxOnlyFsyntaxCheckBox;
    private JCheckBox pedanticPedanticCheckBox;
    private JCheckBox pedanticWarningsAsErrorsCheckBox;
    private JCheckBox inhibitAllWarningsWCheckBox;

    private final String allWarningsWallResourceTag = "avrgnu.compiler.warning.chbox.wall";
    private final String extraWarningsWextraResourceTag = "avrgnu.compiler.warning.chbox.wextra";
    private final String warnUndefinedIdentifierInResourceTag = "avrgnu.compiler.warning.chbox.wundef";
    private final String warningsAsErrorsWerrorResourceTag = "avrgnu.compiler.warning.chbox.werror";
    private final String checkSyntaxOnlyFsyntaxResourceTag = "avrgnu.compiler.warning.chbox.fsyntaxonly";
    private final String pedanticPedanticResourceTag = "avrgnu.compiler.warning.chbox.pedantic";
    private final String pedanticWarningsAsErrorsResourceTag = "avrgnu.compiler.warning.chbox.pedanticerr";
    private final String inhibitAllWarningsWResourceTag = "avrgnu.compiler.warning.chbox.inhibitall";

    public Warnings(CompilerSelector compiler) {
        this.compiler = compiler;
        
        JCheckBoxPersistence.initCompilerCheckBox(compiler, allWarningsWallCheckBox, allWarningsWallResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, extraWarningsWextraCheckBox, extraWarningsWextraResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, warnUndefinedIdentifierInCheckBox, warnUndefinedIdentifierInResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, warningsAsErrorsWerrorCheckBox, warningsAsErrorsWerrorResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, checkSyntaxOnlyFsyntaxCheckBox, checkSyntaxOnlyFsyntaxResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, pedanticPedanticCheckBox, pedanticPedanticResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, pedanticWarningsAsErrorsCheckBox, pedanticWarningsAsErrorsResourceTag);
        JCheckBoxPersistence.initCompilerCheckBox(compiler, inhibitAllWarningsWCheckBox, inhibitAllWarningsWResourceTag);
        allWarningsWallCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, allWarningsWallCheckBox, allWarningsWallResourceTag);
            }
        });
        extraWarningsWextraCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, extraWarningsWextraCheckBox, extraWarningsWextraResourceTag);
            }
        });
        warnUndefinedIdentifierInCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, warnUndefinedIdentifierInCheckBox, warnUndefinedIdentifierInResourceTag);
            }
        });
        warningsAsErrorsWerrorCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, warningsAsErrorsWerrorCheckBox, warningsAsErrorsWerrorResourceTag);
            }
        });
        checkSyntaxOnlyFsyntaxCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, checkSyntaxOnlyFsyntaxCheckBox, checkSyntaxOnlyFsyntaxResourceTag);
            }
        });
        pedanticPedanticCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, pedanticPedanticCheckBox, pedanticPedanticResourceTag);
            }
        });
        pedanticWarningsAsErrorsCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, pedanticWarningsAsErrorsCheckBox, pedanticWarningsAsErrorsResourceTag);
            }
        });
        inhibitAllWarningsWCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCompilerCheckBoxAction(compiler, inhibitAllWarningsWCheckBox, inhibitAllWarningsWResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
