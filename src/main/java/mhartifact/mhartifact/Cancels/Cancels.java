package mhartifact.mhartifact.Cancels;

import mhartifact.mhartifact.Dungeon.Dungeon;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import static mhartifact.mhartifact.Portals.Doors.getDungeonOfPlayer;

public class Cancels implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if (player.getGameMode().equals(GameMode.SURVIVAL) ||
            player.getGameMode().equals(GameMode.ADVENTURE)) e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();

        if (player.getGameMode().equals(GameMode.SURVIVAL) ||
            player.getGameMode().equals(GameMode.ADVENTURE)) e.setCancelled(true);
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();

        if (e.getItem().equals(Material.HONEY_BOTTLE)) e.setCancelled(true);
    }

    @EventHandler
    public void onHungerMeterChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHealthRegain(EntityRegainHealthEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            Dungeon dungeon = getDungeonOfPlayer(player);

            if (dungeon != null) {
                if (!(dungeon.getCurrentRoom().isCleared())) {
                    e.setCancelled(true);
                }
                else {
                    e.setAmount(5);
                }
            }
        }
        else {
            e.setCancelled(true);
        }
    }
}
