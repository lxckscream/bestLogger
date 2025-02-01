package ru.screamoov.bestlogger.managers;

import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;
import ru.screamoov.bestlogger.event.impl.*;

import java.util.ArrayList;
import java.util.List;

public class EventsManager {
    public List<IEvent> eventList = new ArrayList<>();

    public EventsManager() {
        for (String key : Main.getInstance().getConfig().getStringList("logging")) {
            switch (key.toUpperCase()) {
                case "PLAYER_JOIN_EVENT":
                    register(new PlayerJoinEvent());
                case "PLAYER_QUIT_EVENT":
                    register(new PlayerQuitEvent());
                case "PLAYER_CLOSE_INVENTORY":
                    register(new PlayerCloseInventory());
                case "PLAYER_CHAT_EVENT":
                    register(new PlayerChatEvent());
                case "PLAYER_COMMAND_EVENT":
                    register(new PlayerCommandEvent());

            }
        }
    }

    private void register(IEvent event) {
        eventList.add(event);
    }
}
