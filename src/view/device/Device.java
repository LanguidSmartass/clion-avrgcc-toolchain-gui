package view.device;

import view.JPanelHolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Device implements JPanelHolder {
    private JButton changeDeviceButton;
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel deviceButtonSelectPanel;
    private JLabel currDevLabelModifiable;

    public Device() {
        changeDeviceButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new ChangeDevice();
                d.pack();
                d.setVisible(true);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
