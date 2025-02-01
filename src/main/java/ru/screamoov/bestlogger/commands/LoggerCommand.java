package ru.screamoov.bestlogger.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.screamoov.bestlogger.Main;
import ru.screamoov.bestlogger.managers.EventsManager;

public class LoggerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.hasPermission("bestlogger.use")) {
            if (strings.length == 0) {
                commandSender.sendMessage(ChatColor.RED + "/logger reload");
            } else {
                if (strings[0].equalsIgnoreCase("reload")) {
                    Main.getInstance().reloadConfig();
                    Main.setEventsManager(new EventsManager());
                    commandSender.sendMessage(ChatColor.GREEN + "Перезагружено!");
                }
            }
        }
        return true;
    }
}
