package view.toolchain;

import model.persistence.ApplicationSettings;

import javax.swing.*;
import java.awt.event.*;

public class AddFlavour extends JDialog {
    private JPanel contentPane;
    private JButton buttonAdd;
    private JButton buttonCancel;
    private JTextField flavourNameTextField;
    private JTextField pathTextField;
    private JButton viewResourcesApplicationSettingsLabelsButton;
    private ApplicationSettings.Toolchain.FlavourList flavourList;

    public AddFlavour(ApplicationSettings.Toolchain.FlavourList flavourList) {
        this.flavourList = flavourList;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonAdd);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        viewResourcesApplicationSettingsLabelsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                addToFlavourList();
            }
        });
    }

    private void addToFlavourList() {
        String flavourName = flavourNameTextField.getText();
        if (flavourName.isEmpty()) {
            System.out.println("Flavour Name is emtpy!");
            return;
        }
        String flavourPath = pathTextField.getText();
        this.flavourList.add(new ApplicationSettings.Toolchain.Flavour(flavourName,flavourPath));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ApplicationSettings.Toolchain.FlavourList flavourList = new ApplicationSettings.Toolchain.FlavourList();
        AddFlavour dialog = new AddFlavour(flavourList);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
