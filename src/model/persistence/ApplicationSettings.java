package model.persistence;

import com.intellij.openapi.components.*;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.tools.Tool;
import java.util.ArrayList;

@State(
        name = "AVRGCC.Application.Configuration",
        storages = {
                @Storage(value = "AVRGCC_ApplicationConfiguration.xml")
        }
)
public class ApplicationSettings implements PersistentStateComponent<ApplicationSettings.State> {

    public static class State {
        public ToolchainList toolchains = new ToolchainList();
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

    /* USABLE API STARTS HERE */
    public static ApplicationSettings getInstance() {
        return ServiceManager.getService(ApplicationSettings.class);
    }

    public ToolchainList getToolchainList() { return state.toolchains; }

    public boolean hasToolchain(String name) {
        for (Toolchain toolchain : state.toolchains) {
            if (toolchain.name.equals(name))
                return true;
        }
        return false;
    }

    public Toolchain getToolchain(String name) {
        for (Toolchain toolchain : state.toolchains) {
            if (toolchain.name.equals(name))
                return toolchain;
        }
        System.out.println("No toolchain with a name |" + name + "|");
        return null;
    }

    public void addToolchain(Toolchain toolchain) {
        state.toolchains.add(toolchain);
    }

    public void addFlavour(Toolchain toolchain, Toolchain.Flavour flavour) {
        if (toolchainDoesNotExist(toolchain)) {
            return;
        }
        if (toolchain.flavourList.contains(flavour)) return;
        toolchain.flavourList.add(flavour);
    }

    public void addFlavour(Toolchain toolchain, String flavourName, String flavourPath) {
        if (toolchainDoesNotExist(toolchain)) return;
        if (toolchainHasFlavour(toolchain, flavourName)) return;
        toolchain.flavourList.add(new Toolchain.Flavour(flavourName, flavourPath));
    }

    public void deleteFlavour(Toolchain toolchain, Toolchain.Flavour flavour) {
        if (flavourIsNotInToolchain(toolchain, flavour)) return;
        toolchain.flavourList.remove(flavour);
    }

    public void setDefaultFlavour(Toolchain toolchain, Toolchain.Flavour flavour) {
        if (flavourIsNotInToolchain(toolchain, flavour)) return;
        toolchain.defaultFlavour = flavour;
    }

    public boolean toolchainDoesNotExist(Toolchain toolchain) {
        if (!state.toolchains.contains(toolchain)) {
            System.out.println("No such toolchain!");
            return true;
        }
        return false;
    }

    public boolean flavourIsNotInToolchain(Toolchain toolchain, Toolchain.Flavour flavour) {
        if (toolchainDoesNotExist(toolchain)) {
            return true;
        }
        if (!toolchain.flavourList.contains(flavour)) {
            System.out.println("No such flavour!");
            return true;
        }
        return false;
    }

    private boolean toolchainHasFlavour(Toolchain toolchain, String flavourName) {
        for (Toolchain.Flavour flavour : toolchain.flavourList) {
            if (flavour.name.equals(flavourName)) return true;
        }
        return false;
    }

    public static class Toolchain {
        public static class Flavour {
            public String name = new String();
            public String path = new String();

            public Flavour(String name, String path) {
                this.name = name;
                this.path = path;
            }

            @Override
            public String toString() {
                return name;
            }
        }
        public static class FlavourList extends ArrayList<Flavour> implements ListModel {
            /**
             * Returns the length of the list.
             *
             * @return the length of the list
             */
            @Override
            public int getSize() {
                return this.size();
            }

            /**
             * Returns the value at the specified index.
             *
             * @param index the requested index
             * @return the value at <code>index</code>
             */
            @Override
            public Object getElementAt(int index) {
                return this.get(index);
            }

            /**
             * Adds a listener to the list that's notified each time a change
             * to the data model occurs.
             *
             * @param l the <code>ListDataListener</code> to be added
             */
            @Override
            public void addListDataListener(ListDataListener l) {

            }

            /**
             * Removes a listener from the list that's notified each time a
             * change to the data model occurs.
             *
             * @param l the <code>ListDataListener</code> to be removed
             */
            @Override
            public void removeListDataListener(ListDataListener l) {

            }
        }

        public FlavourList flavourList = new FlavourList();
        public Flavour defaultFlavour = null;
        public String name = new String();

        public Toolchain(String name) {
            this.name = name;
        }

        public void addFlavour(Flavour flavour) {
            this.flavourList.add(flavour);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class ToolchainList extends ArrayList<Toolchain> {}
}
