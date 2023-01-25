package mhartifact.mhartifact.Dungeon.Player;

import mhartifact.mhartifact.Dungeon.Dungeon;
import mhartifact.mhartifact.Dungeon.Enemy.Enemy;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static mhartifact.mhartifact.Dungeon.Loot.DungeonLoot.gold;
import static mhartifact.mhartifact.Dungeon.Loot.DungeonLoot.goldNugget;
import static mhartifact.mhartifact.JoinEvents.JoinEvents.spawn;
import static mhartifact.mhartifact.Portals.Doors.ExitDungeon;
import static mhartifact.mhartifact.Portals.Doors.getDungeonOfPlayer;

public class PlayerEnemyEvents implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        //checks if the damager is an arrow
        if (e.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getDamager();
            Entity shooter = (Entity) arrow.getShooter();
            Entity defender = e.getEntity();
            //checks if a player is shooting another player
            if (shooter instanceof Player) {
                if (defender instanceof Player) {
                    //if so it cancels the event
                    e.setCancelled(true);
                }
            }
            //if the defender is not a player it cancels the event
            else if (!(defender instanceof Player)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        //clears all standard minecraft drops
        e.getDrops().clear();
        //if the entity that died is a player -> remove the player's dungeon and teleport him to spawn
        if (e.getEntity() instanceof Player) {
            ExitDungeon((Player) e.getEntity());
            e.getEntity().teleport(spawn);
        }
        if (e.getEntity().getKiller() != null) {
            //sets 'p' to the player that killed the mob
            Player p = e.getEntity().getKiller();
            //sets 'm' to the entity that got killed by 'p'
            Entity m = e.getEntity();

            //sets 'dungeon' to the dungeon the player is in (null if he has no dungeon)
            Dungeon dungeon = getDungeonOfPlayer(p);
            //if the player has a dungeon
            if (dungeon != null) {
                //makes a variable for the mob that should be removed from the list
                //since you can't remove items while looping through an arraylist
                Enemy toBeRemoved = null;
                //checks if the damaged mob is in the mobs list
                ArrayList<Enemy> enemyList = dungeon.getCurrentRoom().getEnemies();
                for (Enemy i : enemyList) {
                    if (m.getUniqueId() == i.getEntity().getUniqueId()) {

                        //adds the loot to a list
                        if (!(i.getLoot().isEmpty())) {
                            ArrayList<ItemStack> dungeonLoot = dungeon.getDungeonLoot().getDungeonLoot();
                            for (ItemStack lootItem : i.getLoot()) {
                                String lootItemName = lootItem.getItemMeta().getDisplayName();

                                ArrayList<ItemStack> itemsToRemove = new ArrayList<>();

                                //checks if the current item in the loop is gold
                                if (lootItemName.equals(goldNugget.getItemMeta().getDisplayName())) {
                                    dungeon.getDungeonLoot().addGold(lootItem.getAmount());
                                    break;
                                }
                                else if (!(dungeonLoot.isEmpty())) {
                                    //loops through all loot items of the mob to check for duplicates
                                    for (ItemStack listItem : dungeonLoot) {

                                        String listItemName = listItem.getItemMeta().getDisplayName();

                                        //checks if the current item in the loop is already
                                        //in the dungeonloot list -> removes the old one and adds
                                        //the same item with a different amount
                                        if (listItemName.equals(lootItemName)) {
                                            int totalAmount = listItem.getAmount() + lootItem.getAmount();
                                            itemsToRemove.add(listItem);

                                            ItemStack temp = lootItem.clone();
                                            temp.setAmount(totalAmount);
                                            dungeonLoot.add(temp);
                                            break;
                                        }
                                    }
                                }
                                //otherwise it adds the mobs loot item to the dungeon loot list
                                else dungeonLoot.add(lootItem);
                                //removes all the items that should be removed
                                if (!(itemsToRemove.isEmpty())) dungeonLoot.removeAll(itemsToRemove);
                            }
                        }
                        toBeRemoved = i;
                        break;
                    }
                }
                enemyList.remove(toBeRemoved);

                if (enemyList.isEmpty()) {
                    dungeon.getCurrentRoom().setCleared(true);
                    p.teleport(dungeon.getDungeonSpawn().clone().add(0,20,0));
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        e.setRespawnLocation(spawn);
    }
}












