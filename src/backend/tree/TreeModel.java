package backend.tree;
// temporarily hardcoded tree structure with names etc.
public class TreeModel {
    private final NamedTreeNode root;

    public TreeModel() {
        root = new NamedTreeNode("Root");

        NamedTreeNode device = new NamedTreeNode("Device");
        device.makeAsLeaf();
        root.addChild(device);

        NamedTreeNode common = new NamedTreeNode("AVR/GNU Common");
        root.addChild(common);
        {
            NamedTreeNode general  = new NamedTreeNode("General", new backend.tree.common.General());
            NamedTreeNode outfiles = new NamedTreeNode("Output Files");
            general.makeAsLeaf();
            outfiles.makeAsLeaf();
            common.addChild(general);
            common.addChild(outfiles);
        }

        NamedTreeNode ccomp = new NamedTreeNode("AVR/GNU C Compiler");
        root.addChild(ccomp);
        {
            NamedTreeNode general = new NamedTreeNode("General");
            NamedTreeNode preproc = new NamedTreeNode("Preprocessor");
            NamedTreeNode symb    = new NamedTreeNode("Symbols");
            NamedTreeNode dirs    = new NamedTreeNode("Directories");
            NamedTreeNode optim   = new NamedTreeNode("Optimization");
            NamedTreeNode debug   = new NamedTreeNode("Debugging");
            NamedTreeNode warns   = new NamedTreeNode("Warnings");
            NamedTreeNode misc    = new NamedTreeNode("Miscellaneous");
            general.makeAsLeaf();
            preproc.makeAsLeaf();
            symb.makeAsLeaf();
            dirs.makeAsLeaf();
            optim.makeAsLeaf();
            debug.makeAsLeaf();
            warns.makeAsLeaf();
            misc.makeAsLeaf();
            ccomp.addChild(general);
            ccomp.addChild(preproc);
            ccomp.addChild(symb);
            ccomp.addChild(dirs);
            ccomp.addChild(optim);
            ccomp.addChild(debug);
            ccomp.addChild(warns);
            ccomp.addChild(misc);
        }

        NamedTreeNode cppcomp = new NamedTreeNode("AVR/GNU C++ Compiler");
        root.addChild(cppcomp);
        {
            NamedTreeNode general = new NamedTreeNode("General");
            NamedTreeNode preproc = new NamedTreeNode("Preprocessor");
            NamedTreeNode symb    = new NamedTreeNode("Symbols");
            NamedTreeNode dirs    = new NamedTreeNode("Directories");
            NamedTreeNode optim   = new NamedTreeNode("Optimization");
            NamedTreeNode debug   = new NamedTreeNode("Debugging");
            NamedTreeNode warns   = new NamedTreeNode("Warnings");
            NamedTreeNode misc    = new NamedTreeNode("Miscellaneous");
            general.makeAsLeaf();
            preproc.makeAsLeaf();
            symb.makeAsLeaf();
            dirs.makeAsLeaf();
            optim.makeAsLeaf();
            debug.makeAsLeaf();
            warns.makeAsLeaf();
            misc.makeAsLeaf();
            cppcomp.addChild(general);
            cppcomp.addChild(preproc);
            cppcomp.addChild(symb);
            cppcomp.addChild(dirs);
            cppcomp.addChild(optim);
            cppcomp.addChild(debug);
            cppcomp.addChild(warns);
            cppcomp.addChild(misc);
        }

        NamedTreeNode linker = new NamedTreeNode("AVR/GNU Linker");
        root.addChild(linker);
        {
            NamedTreeNode general = new NamedTreeNode("General");
            NamedTreeNode libs    = new NamedTreeNode("Libraries");
            NamedTreeNode optim   = new NamedTreeNode("Optimization");
            NamedTreeNode memset  = new NamedTreeNode("Memory Settings");
            NamedTreeNode misc    = new NamedTreeNode("Miscellaneous");
            general.makeAsLeaf();
            libs.makeAsLeaf();
            optim.makeAsLeaf();
            memset.makeAsLeaf();
            misc.makeAsLeaf();
            linker.addChild(general);
            linker.addChild(libs);
            linker.addChild(optim);
            linker.addChild(memset);
            linker.addChild(misc);
        }

        NamedTreeNode asm = new NamedTreeNode("AVR/GNU Assembler");
        root.addChild(asm);
        {
            NamedTreeNode general = new NamedTreeNode("General");
            NamedTreeNode debug   = new NamedTreeNode("Debugging");
            general.makeAsLeaf();
            debug.makeAsLeaf();
            asm.addChild(general);
            asm.addChild(debug);
        }

        NamedTreeNode arch = new NamedTreeNode("AVR/GNU Archiver");
        root.addChild(arch);
        {
            NamedTreeNode general  = new NamedTreeNode("General");
            general.makeAsLeaf();
            arch.addChild(general);
        }
    }
    public NamedTreeNode getRoot() { return root; }
    public NamedTreeNode getChild(NamedTreeNode parent, int i) { return (NamedTreeNode) parent.getChild(i); }
    public int       getChildCount(NamedTreeNode parent) { return parent.getChildCount(); }

}
