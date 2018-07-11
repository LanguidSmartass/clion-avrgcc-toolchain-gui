package model.aggregation;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import view.resources.PluginBundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CMakeWriter {
    private static ResourceBundle bundle = PluginBundle.getImmutableTextContents();
    private static String filePath;

    private PrintWriter cmakeWriter = null;

    public CMakeWriter() throws FileNotFoundException {
        ProjectManager projectManager = ProjectManager.getInstance();
        if (projectManager.getOpenProjects().length <= 0)
            throw new ExceptionInInitializerError("No projects are currently opened");

        String dir = projectManager.getOpenProjects()[0].getBasePath();
        filePath = dir + "/" + bundle.getString("cmake.generate.file.name");
        try {
            File file = new File(filePath);
            cmakeWriter = new PrintWriter(filePath);
            System.out.println(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("File " + filePath + " not found");
            throw e;
        }
    }

    public void writeSetSimple(String var, String value) {
        String test = "";
        StringBuilder builder = new StringBuilder();
        builder.append("set(");
        builder.append(var);
        builder.append(" ");
        builder.append(value);
        builder.append(")");
        cmakeWriter.println(builder.toString());
    }

    public void writeFindProgramSimple(String var, String name, String path) {
        StringBuilder builder = new StringBuilder();
        builder.append("find_program(");
        builder.append(var);
        builder.append(" ");
        builder.append(name);
        builder.append(" ");
        builder.append(path);
        builder.append(")");
        cmakeWriter.println(builder.toString());
    }

    public void writeAddExecutable(String name, String property, ArrayList<String> sourceFiles) {
        StringBuilder builder = new StringBuilder();
        builder.append("add_executable(");
        builder.append(name);
        builder.append(" ");
        builder.append(property);
        for (String file : sourceFiles) {
            builder.append(" ");
            builder.append(file);
        }
        builder.append(")");
        cmakeWriter.println(builder.toString());
    }

    public void close() {
        cmakeWriter.close();
    }
}
