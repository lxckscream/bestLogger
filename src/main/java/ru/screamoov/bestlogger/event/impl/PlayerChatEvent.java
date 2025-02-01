package ru.screamoov.bestlogger.event.impl;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;
import ru.screamoov.bestlogger.player.Player;
import ru.screamoov.bestlogger.utils.ConfigUtils;
import ru.screamoov.bestlogger.utils.DateUtils;
import ru.screamoov.bestlogger.utils.TXTWriter;

public class PlayerChatEvent implements Listener, IEvent {
    public PlayerChatEvent() {
        if (ConfigUtils.enabled(this)) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
        }
    }

    @EventHandler
    public void event(AsyncPlayerChatEvent event) {
        Player player = new Player(event.getPlayer(), this);
        TXTWriter.appendToFile(player.textFile.getAbsolutePath(), DateUtils.getDateAndTime() + "Написал в чат: " + event.getMessage() + ")! [" + player.getData() + "]");
    }

    @Override
    public String name() {
        return "PLAYER_CHAT_EVENT";
    }
}
