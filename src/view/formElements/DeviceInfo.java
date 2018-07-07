package view.formElements;

import javax.swing.*;

public class DeviceInfo {
    private JPanel topPanel;
    private JPanel vertAlignPanel;
    private JPanel deviceProperties;
    private JPanel linksPanelHolder;
    private JButton datasheetHyperlink;
    private JButton devicePageHyperlink;
    private JPanel toolsPanel;
    private JPanel linksPanel;

    private JLabel devName;
    private JLabel bootMem;
    private JLabel dataMem;
    private JLabel eeprMem;
    private JLabel speed;
    private JLabel voltage;
    private JLabel familyLabel;

    public void setDevName(String devName) {
        this.devName.setText(devName);
    }

    public void setBootMem(String bootMem) {
        this.bootMem.setText(bootMem);
    }

    public void setDataMem(String dataMem) {
        this.dataMem.setText(dataMem);
    }

    public void setEeprMem(String eeprMem) {
        this.eeprMem.setText(eeprMem);
    }

    public void setSpeed(String speed) {
        this.speed.setText(speed);
    }

    public void setVoltage(String voltage) {
        this.voltage.setText(voltage);
    }

    public void setFamilyLabel(String familyLabel) {
        this.familyLabel.setText(familyLabel);
    }
}
