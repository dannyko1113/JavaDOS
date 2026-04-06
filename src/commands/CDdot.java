package commands;

import virtualFileSystem.*;

public class CDdot implements cmd {
    private VFS vfs;

    public CDdot(VFS vfs) {
        this.vfs = vfs;
    }

    public void execute(String[] args) {
        vfs.cd(".");
    }
}
