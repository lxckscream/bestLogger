package ru.screamoov.bestlogger.managers;

import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;
import ru.screamoov.bestlogger.event.impl.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class EventsManager {
    public List<IEvent> eventList = new ArrayList<>();

    public EventsManager() {
        for (String key : Main.getInstance().getConfig().getStringList("logging")) {
            switch (key.toUpperCase()) {
                case "PLAYER_JOIN_EVENT":
                    register(new PlayerJoinEvent());
            }
        }
    }

    private void register(IEvent event) {
        eventList.add(event);
    }
}
