package view.toolchain;

import model.persistence.ApplicationSettings;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class AddFlavour extends JDialog {
    private JPanel contentPane;
    private JButton buttonAdd;
    private JButton buttonCancel;
    private JTextField flavourNameTextField;
    private JTextField pathTextField;
    private JButton basePathSelectButton;

    private ApplicationSettings applicationSettings;
    private String toolchainName;

    public AddFlavour(ApplicationSettings applicationSettings, String toolchainName) {
        this.applicationSettings = applicationSettings;
        this.toolchainName = toolchainName;

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

        basePathSelectButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fc.showOpenDialog(contentPane);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    pathTextField.setText(fc.getSelectedFile().getAbsolutePath());
                }
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
        if (flavourPath.isEmpty()) {
            System.out.println("Flavour Path is emtpy!");
            return;
        }
        this.applicationSettings.addToolchainFlavour(toolchainName, flavourName, flavourPath);
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
//        ApplicationSettings.Toolchain toolchain = new ApplicationSettings.Toolchain("Test name");
//        AddFlavour dialog = new AddFlavour(toolchain);
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
    }
}
