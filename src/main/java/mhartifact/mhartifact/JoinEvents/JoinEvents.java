package mhartifact.mhartifact.JoinEvents;

import mhartifact.mhartifact.Dungeon.Dungeon;
import mhartifact.mhartifact.Variables.PlayerDataContainer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.UUID;

import static mhartifact.mhartifact.Dungeon.Dungeon.dungeons;
import static mhartifact.mhartifact.Portals.Doors.getDungeonOfPlayer;
import static mhartifact.mhartifact.Variables.VariablesCore.PlayerDataMap;

public class JoinEvents implements Listener {

    //Server Spawn
    public static Location spawn = new Location(Bukkit.getWorld("world"), -120.5, 96.5, -65.5, -90.0f, 0.0f);

    @EventHandler
    //event that gets called when a player joins
    private void PlayerJoin(PlayerJoinEvent e) {
        //sets the UUID of the joined player
        Player player = e.getPlayer();
        UUID playerUUID = player.getUniqueId();
        //checks if the player is already in the variables file
        if (!PlayerDataMap.containsKey(playerUUID)) {
            PlayerDataMap.put(playerUUID, new PlayerDataContainer(playerUUID));
        }
        //sets playerData to the player's info from the map
        PlayerDataContainer PlayerData = PlayerDataMap.get(playerUUID);

        //checks if the player already has a dungeon
        Dungeon dungeon = getDungeonOfPlayer(player);

        if (dungeon != null) {
            //tells the player he will be teleported to his previous dungeon
            player.sendMessage("Your Previous Dungeon Was Still Available");
            player.sendMessage("Sending You To The Dungeon");
            if (dungeon.getCurrentRoom().isCleared()) {
                e.getPlayer().teleport(dungeon.getDungeonSpawn().clone().add(0,20,0));
            }
            else player.teleport(dungeon.getDungeonSpawn());
        }
        //otherwise teleport him to spawn
        else player.teleport(spawn);
    }

    @EventHandler
    private void Respawn(PlayerRespawnEvent e) {
        e.getPlayer().teleport(spawn);
    }
}





















