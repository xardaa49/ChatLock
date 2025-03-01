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
package com.xardaa49.chatlock.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.utils.TextFormat;

import com.xardaa49.chatlock.Main;
import com.xardaa49.chatlock.utils.PermissionNames;

public class ChatLockListener implements Listener {
    private final Main plugin;

    /**
     * Constructor for the ChatLockListener.
     *
     * @param plugin The main plugin instance.
     */
    public ChatLockListener(Main plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles the PlayerChatEvent to block messages when chat is locked.
     *
     * @param event The PlayerChatEvent instance.
     */
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        if (plugin.isChatLocked() && !event.getPlayer().hasPermission(PermissionNames.BYPASS_USE)) {
            event.getPlayer().sendMessage(TextFormat.DARK_GRAY + "» " + TextFormat.RED + "Chat is locked, it will remain locked until unlocked by admins!");
            event.setCancelled(true);
        }
    }
}
