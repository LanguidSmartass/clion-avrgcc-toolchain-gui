package view;

import model.NamedTreeNode;
import com.intellij.openapi.Disposable;
import com.intellij.ui.treeStructure.Tree;
import view.archiver.Archiver;
import view.archiver.General;
import view.assembler.Assembler;
import view.compiler.*;
import view.compiler.Compiler;
import view.linker.Libraries;
import view.linker.Linker;
import view.linker.MemorySettings;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.util.ResourceBundle;

public class ToolchainPanel extends JPanel implements Disposable {
    private JPanel topPanel;
    private Tree treeView;
    private JPanel cardsPanel;
    private view.TreeModel model;

    private view.common.Common common;
    private view.common.General commonGeneral;
    private view.common.OutputFiles commonOutputFiles;
    private view.compiler.Compiler cCompiler;
    private view.compiler.General cCompilerGeneral;
    private view.compiler.Preprocessor cCompilerPreprocessor;
    private view.compiler.Symbols cCompilerSymbols;
    private view.compiler.Directories cCompilerDirectories;
    private view.compiler.Optimization cCompilerOptimization;
    private view.compiler.Debugging cCompilerDebugging;
    private view.compiler.Warnings cCompilerWarnings;
    private view.compiler.Miscellaneous cCompilerMiscellaneous;
    private view.compiler.Compiler cppCompiler;
    private view.compiler.General cppCompilerGeneral;
    private view.compiler.Preprocessor cppCompilerPreprocessor;
    private view.compiler.Symbols cppCompilerSymbols;
    private view.compiler.Directories cppCompilerDirectories;
    private view.compiler.Optimization cppCompilerOptimization;
    private view.compiler.Debugging cppCompilerDebugging;
    private view.compiler.Warnings cppCompilerWarnings;
    private view.compiler.Miscellaneous cppCompilerMiscellaneous;
    private view.linker.Linker linker;
    private view.linker.General linkerGeneral;
    private view.linker.Libraries linkerLibraries;
    private view.linker.Optimization linkerOptimization;
    private view.linker.MemorySettings linkerMemorySettings;
    private view.linker.Miscellaneous linkerMiscellaneous;
    private view.assembler.Assembler assembler;
    private view.assembler.General assemblerGeneral;
    private view.assembler.Debugging assemblerDebugging;
    private view.archiver.Archiver archiver;
    private view.archiver.General archiverGeneral;

    public ToolchainPanel(view.TreeModel model) {
        this.model = model;
        treeView.setModel(model);

        cardsPanel = new JPanel(new CardLayout());

        common = new view.common.Common();
        commonGeneral = new view.common.General();
        commonOutputFiles = new view.common.OutputFiles();
        cCompiler = new view.compiler.Compiler();
        cCompilerGeneral = new view.compiler.General();
        cCompilerPreprocessor = new view.compiler.Preprocessor();
        cCompilerSymbols = new view.compiler.Symbols();
        cCompilerDirectories = new view.compiler.Directories();
        cCompilerOptimization = new view.compiler.Optimization();
        cCompilerDebugging = new view.compiler.Debugging();
        cCompilerWarnings = new view.compiler.Warnings();
        cCompilerMiscellaneous = new view.compiler.Miscellaneous();
        cppCompiler = new view.compiler.Compiler();
        cppCompilerGeneral = new view.compiler.General();
        cppCompilerPreprocessor = new view.compiler.Preprocessor();
        cppCompilerSymbols = new view.compiler.Symbols();
        cppCompilerDirectories = new view.compiler.Directories();
        cppCompilerOptimization = new view.compiler.Optimization();
        cppCompilerDebugging = new view.compiler.Debugging();
        cppCompilerWarnings = new view.compiler.Warnings();
        cppCompilerMiscellaneous = new view.compiler.Miscellaneous();
        linker = new view.linker.Linker();
        linkerGeneral = new view.linker.General();
        linkerLibraries = new view.linker.Libraries();
        linkerOptimization = new view.linker.Optimization();
        linkerMemorySettings = new view.linker.MemorySettings();
        linkerMiscellaneous = new view.linker.Miscellaneous();
        assembler = new view.assembler.Assembler();
        assemblerGeneral = new view.assembler.General();
        assemblerDebugging = new view.assembler.Debugging();
        archiver = new view.archiver.Archiver();
        archiverGeneral = new view.archiver.General();

        ResourceBundle cardNameBundle = PluginBundle.getNodeNamesBundle();

        cardsPanel.add(common.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.common"));
        cardsPanel.add(commonGeneral.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.common.general"));
        cardsPanel.add(commonOutputFiles.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.common.outputfiles"));

        cardsPanel.add(cCompiler.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler"));
        cardsPanel.add(cCompilerGeneral.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.general"));
        cardsPanel.add(cCompilerPreprocessor.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.preproc"));
        cardsPanel.add(cCompilerSymbols.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.symbols"));
        cardsPanel.add(cCompilerDirectories.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.directs"));
        cardsPanel.add(cCompilerOptimization.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.optimzn"));
        cardsPanel.add(cCompilerDebugging.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.debug"));
        cardsPanel.add(cCompilerWarnings.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.warning"));
        cardsPanel.add(cCompilerMiscellaneous.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cCompiler.misc"));

        cardsPanel.add(cppCompiler.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler"));
        cardsPanel.add(cppCompilerGeneral.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.general"));
        cardsPanel.add(cppCompilerPreprocessor.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.preproc"));
        cardsPanel.add(cppCompilerSymbols.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.symbols"));
        cardsPanel.add(cppCompilerDirectories.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.directs"));
        cardsPanel.add(cppCompilerOptimization.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.optimzn"));
        cardsPanel.add(cppCompilerDebugging.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.debug"));
        cardsPanel.add(cppCompilerWarnings.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.warning"));
        cardsPanel.add(cppCompilerMiscellaneous.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.cppCompiler.misc"));

        cardsPanel.add(linker.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.linker"));
        cardsPanel.add(linkerGeneral.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.linker.general"));
        cardsPanel.add(linkerLibraries.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.linker.libraries"));
        cardsPanel.add(linkerOptimization.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.linker.optimization"));
        cardsPanel.add(linkerMemorySettings.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.linker.memsettings"));
        cardsPanel.add(linkerMiscellaneous.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.linker.misc"));

        cardsPanel.add(assembler.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.assembler"));
        cardsPanel.add(assemblerGeneral.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.assembler.general"));
        cardsPanel.add(assemblerDebugging.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.assembler.debugging"));

        cardsPanel.add(archiver.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.archiver"));
        cardsPanel.add(archiverGeneral.getPanel(), cardNameBundle.getString("cardname.toolchain.avrgnu.archiver.general"));
    }

    public void addTreeListener(TreeSelectionListener tl) {
        treeView.addTreeSelectionListener(tl);
    }

    public void updatePanelView(JPanel panel) {
    }

    @Override
    public void dispose() {
    }

    public JPanel getPanel() {
        return topPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

