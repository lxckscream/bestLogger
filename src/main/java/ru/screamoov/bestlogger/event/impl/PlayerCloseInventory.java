package ru.screamoov.bestlogger.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.event.IEvent;
import ru.screamoov.bestlogger.player.Player;
import ru.screamoov.bestlogger.utils.ConfigUtils;
import ru.screamoov.bestlogger.utils.DateUtils;
import ru.screamoov.bestlogger.utils.TXTWriter;

public class PlayerCloseInventory implements Listener, IEvent {
    public PlayerCloseInventory() {
        if (ConfigUtils.enabled(this)) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
        }
    }

    @EventHandler
    public void event(InventoryCloseEvent event) {
        Player player = new Player((org.bukkit.entity.Player) event.getPlayer(), this);
        TXTWriter.appendToFile(player.textFile.getAbsolutePath(), DateUtils.getDateAndTime() + "Закрыл инвентарь: " + event.getInventory() + " (Тайтл меню: " + event.getView().getTitle() + ", причина закрытия: " + event.getReason() + ")! [" + player.getData() + "]");
    }

    @Override
    public String name() {
        return "PLAYER_CLOSE_INVENTORY";
    }
}
