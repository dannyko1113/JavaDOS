package VFSclass;/*
VirtualFS

 */
import java.nio.file.*;

public class VFS
{
    private final pathResolver resolver;
    private final shellState state;

    public VFS(Path root)
    {
        this.resolver = new pathResolver(root);
        this.state = new shellState(root);
    }

    public void cd(String path)
    {
        Path newPath = resolver.resolve(state.getCurrentDir(), path);
        // define new path
        if (!Files.exists(newPath))
        {
            throw new RuntimeException("Invalid Directory.");
        }
        if (Files.isDirectory(newPath)) // check if it is an existing path
        {
            state.setCurrentDir(newPath);
        }
        else
        {
            throw new RuntimeException("Not a Directory.");
        }
    }

    public Path getcd()
    {
        return state.getCurrentDir();
    }
}
