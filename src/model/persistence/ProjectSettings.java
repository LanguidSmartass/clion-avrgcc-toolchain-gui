package model.persistence;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ProjectSettings {
    public ProjectSettings(Project project) {
    }

    public static ProjectSettings getInstance(@NotNull Project project) {
        return ServiceManager.getService(project, ProjectSettings.class);
    }
}
