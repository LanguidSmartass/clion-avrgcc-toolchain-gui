package view.common;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputFiles implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JCheckBox hexCheckBox;
    private JCheckBox lssCheckBox;
    private JCheckBox eepCheckBox;
    private JCheckBox srecCheckBox;
    private JCheckBox usignCheckBox;

    private final String hexResourceTag = "avrgnu.common.general.chbox.hex";
    private final String lssResourceTag = "avrgnu.common.general.chbox.lss";
    private final String eepResourceTag = "avrgnu.common.general.chbox.eep";
    private final String srecResourceTag = "avrgnu.common.general.chbox.srec";
    private final String usignResourceTag = "avrgnu.common.general.chbox.usersignatures";

    public OutputFiles() {
        JCheckBoxPersistence.initCheckBox(hexCheckBox, hexResourceTag);
        JCheckBoxPersistence.initCheckBox(lssCheckBox, lssResourceTag);
        JCheckBoxPersistence.initCheckBox(eepCheckBox, eepResourceTag);
        JCheckBoxPersistence.initCheckBox(srecCheckBox, srecResourceTag);
        JCheckBoxPersistence.initCheckBox(usignCheckBox, usignResourceTag);
        hexCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(hexCheckBox, hexResourceTag);
            }
        });
        lssCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(lssCheckBox, lssResourceTag);
            }
        });
        eepCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(eepCheckBox, eepResourceTag);
            }
        });
        srecCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(srecCheckBox, srecResourceTag);
            }
        });
        usignCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(usignCheckBox, usignResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
