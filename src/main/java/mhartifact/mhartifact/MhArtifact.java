package mhartifact.mhartifact;

import mhartifact.mhartifact.Cancels.Cancels;
import mhartifact.mhartifact.Commands.exitDungeonCommand;
import mhartifact.mhartifact.Dungeon.Dungeon;
import mhartifact.mhartifact.Dungeon.Loot.DungeonLoot;
import mhartifact.mhartifact.Dungeon.Player.PlayerEnemyEvents;
import mhartifact.mhartifact.JoinEvents.JoinEvents;
import mhartifact.mhartifact.Portals.Doors;
import mhartifact.mhartifact.Portals.Entrance;
import mhartifact.mhartifact.Variables.VariablesCore;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;

import static mhartifact.mhartifact.Dungeon.Dungeon.dungeons;
import static mhartifact.mhartifact.Dungeon.Loot.DungeonLoot.initLootItems;
import static mhartifact.mhartifact.JoinEvents.JoinEvents.spawn;

public final class MhArtifact extends JavaPlugin {

    @Override
    public void onEnable() {
        //loading in all variables
        String Path = getDataFolder().getAbsoluteFile().toString();
        VariablesCore.LoadPlayerVariables(Path);
        //initializes the loot items
        initLootItems();

        this.getLogger().info("Plugin Enabled");

        ArrayList<Listener> events = new ArrayList<>();
        //list of events
        events.add(new Entrance());
        events.add(new Doors());
        events.add(new JoinEvents());
        events.add(new PlayerEnemyEvents());
        events.add(new DungeonLoot());
        events.add(new Cancels());

        for (Listener l : events){
            getServer().getPluginManager().registerEvents(l, this);
        }

        this.getCommand("exitDungeon").setExecutor(new exitDungeonCommand());
    }

    @Override
    public void onDisable() {
        //saving all variables
        String Path = getDataFolder().getAbsoluteFile().toString();
        try { VariablesCore.SavePlayerVariables(Path);
        } catch (IOException e) { throw new RuntimeException(e);}

        //Teleports all players that where in a dungeon to spawn
        //also gives the players the loot they gained
        for (Dungeon dungeon : dungeons) {
            if (dungeon.isUsed() && !(dungeon.getPlayersInDungeon().isEmpty())) {
                for (Player player : dungeon.getPlayersInDungeon()) {
                    for (ItemStack items : dungeon.getDungeonLoot().getDungeonLoot()) {
                        player.getInventory().addItem(items);
                    }

                    player.teleport(spawn);
                }
            }
        }

        this.getLogger().info("Plugin Disabled");
    }
}
