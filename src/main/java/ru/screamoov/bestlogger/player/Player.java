package ru.screamoov.bestlogger.player;

import ru.screamoov.bestlogger.event.IEvent;

import java.io.File;

public class Player {
    public String playerName;
    public File textFile;

    public Player(org.bukkit.entity.Player player, IEvent event) {
        this.playerName = player.getName();
        File dir = new File("bestLogger/" + playerName + "/");
        if (!dir.exists()) dir.mkdirs();
        textFile = new File("bestLogger/" + playerName + "/" + event.name() + ".txt");
        if (!textFile.exists()) try {
            textFile.createNewFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
