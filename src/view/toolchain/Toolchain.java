package view.toolchain;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBList;
import model.persistence.ApplicationSettings;
import view.JPanelHolder;
import view.resources.PluginBundle;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Toolchain implements JPanelHolder {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel toolchainsPanel;

    private JComboBox<String> toolchainsComboBox;

    private JList<String> flavourList;
    private DefaultListModel<String> flavourListModel;
    private ListSelectionListener flavourListListener;

    private JButton addFlavourButton;
    private JButton setAsDefaultButton;
    private JButton deleteFlavourButton;
    private JLabel defaultFlavour;
    private JTextField flavourPathTextField;
    private JButton pathButton;

    private ApplicationSettings applicationSettings;

    public Toolchain() {
        initMutableElements();

        toolchainsComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String toolchainName = (String)toolchainsComboBox.getSelectedItem();
                if (toolchainName == null) return;
                ArrayList<String> flavourNames = applicationSettings.getToolchainFlavours(toolchainName);
                updateFlavourList(flavourNames);
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
                String toolchainName = (String)toolchainsComboBox.getSelectedItem();
                if (toolchainName == null) return;
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
                    String toolchainName = (String)toolchainsComboBox.getSelectedItem();
                    if (toolchainName == null) return;
                    String flavourName = flavourList.getSelectedValue();
                    if (flavourName == null) return;
                    String flavourPath = fc.getSelectedFile().getAbsolutePath();
                    flavourPathTextField.setText(flavourPath);
                    applicationSettings.setToolchainFlavourPath(toolchainName, flavourName, flavourPath);
                }
            }
        });

        flavourListListener = new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String toolchainName = (String)toolchainsComboBox.getSelectedItem();
                if (toolchainName == null) return;
                String flavourName = flavourList.getSelectedValue();
                if (flavourName == null) return;
                String flavourPath = applicationSettings.getToolchainFlavourPath(toolchainName, flavourName);
                if (flavourPath == null) return;
                updateFlavourPathTextField(flavourPath);
            }
        };

        flavourList.addListSelectionListener(flavourListListener);
    }

    private void updateToolchainComboBox(ArrayList<String> toolchainNames) {
        toolchainsComboBox.removeAllItems();
        for (String toolchain : toolchainNames)
            toolchainsComboBox.addItem(toolchain);
    }

    private void updateFlavourList(ArrayList<String> flavourNames) {
        flavourListModel.clear();
        int i = 0;
        for (String flavourName : flavourNames) {
            if (flavourListModel.contains(flavourName)) continue;
            flavourListModel.add(i++, flavourName);
        }
    }

    private void updateDefaultFlavourLabel(String flavourName) {
        defaultFlavour.setText(flavourName);
    }

    private void updateFlavourPathTextField(String flavourPath) {
        this.flavourPathTextField.setText(flavourPath);
    }

    private void initToolchainComboBox() {
        updateToolchainComboBox(applicationSettings.getToolchains());
        if (toolchainsComboBox.getItemCount() == 0) return;
        toolchainsComboBox.setSelectedIndex(0);
    }

    private void initFlavourList() {
        if (toolchainsComboBox.getItemCount() == 0) return;
        String toolchainName = toolchainsComboBox.getItemAt(0);
        ArrayList<String> flavourNames = applicationSettings.getToolchainFlavours(toolchainName);
        updateFlavourList(flavourNames);
        resetFlavourListIndex();
    }

    private void initDefaultFlavourLabel() {
        if (toolchainsComboBox.getItemCount() == 0) return;
        String toolchainName = toolchainsComboBox.getItemAt(0);
        String flavourName = applicationSettings.getToolchainDefaultFlavour(toolchainName);
        updateDefaultFlavourLabel(flavourName);
    }

    private void initFlavourPathTextField() {
        if (toolchainsComboBox.getItemCount() == 0) return;
        String toolchainName = toolchainsComboBox.getItemAt(0);
        int idx = flavourList.getSelectedIndex();
        if (idx < 0) return;
        String flavourName = flavourList.getSelectedValue();
        String flavourPath = applicationSettings.getToolchainFlavourPath(toolchainName, flavourName);
        updateFlavourPathTextField(flavourPath);
    }

    private void initMutableElements() {
        // Must follow strictly in that order
        initToolchainComboBox();
        initFlavourList();
        initDefaultFlavourLabel();
        initFlavourPathTextField();
    }

    private void resetFlavourListIndex() {
        flavourList.removeListSelectionListener(flavourListListener);
        if (flavourList.getModel().getSize() > 0) flavourList.setSelectedIndex(0);
        flavourList.addListSelectionListener(flavourListListener);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }

    private void createUIComponents() {
        toolchainsComboBox = new ComboBox<>();
        flavourListModel = new DefaultListModel<>();
        flavourList = new JBList<>(flavourListModel);
        defaultFlavour = new JLabel();
        flavourPathTextField = new JTextField();

        checkToolchainsExistence();
    }

    private void checkToolchainsExistence() {
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
    }
}
