package model.persistence;

import com.intellij.openapi.components.*;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

@State(
        name = "AVRGCC.Application.Configuration",
        storages = {
                @Storage(value = "AVRGCC_ApplicationConfiguration.xml")
        }
)
public class ApplicationSettings implements PersistentStateComponent<ApplicationSettings.State> {

    public static class State {
        public String toolchainPath = null;
//        public ArrayList<ToolchainSet> toolchains;
    }

    private State state = new State();

    @Nullable
    @Override
    public State getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull State state) {
        this.state = state;
    }

    @Override
    public void noStateLoaded() {

    }

    public static ApplicationSettings getInstance() {
        return ServiceManager.getService(ApplicationSettings.class);
    }

    public void setPath(String path) {
        state.toolchainPath = path;
    }

    public String getPath() {
        return state.toolchainPath;
    }

    private static class ToolchainSet {
        private static class Flavour {
            public String name;
            public String path;
        }
        private static class FlavourList extends ArrayList<Flavour> {}

        private FlavourList defaultFlavour;
    }
}
