import java.io.*;
import java.util.*;
import java.nio.file.*;

import cmdRegistry.*;
import commands.*;
import configuration.*;
import shell.*;
import virtualFileSystem.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Path configPath = Paths.get("/Users/stardust/Documents/JavaDOS Test/bootconfig.txt");
        Map<String, String> raw = bootConfigLoader.loadPath(configPath);
        bootConfig config = new bootConfig(raw);


        VFS vfs = new VFS(config.getRootPath());

        shell shell = new shell(null);
        reg registry = new reg(vfs, shell);

        shell.setRegistry(registry);

        shell.run();
    }
}