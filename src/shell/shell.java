package shell;

import java.util.*;
import java.nio.file.*;

import commands.*;
import virtualFileSystem.*;
import cmdRegistry.*;

public class shell
{
    private reg registry;
    private boolean running = true;
    public shell(reg registry)
    {
        this.registry = registry;
    }
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        while (running)
        {
            shellState state = registry.getVfs().getState();

            if (state.isEchoEnabled())
            {
                String drive = state.getCurrentDrive();
                Path root = registry.getVfs().getRoot();
                String relativePath = state.getRelativePath(root);

                System.out.print(drive + ":" + relativePath + ">");
            }


            String input = sc.nextLine();

            String[] token = input.trim().split("\\s+");

            if (input.trim().isEmpty())
            {
                continue;
            }

            String cmdName = token[0].toLowerCase();
            cmd command = registry.getcmd(cmdName);

            if (command != null)
            {
                String[] args = Arrays.copyOfRange(token, 1, token.length);
                command.execute(args);
            }
            else
            {
                System.out.println("Bad command or file name.");
            }
        }
    }
    public void stop()
    {
        running = false;
    }
    public void setRegistry(reg registry)
    {
        this.registry = registry;
    }
}
