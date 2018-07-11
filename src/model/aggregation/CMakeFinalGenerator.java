package model.aggregation;

import view.resources.PluginBundle;

import java.io.FileNotFoundException;
import java.util.ResourceBundle;

public class CMakeFinalGenerator {
    private CMakeWriter writer;

    private final String AVRGCC_TOOLCHAIN_ROOT = "AVRGCC_TOOLCHAIN_ROOT";
    private final String AVR_C_COMPILER = "AVR_C_COMPILER";
    private final String AVR_CXX_COMPILER = "AVR_CXX_COMPILER";
    private final String AVR_OBJCOPY = "AVR_OBJCOPY";
    private final String AVR_SIZE = "AVR_SIZE";
    private final String AVR_OBJDUMP = "AVR_OBJDUMP";

    public CMakeFinalGenerator() throws FileNotFoundException {
        writer = new CMakeWriter();
    }

    private String encloseInExpression(String s) {
        return "${" + s + "}";
    }

    public void generate() {
        ResourceBundle bundle = PluginBundle.getImmutableTextContents();

        String avr_c = bundle.getString("avrgnu.executable.name.compiler.c");
        String avr_cxx = bundle.getString("avrgnu.executable.name.compiler.cpp");
        String avr_objcopy = bundle.getString("avrgnu.executable.name.objcopy");
        String avr_size = bundle.getString("avrgnu.executable.name.size");
        String avr_objdump = bundle.getString("avrgnu.executable.name.objdump");

        String path = AggregateExtractor.getProjectToolchainPath();
        path = path.replace('\\', '/');
        writer.writeSetSimple(AVRGCC_TOOLCHAIN_ROOT, path);                // set(AVRGCC_TOOLCHAIN_ROOT path/to/toolchain)
        String path_macro = encloseInExpression(AVRGCC_TOOLCHAIN_ROOT);
        String bin_dir = path_macro + "/bin";
        writer.writeFindProgramSimple(AVR_C_COMPILER, avr_c, bin_dir);     // find_program(AVR_CC avr-gcc ${AVRGCC_TOOLCHAIN_ROOT}/bin)
        writer.writeFindProgramSimple(AVR_CXX_COMPILER, avr_cxx, bin_dir); // find_program(AVR_CXX avr-g++ ${AVRGCC_TOOLCHAIN_ROOT}/bin)
        writer.writeFindProgramSimple(AVR_OBJCOPY, avr_objcopy, bin_dir);  // find_program(AVR_OBJCOPY avr-objcopy ${AVRGCC_TOOLCHAIN_ROOT}/bin)
        writer.writeFindProgramSimple(AVR_SIZE, avr_size, bin_dir);        // find_program(AVR_SIZE_TOOL avr-size ${AVRGCC_TOOLCHAIN_ROOT}/bin
        writer.writeFindProgramSimple(AVR_OBJDUMP, avr_objdump, bin_dir);  // find_program(AVR_OBJDUMP avr-objdump ${AVRGCC_TOOLCHAIN_ROOT}/bin)

        writer.writeSetSimple("CMAKE_FIND_ROOT_PATH", path_macro);
        writer.writeSetSimple("CMAKE_SYSTEM_NAME", "Generic");
        writer.writeSetSimple("CMAKE_SYSTEM_PROCESSOR", "avr");
        writer.writeSetSimple("CMAKE_C_COMPILER", encloseInExpression(AVR_C_COMPILER));
        writer.writeSetSimple("CMAKE_CXX_COMPILER", encloseInExpression(AVR_CXX_COMPILER));

        writer.writeSetSimple("CMAKE_FIND_ROOT_PATH_MODE_PROGRAM", "NEVER");
        writer.writeSetSimple("CMAKE_FIND_ROOT_PATH_MODE_LIBRARY", "ONLY");
        writer.writeSetSimple("CMAKE_FIND_ROOT_PATH_MODE_INCLUDE", "ONLY");

        writer.writeSetSimple("CMAKE_SYSTEM_INCLUDE_PATH", "${CMAKE_FIND_ROOT_PATH}/include");
        writer.writeSetSimple("CMAKE_SYSTEM_LIBRARY_PATH", "${CMAKE_FIND_ROOT_PATH}/lib");

        writer.close();
    }
}
