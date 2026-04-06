package virtualFileSystem;

import java.nio.file.*;

public class pathResolver
{
    private final Path rootFinal;

    public pathResolver(Path root)
    {
        this.rootFinal = root;
    }
    public Path resolve(Path currentDir, String input)
    {
        input = input.trim();

        // -------------------------------
        // 1. DRIVE SWITCH: J:
        // -------------------------------
        if (input.matches("^[A-Za-z]:$"))
        {
            String drive = input.substring(0, 1).toUpperCase();
            return rootFinal.resolve(drive);
        }

        // -------------------------------
        // 2. DRIVE WITH PATH: J:/dir1
        // -------------------------------
        if (input.matches("^[A-Za-z]:/.*"))
        {
            String drive = input.substring(0, 1).toUpperCase();
            String subPath = input.substring(3); // skip "J:/"

            Path driveRoot = rootFinal.resolve(drive);

            Path resolved = subPath.isEmpty()
                    ? driveRoot
                    : driveRoot.resolve(subPath);

            resolved = resolved.normalize();

            if (!resolved.startsWith(rootFinal.resolve(drive)))
            {
                throw new SecurityException("Outside drive root");
            }

            return resolved;
        }

        // -------------------------------
        // 3. ABSOLUTE PATH WITHIN DRIVE: /dir1
        // -------------------------------
        if (input.startsWith("/"))
        {
            Path driveRoot = getDriveRoot(currentDir);

            Path resolved = driveRoot.resolve(input.substring(1)).normalize();

            if (!resolved.startsWith(driveRoot))
            {
                throw new SecurityException("Outside drive root");
            }

            return resolved;
        }

        // -------------------------------
        // 4. RELATIVE PATH
        // -------------------------------
        Path resolved = currentDir.resolve(input).normalize();

        Path driveRoot = getDriveRoot(currentDir);

        if (!resolved.startsWith(driveRoot))
        {
            throw new SecurityException("Outside drive root");
        }

        return resolved;
    }
    private Path getDriveRoot(Path currentDir)
    {
        // Assumes structure: /Root1/DRIVE/...
        // Extract /Root1/DRIVE

        Path driveRoot = currentDir;

        while (driveRoot.getParent() != null &&
                !driveRoot.getParent().equals(rootFinal))
        {
            driveRoot = driveRoot.getParent();
        }

        return driveRoot;
    }

}