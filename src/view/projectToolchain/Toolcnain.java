package view.projectToolchain;

import model.persistence.ApplicationSettings;
import model.persistence.ProjectSettings;
import view.JPanelHolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Toolcnain implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;

    private JComboBox<String> toolchainComboBox;
    private JComboBox<String> flavourComboBox;

    private ApplicationSettings applicationSettings;
    private ProjectSettings projectSettings;

    public Toolcnain() {
        applicationSettings = ApplicationSettings.getInstance();
        projectSettings = ProjectSettings.getInstance();

        initMutableElements();
        toolchainComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = toolchainComboBox.getSelectedIndex();
                if (idx < 0) return;
                String toolchainName = toolchainComboBox.getItemAt(idx);
                ArrayList<String> flavours = applicationSettings.getToolchainFlavours(toolchainName);
                updateComboBox(flavourComboBox, flavours);
                projectSettings.setSelectedToolchain(toolchainName);
            }
        });
        flavourComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = flavourComboBox.getSelectedIndex();
                if (idx < 0) return;
                String flavourName = flavourComboBox.getItemAt(idx);
                projectSettings.setSelectedFlavour(flavourName);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    private void updateComboBox(JComboBox<String> comboBox, ArrayList<String> items) {
        comboBox.removeAllItems();
        for (String item : items)
            comboBox.addItem(item);
    }

    private void initToolchainComboBox() {
        updateComboBox(toolchainComboBox, applicationSettings.getToolchains());
        if (toolchainComboBox.getItemCount() == 0) return;
        String toolchainName = projectSettings.getSelectedToolchain();
        if (toolchainName == null) return;
        int idx = 0;
        int i = 0;
        ArrayList<String> toolchains = applicationSettings.getToolchains();
        for (; i < toolchains.size(); ++i) {
            if (toolchains.get(i).equals(toolchainName)) {
                idx = i;
                break;
            }
        }
        if (i >= toolchains.size()) {
            projectSettings.setSelectedToolchain(toolchainComboBox.getItemAt(0));
        }
        toolchainComboBox.setSelectedIndex(idx);
    }

    private void initFlavourComboBox() {
        int idx = toolchainComboBox.getSelectedIndex();
        if (idx < 0) return;
        String toolchainName = toolchainComboBox.getItemAt(idx);

        ArrayList<String> flavours = applicationSettings.getToolchainFlavours(toolchainName);
        updateComboBox(flavourComboBox, flavours);
        if (flavourComboBox.getItemCount() == 0) return;
        String flavourName = projectSettings.getSelectedFlavour();
        if (flavourName == null) return;
        int i = 0;
        idx = 0;
        for (; i < flavours.size(); ++i) {
            if (flavours.get(i).equals(toolchainName)) {
                idx = i;
                break;
            }
        }
        if (i >= flavours.size()) {
            projectSettings.setSelectedFlavour(flavourComboBox.getItemAt(0));
        }
        flavourComboBox.setSelectedIndex(idx);
    }

    private void initMutableElements() {
        // Strictly in that order
        initToolchainComboBox();
        initFlavourComboBox();
    }

}
