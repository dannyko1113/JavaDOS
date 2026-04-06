package commands;

import virtualFileSystem.*;

public class DIR implements cmd {
    private VFS vfs;

    public DIR(VFS vfs)
    {
        this.vfs = vfs;
    }

    public void execute(String[] args)
    {
        if (args.length == 0)
        {

        }

    }
}
