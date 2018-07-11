package view;

import com.intellij.openapi.Disposable;
import com.intellij.ui.treeStructure.Tree;
import model.aggregation.CMakeFinalGenerator;
import view.compiler.SelectorC;
import view.compiler.SelectorCpp;
import view.resources.PluginBundle;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

public class ToolchainPanel extends JPanel implements Disposable {
    private JPanel topPanel;
    private Tree treeView;
    private JPanel cardsPanel;
    private JButton buttonCancel;
    private JButton buttonGenerate;
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

        buttonCancel.addActionListener(new ActionListener() {
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
        buttonGenerate.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CMakeFinalGenerator generator = new CMakeFinalGenerator();
                    generator.generate();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
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

        SelectorC cSelector = new SelectorC();
        SelectorCpp cppSelector = new SelectorCpp();

        cCompiler = new view.compiler.Compiler(cSelector);
        cCompilerGeneral = new view.compiler.General(cSelector);
        cCompilerPreprocessor = new view.compiler.Preprocessor(cSelector);
        cCompilerSymbols = new view.compiler.Symbols(cSelector);
        cCompilerDirectories = new view.compiler.Directories(cSelector);
        cCompilerOptimization = new view.compiler.Optimization(cSelector);
        cCompilerDebugging = new view.compiler.Debugging(cSelector);
        cCompilerWarnings = new view.compiler.Warnings(cSelector);
        cCompilerMiscellaneous = new view.compiler.Miscellaneous(cSelector);

        cppCompiler = new view.compiler.Compiler(cppSelector);
        cppCompilerGeneral = new view.compiler.General(cppSelector);
        cppCompilerPreprocessor = new view.compiler.Preprocessor(cppSelector);
        cppCompilerSymbols = new view.compiler.Symbols(cppSelector);
        cppCompilerDirectories = new view.compiler.Directories(cppSelector);
        cppCompilerOptimization = new view.compiler.Optimization(cppSelector);
        cppCompilerDebugging = new view.compiler.Debugging(cppSelector);
        cppCompilerWarnings = new view.compiler.Warnings(cppSelector);
        cppCompilerMiscellaneous = new view.compiler.Miscellaneous(cppSelector);

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

