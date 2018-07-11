package model.persistence;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

@State(
        name = "AVRGCC.Project.Configuration",
        storages = {
                @Storage(value = "AVRGCC_ProjectConfiguration.xml")
        }
)
public class ProjectSettings implements PersistentStateComponent<ProjectSettings.State> {

    public static class State {
        // Toolchain
        public String selectedToolchain = new String();
        public String selectedFlavour = new String();
        // Device
        public String deviceName = new String();
        // AVR/GNU Common section
        public HashMap<String, Boolean> commonFlags = new HashMap<>();
        public ArrayList<String> commonDefaultIncludePaths = new ArrayList<>();
        // AVR/GNU C Compiler section
        public HashMap<String, Boolean> compCFlags  = new HashMap<>();
        public ArrayList<String> compCSymbolsDefined = new ArrayList<>();
        public ArrayList<String> compCSymbolsUndefined = new ArrayList<>();
        public ArrayList<String> compCIncludePaths = new ArrayList<>();
        public String compCOptimLevel = new String();
        public String compCOtherOptimFlags = new String();
        public String compCDebugLevel = new String();
        public String compCOtherDebugFlags = new String();
        public String compCOtherMiscFlags = new String();
        // AVR/GNU C Compiler section
        public HashMap<String, Boolean> compCppFlags = new HashMap<>();
        public ArrayList<String> compCppSymbolsDefined = new ArrayList<>();
        public ArrayList<String> compCppSymbolsUndefined = new ArrayList<>();
        public ArrayList<String> compCppIncludePaths = new ArrayList<>();
        public String compCppOptimLevel = new String();
        public String compCppOtherOptimFlags = new String();
        public String compCppDebugLevel = new String();
        public String compCppOtherDebugFlags = new String();
        public String compCppOtherMiscFlags = new String();
        // AVR/GNU Linker
        public HashMap<String, Boolean> linkerFlags = new HashMap<>();
        public ArrayList<String> linkerLibraries = new ArrayList<>();
        public ArrayList<String> linkerLibSearchPaths = new ArrayList<>();
        public String linkerInitStackAddr = new String();
        public ArrayList<String> linkerSegmentFLASH = new ArrayList<>();
        public ArrayList<String> linkerSegmentSRAM = new ArrayList<>();
        public ArrayList<String> linkerSegmentEEPROM = new ArrayList<>();
        public String linkerOtherMiscFlags = new String();
        // AVR/GNU Assembler
        public HashMap<String, Boolean> asmFlags = new HashMap<>();
        public String asmOtherFlags = new String();
        public ArrayList<String> asmIncludePaths = new ArrayList<>();
        public String asmDebugLevel = new String();
        // AVR/GNU Archiver
        public HashMap<String, Boolean> archFlags = new HashMap<>();
        public String archOtherFlags = new String();

        public State() {}
    }

    private State state = new State();

    // ArrayList and HashMap containers can be modified externally through their getters
    // Strings setters only
    public void setSelectedToolchain(String selectedToolchain) {
        state.selectedToolchain = selectedToolchain;
    }

    public void setSelectedFlavour(String selectedFlavour) {
        state.selectedFlavour = selectedFlavour;
    }

    public void setDeviceName(String deviceName) {
        state.deviceName = deviceName;
    }

    public void setCompCOptimLevel(String compCOptimLevel) {
        state.compCOptimLevel = compCOptimLevel;
    }

    public void setCompCOtherOptimFlags(String compCOtherOptimFlags) {
        state.compCOtherOptimFlags = compCOtherOptimFlags;
    }

    public void setCompCDebugLevel(String compCDebugLevel) {
        state.compCDebugLevel = compCDebugLevel;
    }

    public void setCompCOtherDebugFlags(String compCOtherDebugFlags) {
        state.compCOtherDebugFlags = compCOtherDebugFlags;
    }

    public void setCompCOtherMiscFlags(String compCOtherMiscFlags) {
        state.compCOtherMiscFlags = compCOtherMiscFlags;
    }

    public void setCompCppOptimLevel(String compCppOptimLevel) {
        state.compCppOptimLevel = compCppOptimLevel;
    }

    public void setCompCppOtherOptimFlags(String compCppOtherOptimFlags) {
        state.compCppOtherOptimFlags = compCppOtherOptimFlags;
    }

    public void setCompCppDebugLevel(String compCppDebugLevel) {
        state.compCppDebugLevel = compCppDebugLevel;
    }

    public void setCompCppOtherDebugFlags(String compCppOtherDebugFlags) {
        state.compCppOtherDebugFlags = compCppOtherDebugFlags;
    }

