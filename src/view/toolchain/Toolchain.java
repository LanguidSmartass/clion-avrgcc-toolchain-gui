package view.toolchain;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBList;
import model.persistence.ApplicationSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Toolchain implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel toolchainsPanel;

    private JComboBox<String> toolchainsComboBox;
    private JList<String> flavourList;
    private DefaultListModel<String> flavourListModel;
    private JButton addFlavourButton;
    private JButton setAsDefaultButton;
    private JButton deleteFlavourButton;
    private JLabel defaultFlavour;
    private JTextField pathTextField;
    private JButton pathButton;

    private ApplicationSettings applicationSettings;

    public Toolchain() {
        toolchainsComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFlavourList();
            }
        });

        addFlavourButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int comboIdx = toolchainsComboBox.getSelectedIndex();
                String toolchainName = (String)toolchainsComboBox.getSelectedItem();
                JDialog d = new AddFlavour(applicationSettings, toolchainName);
                d.pack();
                d.setLocationRelativeTo(null);
                d.setVisible(true);
            }
        });

        pathButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fc.showOpenDialog(topPanel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String toolchainName = getCurrentToolchainName();
                    String flavourName = getFlavourNameFromList();
                    String flavourPath = fc.getSelectedFile().getAbsolutePath();
                    pathTextField.setText(flavourPath);
                    applicationSettings.setToolchainFlavourPath(toolchainName, flavourName, flavourPath);
                }
            }
        });
        
        flavourList.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component gains the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                updateFlavourPathFromList();
            }
        });
    }

    private String getCurrentToolchainName() {
        return (String)toolchainsComboBox.getSelectedItem();
    }

    private String getFlavourNameFromList() {
        return flavourListModel.getElementAt(flavourList.getSelectedIndex());
    }

    private String getFlavourPathFromList() {
        String toolchainName = getCurrentToolchainName();
        String flavourName = getFlavourNameFromList();
        return applicationSettings.getToolchainFlavourPath(toolchainName, flavourName);
    }

    private void setDefaultFlavour(String flavour) {
        defaultFlavour.setText(flavour);
    }

    private void updateFlavourList() {
        flavourListModel.clear();
        String toolchainName = (String)toolchainsComboBox.getSelectedItem();
        ArrayList<String> flavourNames = applicationSettings.getToolchainFlavours(toolchainName);
        int i = 0;
        for (String flavourName : flavourNames) {
            if (flavourListModel.contains(flavourName)) continue;
            flavourListModel.add(i++, flavourName);
        }
        String defaultFlavourText = applicationSettings.getToolchainDefaultFlavour(toolchainName);
        defaultFlavour.setText(defaultFlavourText);
        flavourList.setSelectedIndex(0);
    }

    private void updateFlavourPathFromList() {
        pathTextField.setText(getFlavourPathFromList());
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    private void createUIComponents() {
        ArrayList<String> keys = new ArrayList<>();
        keys.add("toolchain.configuration.combobox.asm");
        keys.add("toolchain.configuration.combobox.avr8.c");
        keys.add("toolchain.configuration.combobox.avr8.cpp");
        keys.add("toolchain.configuration.combobox.avr32.c");
        keys.add("toolchain.configuration.combobox.avr32.cpp");
        keys.add("toolchain.configuration.combobox.arm32.c");
        keys.add("toolchain.configuration.combobox.arm32.cpp");

        ResourceBundle appSettingsLabels = PluginBundle.getApplicationSettingsLabelsBundle();
        applicationSettings = ApplicationSettings.getInstance();
        for (String key : keys) {
            String toolchainLabel = appSettingsLabels.getString(key);
            if (applicationSettings.hasToolchain(toolchainLabel)) continue;
            applicationSettings.addToolchain(toolchainLabel);
        }
        toolchainsComboBox = new ComboBox<>();
        for (String toolchain : applicationSettings.getToolchains()) {
            toolchainsComboBox.addItem(toolchain);
        }

        flavourListModel = new DefaultListModel<>();
        flavourList = new JBList<>(flavourListModel);
        defaultFlavour = new JLabel();

        updateFlavourList();
    }
}
