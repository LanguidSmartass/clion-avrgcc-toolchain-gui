import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.wm.IdeFrame;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JPanel;

public class ToolchainPanel extends JPanel implements Disposable {

    public ToolchainPanel(@NotNull Disposable var1, int var2) {
        this.add(new frontend.tree.ToolchainPanel());
    }

    public final void autoRecheckWithApplication() {
    }

    @Override
    public void dispose() {

    }
}
