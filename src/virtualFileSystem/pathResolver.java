package VFSclass;/*
VFSclass.pathResolver
whats happening behind cd command
 */
import java.nio.file.*;

public class pathResolver
{
    private final Path rootFinal;
    // root directory: cant be modified at all once initialized

    public pathResolver(Path root)
    {
        this.rootFinal = root;
    }

    public Path resolve(Path currentDir, String input) //
    {
        Path resolved = currentDir.resolve(input).normalize();
        // resolve: apply the input command, normalize removes period modifiers

        if (!resolved.startsWith(rootFinal)) // if it gets out of root dir
        {
            throw new SecurityException("Cannot access outside root directory.");
        }
        return resolved;
    }
}
