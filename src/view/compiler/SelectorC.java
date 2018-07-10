package view.compiler;

import model.persistence.ProjectSettings;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectorC implements CompilerSelector {
    private ProjectSettings prjStngs;

    public SelectorC() {
        prjStngs = ProjectSettings.getInstance();
    }

    @Override
    public void setCompilerOptimLevel(String compOptimLevel) {
        prjStngs.setCompCOptimLevel(compOptimLevel);
    }

    @Override
    public void setCompilerOtherOptimFlags(String compOtherOptimFlags) {
        prjStngs.setCompCOtherOptimFlags(compOtherOptimFlags);
    }

    @Override
    public void setCompilerDebugLevel(String compDebugLevel) {
        prjStngs.setCompCDebugLevel(compDebugLevel);
    }

    @Override
    public void setCompilerOtherDebugFlags(String compOtherDebugFlags) {
        prjStngs.setCompCOtherDebugFlags(compOtherDebugFlags);
    }

    @Override
    public void setCompilerOtherMiscFlags(String compOtherMiscFlags) {
        prjStngs.setCompCOtherMiscFlags(compOtherMiscFlags);
    }

    @Override
    public HashMap<String, Boolean> getCompilerFlags() {
        return prjStngs.getCompCFlags();
    }

    @Override
    public ArrayList<String> getCompilerSymbolsDefined() {
        return prjStngs.getCompCSymbolsDefined();
    }

    @Override
    public ArrayList<String> getCompilerSymbolsUndefined() {
        return prjStngs.getCompCSymbolsUndefined();
    }

    @Override
    public ArrayList<String> getCompilerIncludePaths() {
        return prjStngs.getCompCIncludePaths();
    }

    @Override
    public String getCompilerOptimLevel() {
        return prjStngs.getCompCOptimLevel();
    }

    @Override
    public String getCompilerOtherOptimFlags() {
        return prjStngs.getCompCOtherOptimFlags();
    }

    @Override
    public String getCompilerDebugLevel() {
        return prjStngs.getCompCDebugLevel();
    }

    @Override
    public String getCompilerOtherDebugFlags() {
        return prjStngs.getCompCOtherDebugFlags();
    }

    @Override
    public String getCompilerOtherMiscFlags() {
        return prjStngs.getCompCOtherMiscFlags();
    }
}
