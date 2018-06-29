
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.PathEnvironmentVariableUtil;
import com.intellij.openapi.util.Trinity;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.EnvironmentUtil;
import com.intellij.util.PathUtil;
import com.intellij.util.CommonProcessors.FindFirstProcessor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.hash.HashMap;
import com.jetbrains.cidr.ArchitectureType;
import com.jetbrains.cidr.ToolVersion;
import com.jetbrains.cidr.cpp.CPPBundle;
import com.jetbrains.cidr.cpp.CPPLog;
import com.jetbrains.cidr.cpp.toolchains.CPPToolSet;
import com.jetbrains.cidr.cpp.toolchains.CPPToolSet.InstallationProcessor;
import com.jetbrains.cidr.cpp.toolchains.CPPToolSet.Kind;
import com.jetbrains.cidr.cpp.toolchains.CPPToolSet.Option;
import com.jetbrains.cidr.lang.toolchains.CidrToolEnvironment;
import com.jetbrains.cidr.lang.toolchains.CidrToolEnvironment.PrepareFor;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AvrGcc extends CPPToolSet {
    public AvrGcc(@NotNull Kind kind, @NotNull File file) {
        super(kind, file);
    }

    @Nullable
    @Override
    public String readVersion() {
        return "qwe123";
    }

    @Override
    public String checkVersion(@NotNull String s) {
        return "qwe123";
    }

    @NotNull
    @Override
    public char[] getSupportedFileSeparators() {
        return new char[0];
    }

    @NotNull
    @Override
    public File getGDBPath() {
        return null;
    }

    @Override
    public boolean isBundledGdbCompatible() {
        return false;
    }
}
