package commands;

import virtualFileSystem.VFS;

public class ECHO implements cmd
{
    private VFS vfs;

    public ECHO(VFS vfs)
    {
        this.vfs = vfs;
    }

    public void execute(String[] args)
    {
        if (args.length == 0) // when args is blank
        {
            System.out.println("ECHO is " + (vfs.getState().isEchoEnabled() ? "ON" : "OFF"));
            return;
        }

        String first = args[0].toLowerCase();


        if (args.length == 1 && (first.equals("on") || first.equals("off"))) // echo on or off
        {
            boolean enabled = first.equals("on"); //also boolean
            vfs.getState().setEchoEnabled(enabled);
            return;
        }

        StringBuilder sb = new StringBuilder(); // echo normal texts
        for (int i = 0; i < args.length; i++)
        {
            sb.append(args[i]);
            if (i < args.length - 1)
                sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}