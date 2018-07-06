package view.formElements;

import javax.swing.*;

public class RecordsList {
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonEdit;
    private JButton buttonModeUp;
    private JButton buttonModeDown;
    private JTextArea textArea1;
    private JPanel topPanel;
    private JPanel buttonsLabelPanel;
    private JLabel descriptionLabel;

    public void setLabelText(String text) {
        descriptionLabel.setText(text);
    }
}
