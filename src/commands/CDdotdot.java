package commands;

import virtualFileSystem.*;

public class CDdotdot implements cmd {
    private VFS vfs;

    public CDdotdot(VFS vfs) {
        this.vfs = vfs;
    }

    public void execute(String[] args) {
        vfs.cd("..");
    }
}
