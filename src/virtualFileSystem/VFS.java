package virtualFileSystem;
/*
VirtualFS

 */
import java.nio.file.*;

public class VFS
{
    private final pathResolver resolver;
    private final shellState state;
    private final Path root;

    public VFS(Path root)
    {
        this.root = root;
        this.resolver = new pathResolver(root);
        this.state = new shellState(root);
    }

    public void cd(String input)
    {
        Path newPath = resolver.resolve(state.getCurrentDir(), input);

        if (!Files.exists(newPath))
        {
            System.out.println("No such directory.");
            return;
        }

        if (!Files.isDirectory(newPath))
        {
            System.out.println("Not a directory.");
            return;
        }

        // Detect drive switch
        if (input.matches("^[J-Vj-v]:.*"))
        {
            String drive = input.substring(0, 1).toUpperCase();
            state.setCurrentDrive(drive, newPath);
        }
        else
        {
            state.setCurrentDir(newPath);
        }
    }

    public Path getcd()
    {
        return state.getCurrentDir();
    }
    public shellState getState()
    {
        return state;
    }

    public Path getRoot()
    {
        return root; // or rootFinal if exposed
    }
}
