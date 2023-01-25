package mhartifact.mhartifact.Commands;

import mhartifact.mhartifact.Dungeon.Dungeon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mhartifact.mhartifact.Portals.Doors.ExitDungeon;
import static mhartifact.mhartifact.Portals.Doors.getDungeonOfPlayer;
import static mhartifact.mhartifact.Utils.ChatUtils.format;

public class exitDungeonCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Dungeon dungeon = getDungeonOfPlayer(player);

            if (dungeon != null) {
                ExitDungeon(player);
            }
            else {
                player.sendMessage(format("&cYou Have To Be In A Dungeon To Use This Command"));
            }

            return true;
        }
        return false;
    }
}
