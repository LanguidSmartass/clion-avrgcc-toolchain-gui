package frontend.tree.common;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.util.ArrayList;

public class General {
    private final backend.tree.common.General impl;

    private JLabel labelTargetDevName;
    private JLabel labelDefaultIncludePaths;
    private JFormattedTextField fmtTextFieldTargetDevName;
    private JFormattedTextField fmtTextFieldDefaultIncludePaths;
    private JCheckBox checkBoxMRelax;
    private JCheckBox checkBoxExtOvfRamCheck;

    public General() {
        impl = new backend.tree.common.General();

        labelTargetDevName.setText(impl.getTargetDeviceNameLabel());
        labelDefaultIncludePaths.setText(impl.getDefaultIncludePathsLabel());

        fmtTextFieldTargetDevName.setText(impl.getTargetDeviceName());
        String defIncPaths = "";
        for (String s : impl.getDefaultIncludePaths()) {
            defIncPaths = defIncPaths.concat(s);
            defIncPaths = defIncPaths.concat("\n");
        }
        fmtTextFieldDefaultIncludePaths.setText(defIncPaths);

        checkBoxMRelax.setEnabled(impl.isMrelax());
        checkBoxExtOvfRamCheck.setEnabled(impl.isExtOvfRamCheck());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
