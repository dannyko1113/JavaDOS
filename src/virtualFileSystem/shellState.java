package VFSclass;/*
VFSclass.shellState
current position in the directory
 */

import java.nio.file.*;

public class shellState
{
    private Path currentDir;

    public shellState(Path root)
    {
        this.currentDir = root;
    }

    public Path getCurrentDir()
    {
        return currentDir;
    }
    public void setCurrentDir(Path path)
    {
        this.currentDir = path;
    }
}
