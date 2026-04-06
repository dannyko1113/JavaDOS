package virtualFileSystem;/*
VFSclass.shellState
current position in the directory
 */

import java.nio.file.*;

public class shellState
{
    private Path root;
    private String currentDrive; // J K L...
    private Path currentDir;

    public shellState(Path root)
    {
        this.root = root;
        this.currentDrive = "J";
        this.currentDir = root.resolve("J");
    }

    public Path getCurrentDir()
    {
        return currentDir;
    }
    public void setCurrentDir(Path path)
    {
        this.currentDir = path;
    }
    public String getCurrentDrive()
    {
        return currentDrive;
    }
    public void setCurrentDrive(String drv, Path path)
    {
        this.currentDrive = drv;
        this.currentDir = path;
    }

    public String getRelativePath(Path rootFinal)
    {
        Path driveRoot = rootFinal.resolve(currentDrive);

        Path relative = driveRoot.relativize(currentDir);

        if (relative.toString().isEmpty())
        {
            return "/";
        }

        return "/" + relative.toString().replace("\\", "/");
    }
}
