package view.linker;

import view.JPanelHolder;

import javax.swing.*;

public class General implements JPanelHolder {
    private JPanel topPanel;
    private JCheckBox doNotUseStandardCheckBox;
    private JCheckBox doNotUseDefaultCheckBox;
    private JCheckBox noStartupOrDefaultCheckBox;
    private JCheckBox omitSymbolInformationWlCheckBox;
    private JCheckBox linkStaticallyWlStaticCheckBox;
    private JCheckBox generateMAPFileWlCheckBox;
    private JCheckBox useVprintfLibraryWlCheckBox;
    private JPanel vertAlignPanel;

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
