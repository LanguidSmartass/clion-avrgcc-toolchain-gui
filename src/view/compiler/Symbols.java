package view.compiler;

import view.PluginBundle;
import view.formElements.RecordsList;

import javax.swing.*;
import java.util.ResourceBundle;

public class Symbols {
    private JPanel topPanel;
    private RecordsList definedSymbolsRecords;
    private RecordsList undefSymbolsRecords;

    Symbols() {
        ResourceBundle bundle = PluginBundle.getNodeNamesBundle();
        String defsymblabel = bundle.getString("settings.toolchain.avrgnu.cCompiler.symbols.label.defined");
        String undefsymblabel = bundle.getString("settings.toolchain.avrgnu.cCompiler.symbols.label.undefined");
        definedSymbolsRecords.setLabelText(defsymblabel);
        undefSymbolsRecords.setLabelText(undefsymblabel);
    }
}
