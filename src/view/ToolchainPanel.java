package view;

import com.intellij.openapi.Disposable;
import com.intellij.ui.treeStructure.Tree;
import view.resources.PluginBundle;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToolchainPanel extends JPanel implements Disposable {
    private JPanel topPanel;
    private Tree treeView;
    private JPanel cardsPanel;
    private JButton buttonGenCMakeLists;
    private JButton saveButton;
    private JButton OKButton;
    private view.TreeModel model;

    private view.toolchain.Toolchain toolchain;
    private view.device.Device device;
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

        buttonGenCMakeLists.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void addTreeListener(TreeSelectionListener tl) {
        treeView.addTreeSelectionListener(tl);
    }

    public void updatePanelView(String cardName) {
        CardLayout layout = (CardLayout)cardsPanel.getLayout();
        layout.show(cardsPanel, cardName);
    }

    @Override
    public void dispose() {
    }

    public JPanel getPanel() {
        return topPanel;
    }

    private void createUIComponents() {
        cardsPanel = new JPanel(new CardLayout());

        toolchain = new view.toolchain.Toolchain();
        device = new view.device.Device();
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

        ResourceBundle cardNameBundle = PluginBundle.getCardNamesEmbeddedBundle();

        cardsPanel.add(toolchain.getPanel(), cardNameBundle.getString("toolchain"));

        cardsPanel.add(device.getPanel(), cardNameBundle.getString("device"));

        cardsPanel.add(common.getPanel(), cardNameBundle.getString("avrgnu.common"));
        cardsPanel.add(commonGeneral.getPanel(), cardNameBundle.getString("avrgnu.common.general"));
        cardsPanel.add(commonOutputFiles.getPanel(), cardNameBundle.getString("avrgnu.common.outputfiles"));

        cardsPanel.add(cCompiler.getPanel(), cardNameBundle.getString("avrgnu.compiler.c"));
        cardsPanel.add(cCompilerGeneral.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.general"));
        cardsPanel.add(cCompilerPreprocessor.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.preproc"));
        cardsPanel.add(cCompilerSymbols.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.symbols"));
        cardsPanel.add(cCompilerDirectories.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.directs"));
        cardsPanel.add(cCompilerOptimization.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.optimzn"));
        cardsPanel.add(cCompilerDebugging.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.debug"));
        cardsPanel.add(cCompilerWarnings.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.warning"));
        cardsPanel.add(cCompilerMiscellaneous.getPanel(), cardNameBundle.getString("avrgnu.compiler.c.misc"));

        cardsPanel.add(cppCompiler.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp"));
        cardsPanel.add(cppCompilerGeneral.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.general"));
        cardsPanel.add(cppCompilerPreprocessor.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.preproc"));
        cardsPanel.add(cppCompilerSymbols.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.symbols"));
        cardsPanel.add(cppCompilerDirectories.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.directs"));
        cardsPanel.add(cppCompilerOptimization.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.optimzn"));
        cardsPanel.add(cppCompilerDebugging.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.debug"));
        cardsPanel.add(cppCompilerWarnings.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.warning"));
        cardsPanel.add(cppCompilerMiscellaneous.getPanel(), cardNameBundle.getString("avrgnu.compiler.cpp.misc"));

        cardsPanel.add(linker.getPanel(), cardNameBundle.getString("avrgnu.linker"));
        cardsPanel.add(linkerGeneral.getPanel(), cardNameBundle.getString("avrgnu.linker.general"));
        cardsPanel.add(linkerLibraries.getPanel(), cardNameBundle.getString("avrgnu.linker.libraries"));
        cardsPanel.add(linkerOptimization.getPanel(), cardNameBundle.getString("avrgnu.linker.optimization"));
        cardsPanel.add(linkerMemorySettings.getPanel(), cardNameBundle.getString("avrgnu.linker.memsettings"));
        cardsPanel.add(linkerMiscellaneous.getPanel(), cardNameBundle.getString("avrgnu.linker.misc"));

        cardsPanel.add(assembler.getPanel(), cardNameBundle.getString("avrgnu.assembler"));
        cardsPanel.add(assemblerGeneral.getPanel(), cardNameBundle.getString("avrgnu.assembler.general"));
        cardsPanel.add(assemblerDebugging.getPanel(), cardNameBundle.getString("avrgnu.assembler.debugging"));

        cardsPanel.add(archiver.getPanel(), cardNameBundle.getString("avrgnu.archiver"));
        cardsPanel.add(archiverGeneral.getPanel(), cardNameBundle.getString("avrgnu.archiver.general"));
    }
}

