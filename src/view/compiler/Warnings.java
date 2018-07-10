package view.compiler;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warnings implements JPanelHolder {
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

    public Warnings() {
        JCheckBoxPersistence.initCheckBox(allWarningsWallCheckBox, allWarningsWallResourceTag);
        JCheckBoxPersistence.initCheckBox(extraWarningsWextraCheckBox, extraWarningsWextraResourceTag);
        JCheckBoxPersistence.initCheckBox(warnUndefinedIdentifierInCheckBox, warnUndefinedIdentifierInResourceTag);
        JCheckBoxPersistence.initCheckBox(warningsAsErrorsWerrorCheckBox, warningsAsErrorsWerrorResourceTag);
        JCheckBoxPersistence.initCheckBox(checkSyntaxOnlyFsyntaxCheckBox, checkSyntaxOnlyFsyntaxResourceTag);
        JCheckBoxPersistence.initCheckBox(pedanticPedanticCheckBox, pedanticPedanticResourceTag);
        JCheckBoxPersistence.initCheckBox(pedanticWarningsAsErrorsCheckBox, pedanticWarningsAsErrorsResourceTag);
        JCheckBoxPersistence.initCheckBox(inhibitAllWarningsWCheckBox, inhibitAllWarningsWResourceTag);
        allWarningsWallCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(allWarningsWallCheckBox, allWarningsWallResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(extraWarningsWextraCheckBox, extraWarningsWextraResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(warnUndefinedIdentifierInCheckBox, warnUndefinedIdentifierInResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(warningsAsErrorsWerrorCheckBox, warningsAsErrorsWerrorResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(checkSyntaxOnlyFsyntaxCheckBox, checkSyntaxOnlyFsyntaxResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(pedanticPedanticCheckBox, pedanticPedanticResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(pedanticWarningsAsErrorsCheckBox, pedanticWarningsAsErrorsResourceTag);
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
                JCheckBoxPersistence.processCheckBoxAction(inhibitAllWarningsWCheckBox, inhibitAllWarningsWResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
