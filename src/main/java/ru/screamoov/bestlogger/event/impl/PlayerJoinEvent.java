package ru.screamoov.bestlogger.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;
import ru.screamoov.bestlogger.player.Player;
import ru.screamoov.bestlogger.utils.ConfigUtils;
import ru.screamoov.bestlogger.utils.DateUtils;
import ru.screamoov.bestlogger.utils.TXTWriter;

public class PlayerJoinEvent implements Listener, IEvent {
    public PlayerJoinEvent() {
        if (ConfigUtils.enabled(this)) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
        }
    }

    @EventHandler
    public void event(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = new Player(event.getPlayer(), this);
        TXTWriter.appendToFile(player.textFile.getAbsolutePath(), DateUtils.getDateAndTime() + "Зашёл на сервер!");
    }

    @Override
    public String name() {
        return "PLAYER_JOIN_EVENT";
    }
}
