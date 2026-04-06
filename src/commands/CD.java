package commands;

import virtualFileSystem.*;

public class CD implements cmd {
    private VFS vfs;

    public CD(VFS vfs) {
        this.vfs = vfs;
    }

    public void execute(String[] args) {
        if (args.length == 0)
        {
            System.out.println("");
            // replace this with swing output method later
            return;
        }
        vfs.cd(args[0]);
    }
}
