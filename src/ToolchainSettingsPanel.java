import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.wm.IdeFrame;
import com.intellij.ui.CollectionComboBoxModel;
import com.intellij.ui.JBSplitter;
import com.intellij.ui.ListCellRendererWrapper;
import com.intellij.ui.OnePixelSplitter;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBPanelWithEmptyText;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ui.StatusText;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class ToolchainSettingsPanel extends JPanel implements Disposable {
//    private final ComboBox<String> myToolSetKind;
//    private JBSplitter mySplitter;
//    private JBList myToolchainList;
    private final Tree uiTree;
    public ToolchainSettingsPanel(@NotNull Disposable var1, int var2) {
        uiTree = new Tree(new frontend.tree.TreeModel());
        this.add(uiTree);
//        this.myToolSetKind = new ComboBox<>(100);
//        this.myToolchainList = new JBList(1, 2, 3, 4);
//        this.myToolSetKind.setVisible(true);
//        this.add(this.myToolSetKind);
//        this.add(this.myToolchainList);
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
