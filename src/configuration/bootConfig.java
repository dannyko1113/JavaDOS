package config;/*
bootconfig
brings the hashmap from loader and converts it into a path format
 */

import java.nio.file.*;
import java.util.*;

public class bootConfig {
    private Path rootPath; // path format to return


    public bootConfig(Map<String, String> config) // hashmap from loader
    {
        this.rootPath = Paths.get(config.get("ROOT")); // get the path text assigned to ROOT
    }

    public Path getRootPath() {
        return rootPath;
    }
}
