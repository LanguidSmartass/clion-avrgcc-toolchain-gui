package view.compiler;

import java.util.ArrayList;
import java.util.HashMap;

public interface CompilerSelector {

    public void setCompilerOptimLevel(String compOptimLevel);

    public void setCompilerOtherOptimFlags(String compOtherOptimFlags);

    public void setCompilerDebugLevel(String compDebugLevel);

    public void setCompilerOtherDebugFlags(String compOtherDebugFlags);

    public void setCompilerOtherMiscFlags(String compOtherMiscFlags);

    public HashMap<String, Boolean> getCompilerFlags();

    public ArrayList<String> getCompilerSymbolsDefined();

    public ArrayList<String> getCompilerSymbolsUndefined();

    public ArrayList<String> getCompilerIncludePaths();

    public String getCompilerOptimLevel();

    public String getCompilerOtherOptimFlags();

    public String getCompilerDebugLevel();

    public String getCompilerOtherDebugFlags();

    public String getCompilerOtherMiscFlags();

    public String getImmutableExecutableName();
}
