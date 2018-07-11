package view.linker;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JCheckBox doNotUseStandardCheckBox;
    private JCheckBox doNotUseDefaultCheckBox;
    private JCheckBox noStartupOrDefaultCheckBox;
    private JCheckBox omitSymbolInformationWlCheckBox;
    private JCheckBox linkStaticallyWlStaticCheckBox;
    private JCheckBox generateMAPFileWlCheckBox;
    private JCheckBox useVprintfLibraryWlCheckBox;

    private final String doNotUseStandardhexResourceTag = "avrgnu.linker.general.chbox.nostartfiles";
    private final String doNotUseDefaulthexResourceTag = "avrgnu.linker.general.chbox.nodefaultlibs";
    private final String noStartupOrDefaulthexResourceTag = "avrgnu.linker.general.chbox.nostdlib";
    private final String omitSymbolInformationWlhexResourceTag = "avrgnu.linker.general.chbox.omitsymb";
    private final String linkStaticallyWlStatichexResourceTag = "avrgnu.linker.general.chbox.linkstatic";
    private final String generateMAPFileWlhexResourceTag = "avrgnu.linker.general.chbox.genmapfile";
    private final String useVprintfLibraryWlhexResourceTag = "avrgnu.linker.general.chbox.vprintf";

    public General() {
        JCheckBoxPersistence.initLinkerCheckBox(doNotUseStandardCheckBox, doNotUseStandardhexResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(doNotUseDefaultCheckBox, doNotUseDefaulthexResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(noStartupOrDefaultCheckBox, noStartupOrDefaulthexResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(omitSymbolInformationWlCheckBox, omitSymbolInformationWlhexResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(linkStaticallyWlStaticCheckBox, linkStaticallyWlStatichexResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(generateMAPFileWlCheckBox, generateMAPFileWlhexResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(useVprintfLibraryWlCheckBox, useVprintfLibraryWlhexResourceTag);
        doNotUseStandardCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(doNotUseStandardCheckBox, doNotUseStandardhexResourceTag);
            }
        });
        doNotUseDefaultCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(doNotUseDefaultCheckBox, doNotUseDefaulthexResourceTag);
            }
        });
        noStartupOrDefaultCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(noStartupOrDefaultCheckBox, noStartupOrDefaulthexResourceTag);
            }
        });
        omitSymbolInformationWlCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(omitSymbolInformationWlCheckBox, omitSymbolInformationWlhexResourceTag);
            }
        });
        linkStaticallyWlStaticCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(linkStaticallyWlStaticCheckBox, linkStaticallyWlStatichexResourceTag);
            }
        });
        generateMAPFileWlCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(generateMAPFileWlCheckBox, generateMAPFileWlhexResourceTag);
            }
        });
        useVprintfLibraryWlCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(useVprintfLibraryWlCheckBox, useVprintfLibraryWlhexResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
