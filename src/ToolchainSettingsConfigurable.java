import com.intellij.ide.ui.UINumericRange;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.util.messages.Topic;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ToolchainSettingsConfigurable implements SearchableConfigurable, Disposable {
    public static final Topic<Listener> TOPIC;
    public static final String ID = "CPPToolchains";
    public static final String DISPLAY_NAME;
    private ToolchainPanel myPanel = null;
    private int myPreselectedToolchain;

    @NotNull
    @Override
    public String getId() {
        return "getId";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "getDisplayName";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "getHelpTopic";
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, @NotNull String value) {
        return false;
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, int value, @NotNull UINumericRange range) {
        return false;
    }

    @Override
    public boolean isModified(@NotNull JToggleButton toggleButton, boolean value) {
        return false;
    }

    @Nullable
    @Override
    public JComponent createComponent() {

        if (this.myPanel == null) {
            this.myPanel = new ToolchainPanel(this, this.myPreselectedToolchain);
            this.myPanel.autoRecheckWithApplication();
        }
        this.myPanel.setVisible(true);
        return this.myPanel;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {
    }

    @Override
    public void reset() {
    }

    @Override
    public void disposeUIResources() {
    }

    @Override
    public void dispose() {
    }


    public interface Listener {
//        void toolchainsChanged(@NotNull List<Toolchain> var1, @NotNull List<Pair<String, String>> var2);

        void toolchainRenamed(int var1, @NotNull String var2);

        void toolchainsApplied() throws ConfigurationException;
    }

    static {
        long var0 = 11775785817021L;
        TOPIC = Topic.create("Toolchain Experimental editor topic", ToolchainSettingsConfigurable.Listener.class);
        DISPLAY_NAME = CPPBundleExperimental.message("cpp.toolchains", new Object[0]);
    }

}
