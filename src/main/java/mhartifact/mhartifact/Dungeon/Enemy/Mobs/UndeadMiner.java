package mhartifact.mhartifact.Dungeon.Enemy.Mobs;

import mhartifact.mhartifact.Dungeon.Loot.DungeonLoot;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class UndeadMiner {

    static String name = "&eUndead Miner";
    static EntityType entityType = EntityType.ZOMBIE_VILLAGER;
    static double healthMultiplier = 1.6;
    static double goldDropMultiplier = 1.8;

    public static String getName() {
        return name;
    }
    public static EntityType getEntityType() {
        return entityType;
    }
    public static double getHealthMultiplier() {
        return healthMultiplier;
    }

    public static ArrayList<ItemStack> generateLoot(int level) {

        ArrayList<ItemStack> list = new ArrayList<>();

        //coins
        ItemStack goldNugget = DungeonLoot.goldNugget;
        double rawAmount = (int) Math.floor(0.04*(Math.pow(level, 1.5))+2);
        int amount = (int) Math.floor(rawAmount * goldDropMultiplier);
        goldNugget.setAmount(amount);
        list.add(goldNugget);

        return list;
    }
}
