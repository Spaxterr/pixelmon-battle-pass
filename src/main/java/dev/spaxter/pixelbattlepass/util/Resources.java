package dev.spaxter.pixelbattlepass.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Plugin utility resources.
 */
public class Resources {
    /**
     * Read a plugin resource as a string.
     *
     * @param resource Resource input stream.
     * @return Resource contents as string.
     */
    public static String readAsString(final InputStream resource) {
        final String result = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))
                                  .lines()
                                  .collect(Collectors.joining("\n"));
        return result;
    }
}
