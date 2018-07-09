package model.persistence;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class ProjectSettings implements PersistentStateComponent<ProjectSettings.State> {

    public static class State {
        public HashMap<String, String> device = new HashMap<>();
        public HashMap<String, String> common = new HashMap<>();
        public HashMap<String, String> compC  = new HashMap<>();
        public HashMap<String, String> compCp = new HashMap<>();
        public HashMap<String, String> linker = new HashMap<>();
        public HashMap<String, String> assemb = new HashMap<>();
        public HashMap<String, String> archiv = new HashMap<>();
        public State() {}
    }

    private State state = new State();

    public static ProjectSettings getInstance(@NotNull Project project) {
        return ServiceManager.getService(project, ProjectSettings.class);
    }

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
}