    public void setCompCppOtherMiscFlags(String compCppOtherMiscFlags) {
        state.compCppOtherMiscFlags = compCppOtherMiscFlags;
    }

    public void setLinkerInitStackAddr(String linkerInitStackAddr) {
        state.linkerInitStackAddr = linkerInitStackAddr;
    }

    public void setLinkerOtherMiscFlags(String linkerOtherMiscFlags) {
        state.linkerOtherMiscFlags = linkerOtherMiscFlags;
    }

    public void setAsmOtherFlags(String asmOtherFlags) {
        state.asmOtherFlags = asmOtherFlags;
    }

    public void setAsmDebugLevel(String asmDebugLevel) {
        state.asmDebugLevel = asmDebugLevel;
    }

    public void setArchOtherFlags(String archOtherFlags) {
        state.archOtherFlags = archOtherFlags;
    }

    // Plain getters
    public String getSelectedToolchain() {
        return state.selectedToolchain;
    }

    public String getSelectedFlavour() {
        return state.selectedFlavour;
    }

    public String getDeviceName() {
        return state.deviceName;
    }

    public HashMap<String, Boolean> getCommonFlags() {
        return state.commonFlags;
    }

    public ArrayList<String> getCommonDefaultIncludePaths() {
        return state.commonDefaultIncludePaths;
    }

    public HashMap<String, Boolean> getCompCFlags() {
        return state.compCFlags;
    }

    public ArrayList<String> getCompCSymbolsDefined() {
        return state.compCSymbolsDefined;
    }

    public ArrayList<String> getCompCSymbolsUndefined() {
        return state.compCSymbolsUndefined;
    }

    public ArrayList<String> getCompCIncludePaths() {
        return state.compCIncludePaths;
    }

    public String getCompCOptimLevel() {
        return state.compCOptimLevel;
    }

    public String getCompCOtherOptimFlags() {
        return state.compCOtherOptimFlags;
    }

    public String getCompCDebugLevel() {
        return state.compCDebugLevel;
    }

    public String getCompCOtherDebugFlags() {
        return state.compCOtherDebugFlags;
    }

    public String getCompCOtherMiscFlags() {
        return state.compCOtherMiscFlags;
    }

    public HashMap<String, Boolean> getCompCppFlags() {
        return state.compCppFlags;
    }

    public ArrayList<String> getCompCppSymbolsDefined() {
        return state.compCppSymbolsDefined;
    }

    public ArrayList<String> getCompCppSymbolsUndefined() {
        return state.compCppSymbolsUndefined;
    }

    public ArrayList<String> getCompCppIncludePaths() {
        return state.compCppIncludePaths;
    }

    public String getCompCppOptimLevel() {
        return state.compCppOptimLevel;
    }

    public String getCompCppOtherOptimFlags() {
        return state.compCppOtherOptimFlags;
    }

    public String getCompCppDebugLevel() {
        return state.compCppDebugLevel;
    }

    public String getCompCppOtherDebugFlags() {
        return state.compCppOtherDebugFlags;
    }

    public String getCompCppOtherMiscFlags() {
        return state.compCppOtherMiscFlags;
    }

    public HashMap<String, Boolean> getLinkerFlags() {
        return state.linkerFlags;
    }

    public ArrayList<String> getLinkerLibraries() {
        return state.linkerLibraries;
    }

    public ArrayList<String> getLinkerLibSearchPaths() {
        return state.linkerLibSearchPaths;
    }

    public String getLinkerInitStackAddr() {
        return state.linkerInitStackAddr;
    }

    public ArrayList<String> getLinkerSegmentFLASH() {
        return state.linkerSegmentFLASH;
    }

    public ArrayList<String> getLinkerSegmentSRAM() {
        return state.linkerSegmentSRAM;
    }

    public ArrayList<String> getLinkerSegmentEEPROM() {
        return state.linkerSegmentEEPROM;
    }

    public String getLinkerOtherMiscFlags() {
        return state.linkerOtherMiscFlags;
    }

    public HashMap<String, Boolean> getAsmFlags() {
        return state.asmFlags;
    }

    public String getAsmOtherFlags() {
        return state.asmOtherFlags;
    }

    public ArrayList<String> getAsmIncludePaths() {
        return state.asmIncludePaths;
    }

    public String getAsmDebugLevel() {
        return state.asmDebugLevel;
    }

    public HashMap<String, Boolean> getArchFlags() {
        return state.archFlags;
    }

    public String getArchOtherFlags() {
        return state.archOtherFlags;
    }

    public static ProjectSettings getInstance() {
        Project[] projects = ProjectManager.getInstance().getOpenProjects();
        if (projects.length == 0) return null;
        return ProjectSettings.getInstance(projects[0]);
    }

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
