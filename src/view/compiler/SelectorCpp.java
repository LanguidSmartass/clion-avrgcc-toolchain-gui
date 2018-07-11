package view.compiler;

import model.persistence.ProjectSettings;
import view.resources.PluginBundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SelectorCpp implements CompilerSelector {
    private ProjectSettings prjStngs;

    public SelectorCpp() {
        prjStngs = ProjectSettings.getInstance();
    }

    @Override
    public void setCompilerOptimLevel(String compOptimLevel) {
        prjStngs.setCompCppOptimLevel(compOptimLevel);
    }

    @Override
    public void setCompilerOtherOptimFlags(String compOtherOptimFlags) {
        prjStngs.setCompCppOtherOptimFlags(compOtherOptimFlags);
    }

    @Override
    public void setCompilerDebugLevel(String compDebugLevel) {
        prjStngs.setCompCppDebugLevel(compDebugLevel);
    }

    @Override
    public void setCompilerOtherDebugFlags(String compOtherDebugFlags) {
        prjStngs.setCompCppOtherDebugFlags(compOtherDebugFlags);
    }

    @Override
    public void setCompilerOtherMiscFlags(String compOtherMiscFlags) {
        prjStngs.setCompCppOtherMiscFlags(compOtherMiscFlags);
    }

    @Override
    public HashMap<String, Boolean> getCompilerFlags() {
        return prjStngs.getCompCppFlags();
    }

    @Override
    public ArrayList<String> getCompilerSymbolsDefined() {
        return prjStngs.getCompCppSymbolsDefined();
    }

    @Override
    public ArrayList<String> getCompilerSymbolsUndefined() {
        return prjStngs.getCompCppSymbolsUndefined();
    }

    @Override
    public ArrayList<String> getCompilerIncludePaths() {
        return prjStngs.getCompCppIncludePaths();
    }

    @Override
    public String getCompilerOptimLevel() {
        return prjStngs.getCompCppOptimLevel();
    }

    @Override
    public String getCompilerOtherOptimFlags() {
        return prjStngs.getCompCppOtherOptimFlags();
    }

    @Override
    public String getCompilerDebugLevel() {
        return prjStngs.getCompCppDebugLevel();
    }

    @Override
    public String getCompilerOtherDebugFlags() {
        return prjStngs.getCompCppOtherDebugFlags();
    }

    @Override
    public String getCompilerOtherMiscFlags() {
        return prjStngs.getCompCppOtherMiscFlags();
    }

    @Override
    public String getImmutableExecutableName() {
        ResourceBundle immutableBundle = PluginBundle.getImmutableTextContents();
        return immutableBundle.getString("avrgnu.executable.name.compiler.cpp");
    }
}
