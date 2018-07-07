package view.compiler;

import view.JPanelHolder;
import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class Symbols implements JPanelHolder {
    private JPanel topPanel;
    private RecordsList definedSymbolsRecords;
    private RecordsList undefSymbolsRecords;

    public Symbols() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String defsymblabel = bundle.getString("settings.toolchain.avrgnu.compiler.c.symbols.label.defined");
        String undefsymblabel = bundle.getString("settings.toolchain.avrgnu.compiler.c.symbols.label.undefined");
        definedSymbolsRecords.setLabelText(defsymblabel);
        undefSymbolsRecords.setLabelText(undefsymblabel);
    }

    @Override
    public JPanel getPanel() {
        return topPanel;
    }
}
