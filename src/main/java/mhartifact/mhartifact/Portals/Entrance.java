package mhartifact.mhartifact.Portals;

import mhartifact.mhartifact.Dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

import static mhartifact.mhartifact.Dungeon.Dungeon.dungeons;
import static mhartifact.mhartifact.Portals.Doors.getDungeonOfPlayer;

public class Entrance implements Listener {

    @EventHandler
    private void PortalEnter(PlayerMoveEvent e) {
        Location pLoc = e.getPlayer().getLocation();
        Material PortalDetectBlock = pLoc.subtract(0.0,1.0,0.0).getBlock().getType();
        Material PortalBlock = pLoc.subtract(0.0,1.0,0.0).getBlock().getType();

        //checks if the player steps on black concrete and what the block below it is
        if (PortalDetectBlock.equals(Material.BLACK_CONCRETE) && PortalBlock.equals(Material.GOLD_BLOCK)) {
            EnterEntrancePortal(e.getPlayer());
        }
    }

    private void EnterEntrancePortal(Player p) {
        Dungeon dungeon = getDungeonOfPlayer(p);
        if (dungeon != null) {
            p.teleport(dungeon.getDungeonSpawn());
        } else {
            //checks if there is an empty spot in the current list
            int emptySpot = -1;
            for (Dungeon i : dungeons) {
                if (!(i.isUsed())) {
                    emptySpot = dungeons.indexOf(i);
                    break;
                }
            }
            if (emptySpot != -1) {
               dungeons.set(emptySpot, new Dungeon(p, emptySpot));
            } else {
                dungeons.add(new Dungeon(p, dungeons.size()));
            }

            dungeon = getDungeonOfPlayer(p);

            p.sendMessage("Creating a new Dungeon");
        }
        TeleportPlayerToDungeon(p, dungeon);
    }

    private void TeleportPlayerToDungeon(Player p, Dungeon dungeon) {
        p.teleport(dungeon.getDungeonSpawn());
    }
}




















