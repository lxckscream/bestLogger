package ru.screamoov.bestlogger.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;
import ru.screamoov.bestlogger.player.Player;
import ru.screamoov.bestlogger.utils.ConfigUtils;
import ru.screamoov.bestlogger.utils.DateUtils;
import ru.screamoov.bestlogger.utils.TXTWriter;

public class PlayerCommandEvent implements Listener, IEvent {
    public PlayerCommandEvent() {
        if (ConfigUtils.enabled(this)) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
        }
    }

    @EventHandler
    public void event(PlayerCommandPreprocessEvent event) {
        Player player = new Player(event.getPlayer(), this);
        TXTWriter.appendToFile(player.textFile.getAbsolutePath(), DateUtils.getDateAndTime() + "Написал команду: " + event.getMessage() + ")! [" + player.getData() + "]");
    }

    @Override
    public String name() {
        return "PLAYER_COMMAND_EVENT";
    }
}
