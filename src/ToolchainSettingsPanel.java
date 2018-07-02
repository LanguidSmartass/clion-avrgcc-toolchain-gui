import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.wm.IdeFrame;

import com.intellij.ui.treeStructure.Tree;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JPanel;

public class ToolchainSettingsPanel extends JPanel implements Disposable {
    private final Tree uiTree;
    public ToolchainSettingsPanel(@NotNull Disposable var1, int var2) {
        uiTree = new Tree(new frontend.tree.TreeModel());
        this.add(uiTree);
    }

    public final void autoRecheckWithApplication() {
    }

    @Override
    public void dispose() {

    }
}
