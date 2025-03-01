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
package com.xardaa49.chatlock;

import cn.nukkit.plugin.PluginBase;

import com.xardaa49.chatlock.command.ChatLockCommand;
import com.xardaa49.chatlock.listener.ChatLockListener;
import com.xardaa49.chatlock.utils.PermissionNames;

import java.util.Arrays;

public class Main extends PluginBase {
    private boolean isChatLocked = false;

    /**
     * Called when the plugin is loaded.
     * Loads the default configuration and retrieves the chat lock state.
     */
    @Override
    public void onLoad() {
        saveDefaultConfig();
        isChatLocked = getConfig().getBoolean("chat-locked", false);
    }

    /**
     * Called when the plugin is enabled.
     * Registers the chat lock command.
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(
                new ChatLockListener(this),
                this
        );

        getServer().getCommandMap().register(
                getName(),
                new ChatLockCommand(
                        this,
                        "cl",
                        "Locks or unlocks the chat.",
                        "/cl",
                        PermissionNames.COMMAND_USE
                )
        );
    }

    /**
     * Gets the current chat lock state.
     *
     * @return true if chat is locked, false otherwise.
     */
    public boolean isChatLocked() {
        return isChatLocked;
    }

    /**
     * Sets the chat lock state.
     *
     * @param chatLocked true to lock the chat, false to unlock it.
     */
    public void setChatLocked(boolean chatLocked) {
        isChatLocked = chatLocked;
    }

    /**
     * Called when the plugin is disabled.
     * Saves the chat lock state to the configuration file.
     */
    @Override
    public void onDisable() {
        getConfig().set("chat-locked", isChatLocked);
        saveConfig();
    }
}
