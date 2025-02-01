package ru.screamoov.bestlogger;

import org.bukkit.plugin.java.JavaPlugin;
import ru.screamoov.bestlogger.managers.EventsManager;

public final class Main extends JavaPlugin {
    private static Main instance;
    private static EventsManager eventsManager;

    @Override
    public void onEnable() {
        instance = this;
        eventsManager = new EventsManager();

    }

    public static EventsManager getEventsManager() {
        return eventsManager;
    }

    public static Main getInstance() {
        return instance;
    }
}
