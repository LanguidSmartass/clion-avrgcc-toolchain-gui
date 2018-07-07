package view.toolchain;

import view.JPanelHolder;

import javax.swing.*;

public class Toolchain implements JPanelHolder {
    private JPanel topPanel;
    private JComboBox toolchainsComboBox;
    private JList flavourList;
    private JButton addFlavourButton;
    private JButton setAsDefaultButton;
    private JButton deleteFlavourButton;
    private JTextField pathTextField;
    private JButton pathButton;
    private JPanel vertAlignPanel;
    private JPanel toolchainsPanel;
    private JLabel defaultFlavour;

    private void setDefaultFlavour(String flavour) {
        defaultFlavour.setText(flavour);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
