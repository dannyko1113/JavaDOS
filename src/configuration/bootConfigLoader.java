package config;/*
bootconfig_loader
reads the raw BOOTCONFIG text file and converts them into a hashmap
 */
import java.nio.file.*;
import java.util.*;
import java.io.*;

// input: bootconfig_loader.loadPath(configPath(defined in the main method))
public class bootConfigLoader {
    public static Map<String, String> loadPath (Path rootPath) throws IOException
    {
        Map<String, String> config = new HashMap<>();

        List<String> lines1 = Files.readAllLines(rootPath); // reading each line in the config file

        for (String l : lines1) // assign each line to l
        {
            String[] pathPart = l.split("=", 2);
            // in A="B" from the config, pathPart[0] is A, pathPart[1] is B
            if (pathPart.length == 2) // the thing should have exactly two elements : A = "B"
            {
                config.put(pathPart[0].trim(), pathPart[1].replace("\"", "").trim());
            }
        }
        return config;
        // return as a properly formatted hashmap
    }
}