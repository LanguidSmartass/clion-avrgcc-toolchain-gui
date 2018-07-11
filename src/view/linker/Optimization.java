package view.linker;

import view.JPanelHolder;
import view.util.JCheckBoxPersistence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Optimization implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JCheckBox garbageCollectUnusedSectionsCheckBox;
    private JCheckBox putReadOnlyDataCheckBox;

    private final String garbageCollectUnusedSectionsResourceTag = "avrgnu.linker.optimization.chbox.gcsections";
    private final String putReadOnlyDataResourceTag = "avrgnu.linker.optimization.chbox.rodatawr";

    public Optimization() {
        JCheckBoxPersistence.initLinkerCheckBox(garbageCollectUnusedSectionsCheckBox, garbageCollectUnusedSectionsResourceTag);
        JCheckBoxPersistence.initLinkerCheckBox(putReadOnlyDataCheckBox, putReadOnlyDataResourceTag);

        garbageCollectUnusedSectionsCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(garbageCollectUnusedSectionsCheckBox, garbageCollectUnusedSectionsResourceTag);
            }
        });
        putReadOnlyDataCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxPersistence.processLinkerCheckBoxAction(putReadOnlyDataCheckBox, putReadOnlyDataResourceTag);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
