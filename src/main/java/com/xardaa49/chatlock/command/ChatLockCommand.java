/***
 *      .oooooo.   oooo                      .   ooooo                            oooo
 *     d8P'  `Y8b  `888                    .o8   `888'                            `888
 *    888           888 .oo.    .oooo.   .o888oo  888          .ooooo.   .ooooo.   888  oooo
 *    888           888P"Y88b  `P  )88b    888    888         d88' `88b d88' `"Y8  888 .8P'
 *    888           888   888   .oP"888    888    888         888   888 888        888888.
 *    `88b    ooo   888   888  d8(  888    888 .  888       o 888   888 888   .o8  888 `88b.
 *     `Y8bood8P'  o888o o888o `Y888""8o   "888" o888ooooood8 `Y8bod8P' `Y8bod8P' o888o o888o
 *
 *
 *    @name ChatLock
 *    @author xArdaa49
 *    @version 1.0.0
 */
package com.xardaa49.chatlock.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

import cn.nukkit.utils.TextFormat;
import com.xardaa49.chatlock.Main;
import org.w3c.dom.Text;

public class ChatLockCommand extends Command {
    private final Main plugin;

    /**
     * Constructor for the ChatLockCommand.
     *
     * @param plugin     The main plugin instance.
     * @param name       The command name.
     * @param desc       The command description.
     * @param usage      The usage message for the command.
     * @param permission The required permission to use this command.
     */
    public ChatLockCommand(Main plugin, String name, String desc, String usage, String permission) {
        super(name, desc, usage);
        this.setPermission(permission);
        this.plugin = plugin;
    }

    /**
     * Executes the command to toggle chat lock.
     *
     * @param sender       The sender of the command.
     * @param commandLabel The label of the command.
     * @param args         The command arguments.
     * @return true if the command executed successfully, false otherwise.
     */
    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!testPermission(sender)) return false;

        boolean newState = !plugin.isChatLocked();
        plugin.setChatLocked(newState);

        if (newState) {
            plugin.getServer().broadcastMessage(TextFormat.DARK_GRAY + "\n» " + TextFormat.RED + "Chat has been locked by " + TextFormat.DARK_RED + "'Administrator' " + TextFormat.RED + "!");
        } else {
            plugin.getServer().broadcastMessage(TextFormat.DARK_GRAY + "\n» " + TextFormat.GREEN + "Chat lock has been lifted!");
        }

        return true;
    }
}
