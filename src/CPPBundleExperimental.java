import com.intellij.CommonBundle;
import com.intellij.reference.SoftReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.util.ResourceBundle;

public class CPPBundleExperimental {
    private static Reference<ResourceBundle> ourBundle;
    private static final String BUNDLE = "CPPBundleExperimental";

    public CPPBundleExperimental() {
    }

    public static String message(@NotNull @PropertyKey(resourceBundle = "CPPBundleExperimental") String var0, @NotNull Object... var1) {
        if (var0 == null) {
//            a(0);
        }

        if (var1 == null) {
//            a(1);
        }

        return CommonBundle.message(getBundle(), var0, var1);
    }

    public static ResourceBundle getBundle() {
        long var0 = 84596889362335L;
        ResourceBundle var2 = (ResourceBundle)SoftReference.dereference(ourBundle);
        if (var2 == null) {
            var2 = ResourceBundle.getBundle("com.jetbrains.cidr.cpp.CPPBundle");
            ourBundle = new java.lang.ref.SoftReference(var2);
        }

        return var2;
    }
}
