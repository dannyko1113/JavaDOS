package commands;

import shell.shell;

public class EXIT implements cmd
{
    private shell shellRef;

    public EXIT(shell shellRef)
    {
        this.shellRef = shellRef;
    }

    public void execute(String[] args)
    {
        shellRef.stop();
    }
}