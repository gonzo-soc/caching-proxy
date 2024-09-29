/*
 * This source file was generated by the Gradle 'init' task
 */
package ru.sakhalin2.caching_proxy;

import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;
import static org.hamcrest.CoreMatchers.hasItem;

public class ParserTest {

    @Test
    public void testInvalidArguments() {
        var parser = new CommandLineParser(new String[] { "-i", "app" });
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }

    @Test
    public void testClearCacheLongFormatSwitch() {
        var parser = new CommandLineParser(new String[] { "--clear-cache" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch", CommandLineParser.class.getName(),
                        CommandSwitch.CLEAR_CACHE.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.CLEAR_CACHE));
    }

    @Test
    public void testClearCacheShortFormatSwitch() {
        var parser = new CommandLineParser(new String[] { "-r" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch in the short format", CommandLineParser.class.getName(),
                        CommandSwitch.CLEAR_CACHE.getShortFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.CLEAR_CACHE));
    }

    @Test
    public void testOriginUrlLongFromatSwitch() {
        var parser = new CommandLineParser(new String[] { "--origin", "https://uibakery.io" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.ORIGIN_URL.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.ORIGIN_URL));
    }

    @Test
    public void testOriginUrlShortFromatSwitch() {
        var parser = new CommandLineParser(new String[] { "-u", "https://uibakery.io" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.ORIGIN_URL.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.ORIGIN_URL));
    }

    @Test
    public void testPortLongFromatSwitch() {
        var parser = new CommandLineParser(new String[] { "--port", "35535" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.PORT_NUMBER.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.PORT_NUMBER));
    }

    @Test
    public void testPortShortFromatSwitch() {
        var parser = new CommandLineParser(new String[] { "-p", "35535" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.PORT_NUMBER.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.PORT_NUMBER));
    }

    @Test
    public void testMultipleMixedFormatSwitch() {
        var parser = new CommandLineParser(new String[] { "--port", "35535", "--origin", "https://uibakery.io", "-r" });
        Map<CommandSwitch, String> cmdSwitchArgsMap = parser.parse();
        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.PORT_NUMBER.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.PORT_NUMBER));

        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.ORIGIN_URL.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.ORIGIN_URL));

        assumeThat(
                String.format("%s found %s switch in the long format", CommandLineParser.class.getName(),
                        CommandSwitch.CLEAR_CACHE.getLongFormat()),
                cmdSwitchArgsMap.keySet(), hasItem(CommandSwitch.CLEAR_CACHE));
    }
}
