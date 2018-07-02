package backend.tree.common;

import backend.tree.ExtendedSettings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class General implements ExtendedSettings {

    private String targetDeviceNameLabel;
    private String targetDeviceName;
    private String defaultIncludePathsLabel;
    private Stack<String> defaultIncludePaths;
    private String mrelaxLabel;
    private boolean mrelax;
    private String extOvfRamCheckLabel;
    private boolean extOvfRamCheck;

    public String getTargetDeviceNameLabel() {
        return targetDeviceNameLabel;
    }

    public String getDefaultIncludePathsLabel() {
        return defaultIncludePathsLabel;
    }

    public String getMrelaxLabel() {
        return mrelaxLabel;
    }

    public String getExtOvfRamCheckLabel() {
        return extOvfRamCheckLabel;
    }

    public General() {
        targetDeviceNameLabel = "Target Device Name";
        defaultIncludePathsLabel = "Default Include Paths";
        mrelaxLabel = "Relax Branches (-mrelax)";
        extOvfRamCheckLabel = "External ram check for memory overflow (only if device supports this)";

        targetDeviceName = "-mmcu=atmega2560";

    }

    public String getTargetDeviceName() {
        return targetDeviceName;
    }

    public void setTargetDeviceName(String targetDeviceName) {
        this.targetDeviceName = targetDeviceName;
    }

    public ArrayList<String> getDefaultIncludePaths() {
        ArrayList<String> ret = new ArrayList<>(this.defaultIncludePaths.size());
        ret.addAll(this.defaultIncludePaths);
        return ret;
    }

    public void setDefaultIncludePaths(ArrayList<String> defaultIncludePaths) {
        this.defaultIncludePaths.clear();
        this.defaultIncludePaths.addAll(defaultIncludePaths);
    }

    public void addDefaultIncludePath(String defaultIncludePath) {
        this.defaultIncludePaths.add(defaultIncludePath);
    }

    public boolean isMrelax() {
        return mrelax;
    }

    public void setMrelax(boolean mrelax) {
        this.mrelax = mrelax;
    }

    public boolean isExtOvfRamCheck() {
        return extOvfRamCheck;
    }

    public void setExtOvfRamCheck(boolean extOvfRamCheck) {
        this.extOvfRamCheck = extOvfRamCheck;
    }

}
