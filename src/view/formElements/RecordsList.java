package view.formElements;

import javax.swing.*;

public class RecordsList {
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonEdit;
    private JButton buttonModeUp;
    private JButton buttonModeDown;
    private JPanel topPanel;
    private JPanel buttonsLabelPanel;
    private JLabel descriptionLabel;
    private JList list;

    public void setLabelText(String text) {
        descriptionLabel.setText(text);
    }
}
