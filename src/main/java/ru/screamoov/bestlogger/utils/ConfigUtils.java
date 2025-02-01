package ru.screamoov.bestlogger.utils;

import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;

public class ConfigUtils {
    public static boolean enabled(IEvent event) {
        for (String key : Main.getInstance().getConfig().getStringList("logging")) {
            if (key.equalsIgnoreCase(event.name())) {
                return true;
            }
        }
        return false;
    }
}
