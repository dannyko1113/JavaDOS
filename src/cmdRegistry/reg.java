package cmdRegistry;

import java.util.*;

import commands.*;
import virtualFileSystem.*;
import shell.*;

public class reg
{
    private Map<String, cmd> cmds = new HashMap<>();
    private VFS vfs;
    private shell shellRef;
    public reg(VFS vfs, shell shellRef)
    {
        this.vfs = vfs;
        this.shellRef = shellRef;

        cmds.put("cd", new CD(vfs));
        cmds.put("cd.", new CDdot(vfs));
        cmds.put("cd..", new CDdotdot(vfs));
        cmds.put("dir", new DIR(vfs));
        cmds.put("echo", new ECHO(vfs));
        cmds.put("exit", new EXIT(shellRef));
    }

    public cmd getcmd(String name)
    {
        return cmds.get(name);
    }
    public VFS getVfs()
    {
        return vfs;
    }

}
