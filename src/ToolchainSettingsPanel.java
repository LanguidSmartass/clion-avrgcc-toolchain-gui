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
        long var1 = 98777743076406L;
        Application var10000 = ApplicationManager.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(var10000, "ApplicationManager.getApplication()");
        var10000.getMessageBus().connect((Disposable)this).subscribe(ApplicationActivationListener.TOPIC, new ApplicationActivationListener() {
            public void applicationActivated(@NotNull IdeFrame var1) {
                long var2 = 85057711781990L;
                Intrinsics.checkParameterIsNotNull(var1, "ideFrame");
//                CPPToolchainsPanel.this.e();
            }

            public void applicationDeactivated(@NotNull IdeFrame var1) {
                long var2 = 69953076386119L;
                Intrinsics.checkParameterIsNotNull(var1, "ideFrame");
//                CPPToolchainsPanel.this.b();
            }
        });
    }

    @Override
    public void dispose() {

    }
}
