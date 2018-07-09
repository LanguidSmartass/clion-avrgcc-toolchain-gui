package model.persistence;

import com.intellij.openapi.components.*;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.tools.Tool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@State(
        name = "AVRGCC.Application.Configuration",
        storages = {
                @Storage(value = "AVRGCC_ApplicationConfiguration.xml")
        }
)
public class ApplicationSettings implements PersistentStateComponent<ApplicationSettings.State> {

    public static class State {
        public ArrayList<String> toolchainNames = new ArrayList<>();
        // <ToolchainName, <FlavourName, FlavourPath>
        public HashMap<String, HashMap<String, String>> toolchainFlavours = new HashMap<>();
        // <ToolchainName, FlavourName>
        public HashMap<String, String> defaultFlavours = new HashMap<>();
        public State() {}
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

    private boolean toolchainExists(String toolchainName) {
        if (!state.toolchainNames.contains(toolchainName)) return false;
        if (!state.toolchainFlavours.containsKey(toolchainName)) return false;
//        if (state.defaultFlavours.containsKey(toolchainName)) return true;
        return true;
    }

    private boolean flavourExists(String toolchainName, String flavourName) {
        if (state.toolchainFlavours.get(toolchainName) == null)
            state.toolchainFlavours.replace(toolchainName, new HashMap<>()); // repair broken
        return state.toolchainFlavours.get(toolchainName).containsKey(flavourName);
    }

    private boolean toolchainHasDefaultFlavour(String toolchainName) {
        return state.defaultFlavours.containsKey(toolchainName);
    }

    private void insertToolchain(String toolchainName) {
        state.toolchainNames.add(toolchainName);
        state.toolchainFlavours.put(toolchainName, new HashMap<>());
    }

    /* USABLE API STARTS HERE */
    public static ApplicationSettings getInstance() {
        return ServiceManager.getService(ApplicationSettings.class);
    }

    public boolean hasToolchain(String toolchainName) {
        return toolchainExists(toolchainName);
    }

    public void addToolchain(String toolchainName) {
        if (toolchainExists(toolchainName)) return;
        insertToolchain(toolchainName);
    }

    public ArrayList<String> getToolchains() {
        return state.toolchainNames;
    }

    public void addToolchainFlavour(String toolchainName, String flavourName, String flavourPath) {
        if (!toolchainExists(toolchainName)) return;
        if (flavourExists(toolchainName, flavourName)) return;
        state.toolchainFlavours.get(toolchainName).put(flavourName, flavourPath);
        if (toolchainHasDefaultFlavour(toolchainName)) return;
        state.defaultFlavours.put(toolchainName, flavourName);
    }

    public void deleteToolchainFlavour(String toolchainName, String flavourName) {
        if (!toolchainExists(toolchainName)) return;
        if (!flavourExists(toolchainName, flavourName)) return;
        state.toolchainFlavours.get(toolchainName).remove(flavourName);

        if (!toolchainHasDefaultFlavour(toolchainName)) return;
        if (!state.defaultFlavours.get(toolchainName).equals(flavourName)) return;
        // just delete the default flavour for now
        state.defaultFlavours.remove(toolchainName);
    }

    public ArrayList<String> getToolchainFlavours(String toolchainName) {
        if (!toolchainExists(toolchainName)) return null;
        if (state.toolchainFlavours.get(toolchainName) == null) return new ArrayList<>();
        if (state.toolchainFlavours.get(toolchainName).isEmpty()) return new ArrayList<>();
        return new ArrayList<>(state.toolchainFlavours.get(toolchainName).keySet());
    }

    public String getToolchainDefaultFlavour(String toolchainName) {
        return state.defaultFlavours.get(toolchainName);
    }

    public void setToolchainDefaultFlavour(String toolchainName, String flavourName) {
        if (!toolchainExists(toolchainName)) return;
        if (!flavourExists(toolchainName, flavourName)) return;
        if (!toolchainHasDefaultFlavour(toolchainName)) return;
        state.defaultFlavours.replace(toolchainName, flavourName);
    }

    public String getToolchainFlavourPath(String toolchainName, String flavourName) {
        if (!toolchainExists(toolchainName)) return null;
        if (!flavourExists(toolchainName, flavourName)) return null;
        return state.toolchainFlavours.get(toolchainName).get(flavourName);
    }

    public void setToolchainFlavourPath(String toolchainName, String flavourName, String flavourPath) {
        if (!toolchainExists(toolchainName)) return;
        if (!flavourExists(toolchainName, flavourName)) return;
        state.toolchainFlavours.get(toolchainName).replace(flavourName, flavourPath);
    }
}
