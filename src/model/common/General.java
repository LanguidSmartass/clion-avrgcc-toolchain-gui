package model.common;

import java.util.ArrayList;
import java.util.Stack;

public class General {

    private String targetDeviceName;
    private Stack<String> defaultIncludePaths;
    private boolean mrelax;
    private boolean extOvfRamCheck;

    public General() {
        defaultIncludePaths = new Stack<>();
        targetDeviceName = "-mmcu=atmega2560";
        defaultIncludePaths.push("path 1");
        defaultIncludePaths.push("path 2");
        defaultIncludePaths.push("path 3");
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
