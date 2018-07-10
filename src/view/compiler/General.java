package view.compiler;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JCheckBox mcallprologuesCheckBox;
    private JCheckBox mnointerruptsCheckBox;
    private JCheckBox funsignedcharCheckBox;
    private JCheckBox funsignedbitfieldsCheckBox;

    private final String mcallprologuesResourceTag = "avrgnu.compiler.general.chbox.mcallprologues";
    private final String mnointerruptsResourceTag = "avrgnu.compiler.general.chbox.mnointerrupts";
    private final String funsignedcharResourceTag = "avrgnu.compiler.general.chbox.funsignedchar";
    private final String funsignedbitfieldsResourceTag = "avrgnu.compiler.general.chbox.funsignedbitfields";

    public General() {
        JCheckBoxPersistence.initCheckBox(mcallprologuesCheckBox, mcallprologuesResourceTag);
        JCheckBoxPersistence.initCheckBox(mnointerruptsCheckBox, mnointerruptsResourceTag);
        JCheckBoxPersistence.initCheckBox(funsignedcharCheckBox, funsignedcharResourceTag);
        JCheckBoxPersistence.initCheckBox(funsignedbitfieldsCheckBox, funsignedbitfieldsResourceTag);
        mcallprologuesCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(mcallprologuesCheckBox, mcallprologuesResourceTag);
            }
        });
        mnointerruptsCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(mnointerruptsCheckBox, mnointerruptsResourceTag);
            }
        });
        funsignedcharCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(funsignedcharCheckBox, funsignedcharResourceTag);
            }
        });
        funsignedbitfieldsCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processCheckBoxAction(funsignedbitfieldsCheckBox, funsignedbitfieldsResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
