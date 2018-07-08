package view.toolchain;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBList;
import model.persistence.ApplicationSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Toolchain implements JPanelHolder {
    private JPanel topPanel;
    private JComboBox<String> toolchainsComboBox;
    private JList<String> flavourList;
    private DefaultListModel<String> flavourListModel;
    private JButton addFlavourButton;
    private JButton setAsDefaultButton;
    private JButton deleteFlavourButton;
    private JTextField pathTextField;
    private JButton pathButton;
    private JPanel vertAlignPanel;
    private JPanel toolchainsPanel;
    private JLabel defaultFlavour;

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
                flavourListModel.clear();
                String toolchainName = (String)toolchainsComboBox.getSelectedItem();
//                ApplicationSettings.Toolchain toolchain = applicationSettings.getToolchainList().get(comboIdx);
                ArrayList<String> flavourNames = applicationSettings.getToolchainFlavours(toolchainName);
                int i = 0;
                for (String flavourName : flavourNames) {
                    if (flavourListModel.contains(flavourName)) continue;
                    flavourListModel.add(i++, flavourName);
                }
                flavourList.updateUI();
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
    }

    private void setDefaultFlavour(String flavour) {
        defaultFlavour.setText(flavour);
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
    }
}
