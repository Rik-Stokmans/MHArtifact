package mhartifact.mhartifact.Portals;

import mhartifact.mhartifact.Dungeon.Dungeon;
import mhartifact.mhartifact.Dungeon.Enemy.Enemy;
import mhartifact.mhartifact.Dungeon.Room.Room;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static mhartifact.mhartifact.Dungeon.Dungeon.dungeons;
import static mhartifact.mhartifact.JoinEvents.JoinEvents.spawn;
import static mhartifact.mhartifact.Utils.ChatUtils.format;

public class Doors implements Listener {

    private static HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    private void PortalEnter(PlayerMoveEvent e) {

        UUID playerUUID = e.getPlayer().getUniqueId();

        //Cooldown 250 milliseconds
        if (cooldown.containsKey(playerUUID)) {
            Long last = cooldown.get(playerUUID);
            Long now = System.currentTimeMillis();
            if (now - last > 250) {
                cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());

                Player p = e.getPlayer();
                Dungeon dungeon = getDungeonOfPlayer(p);
                //checks if the player already has a dungeon
                Location pLoc = e.getPlayer().getLocation();
                Material PortalDetectBlock = pLoc.subtract(0.0, 1.0, 0.0).getBlock().getType();
                Material PortalBlock = pLoc.subtract(0.0, 1.0, 0.0).getBlock().getType();
                if (dungeon != null) {
                    if (PortalDetectBlock.equals(Material.BLACK_CONCRETE)) {
                        //all portals
                        if (PortalBlock.equals(Material.LIME_CONCRETE)) NextLevel(e.getPlayer());
                        else if (PortalBlock.equals(Material.YELLOW_CONCRETE)) EnterShop(e.getPlayer());
                        else if (PortalBlock.equals(Material.RED_CONCRETE)) ExitDungeon(e.getPlayer());
                    }
                } else if (PortalDetectBlock.equals(Material.BLACK_CONCRETE)) {
                    p.teleport(spawn);
                }
            }
        }
        else {
            cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
        }
    }

    public static void ExitDungeon(Player p) {
        Dungeon dungeon = getDungeonOfPlayer(p);
        if (dungeon != null) {

            //removes all enemies
            ArrayList<Enemy> enemies = dungeon.getCurrentRoom().getEnemies();
            if (!(enemies.isEmpty())) for (Enemy i : enemies) i.getEntity().remove();

            int index = dungeons.indexOf(dungeon);
            dungeons.set(index, new Dungeon());

            p.teleport(spawn);

            p.sendMessage("Exited The Dungeon");
        }
    }

    private void EnterShop(Player p) {
        // METHOD TO GENERATE THE SHOP ROOM

        // METHOD TO TELEPORT THE PLAYER TO THE GENERATED SHOP

        p.sendMessage(format("&cShop Is Comming Soon... Sit Tight"));
    }

    private void NextLevel(Player p) {
        //gets some variables
        Dungeon dungeon = getDungeonOfPlayer(p);
        if (dungeon != null) {
            ArrayList<Room> dungeonRooms = dungeon.getDungeonRooms();
            //generates the new room
            Room newRoom = new Room(dungeonRooms.size() + 1, dungeon.getSpawnBound1(), dungeon.getSpawnBound2());
            dungeonRooms.add(newRoom);
            //sets the current room
            dungeon.setCurrentRoom(newRoom);

            //temporary
            p.sendMessage("Entered Room:");
            dungeon.getCurrentRoom().printInfo(p);

            //teleports the player to the room
            p.teleport(dungeon.getDungeonSpawn());

            p.sendMessage("Entered The Next Room");
        }
    }

    public static Dungeon getDungeonOfPlayer(Player player) {
        if (!(dungeons.isEmpty())) {
            for (Dungeon i : dungeons) {
                if (i.isUsed()) {
                    if (i.getDungeonOwner().getUniqueId() == player.getUniqueId()) {
                        return i;
                    }
                }
            }
        }
        return null;
    }
}














