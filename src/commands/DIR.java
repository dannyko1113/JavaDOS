package commands;

import virtualFileSystem.*;

public class DIR implements cmd {
    private VFS vfs;

    public DIR(VFS vfs) {
        this.vfs = vfs;
    }

    public void execute(String[] args) {
        if (args.length == 0)
        {
            System.out.println("Usage: cd <path>");
            // replace this with swing output method later
            return;
        }
        vfs.cd(args[0]);
    }
}
