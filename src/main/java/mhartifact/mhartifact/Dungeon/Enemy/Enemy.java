package mhartifact.mhartifact.Dungeon.Enemy;

import mhartifact.mhartifact.Dungeon.Enemy.Mobs.*;
import mhartifact.mhartifact.Dungeon.Room.Difficulty;
import mhartifact.mhartifact.Dungeon.Room.RoomTheme;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;
import static mhartifact.mhartifact.Utils.ChatUtils.format;

public class Enemy {

    //Attributes
    String name;
    int level;
    int health;
    MobType mobType;

    //misc
    Location spawnLocation;
    EntityType entityType;
    ArrayList<ItemStack> loot;
    LivingEntity entity;


    public Enemy(Difficulty difficulty, RoomTheme theme, int roomLevel, Location b1, Location b2) {

        mobType = generateMobType(theme);
        spawnLocation = generateRandomLocation(b1,b2);

        generateAttributes(mobType, difficulty, roomLevel);

        //spawn the mob in the world
        entity = (LivingEntity) Bukkit.getWorld("world").spawnEntity(spawnLocation, entityType);

        //set the attributes of the mob
        entity.setMaxHealth(health);
        entity.setHealth(health);
        entity.setCustomName(format(name + " &7[&6" + level + "&7]"));
    }

    private void generateAttributes(MobType mobType, Difficulty difficulty, int roomLevel) {
        //temp variables
        double rawHealth;


        if (mobType == MobType.FrozenSkeleton) {
            entityType = FrozenSkeleton.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level / 20), 2.5) + 20;
            health = (int) Math.round(rawHealth * FrozenSkeleton.getHealthMultiplier());
            name = FrozenSkeleton.getName();
            loot = FrozenSkeleton.generateLoot(level);
        }

        else if (mobType == MobType.DriedZombie) {
            entityType = DriedZombie.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * DriedZombie.getHealthMultiplier());
            name = DriedZombie.getName();
            loot = DriedZombie.generateLoot(level);
        }

        else if (mobType == MobType.Tarantula) {
            entityType = Tarantula.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * Tarantula.getHealthMultiplier());
            name = Tarantula.getName();
            loot = Tarantula.generateLoot(level);
        }

        else if (mobType == MobType.TribeMember) {
            entityType = TribeMember.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * TribeMember.getHealthMultiplier());
            name = TribeMember.getName();
            loot = TribeMember.generateLoot(level);
        }

        else if (mobType == MobType.BabySpider) {
            entityType = BabySpider.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * BabySpider.getHealthMultiplier());
            name = BabySpider.getName();
            loot = BabySpider.generateLoot(level);
        }

        else if (mobType == MobType.UndeadMiner) {
            entityType = UndeadMiner.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * UndeadMiner.getHealthMultiplier());
            name = UndeadMiner.getName();
            loot = UndeadMiner.generateLoot(level);
        }

        else if (mobType == MobType.Drowned) {
            entityType = Drowned.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * Drowned.getHealthMultiplier());
            name = Drowned.getName();
            loot = Drowned.generateLoot(level);
        }

        else if (mobType == MobType.Pirate) {
            entityType = Pirate.getEntityType();
            level = calculateLevel(roomLevel, difficulty);
            rawHealth = pow((level/20), 2.5)+20;
            health = (int) Math.round(rawHealth * Pirate.getHealthMultiplier());
            name = Pirate.getName();
            loot = Pirate.generateLoot(level);
        }
    }

    private MobType generateMobType(RoomTheme theme) {
        switch (theme) {
            case FROST:
                return MobType.FrozenSkeleton;
            case DESERT:
                return MobType.DriedZombie;
            case FOREST:
                return MobType.Tarantula;
            case JUNGLE:
                return MobType.TribeMember;
            case CAVE:
                return MobType.BabySpider;
            case MINE:
                return MobType.UndeadMiner;
            case OCEAN:
                return MobType.Drowned;
            case PIRATES:
                return MobType.Pirate;
        }
        return null;
    }

    public static Location generateRandomLocation(Location b1, Location b2) {
        Random r = new Random();

        double x, y, z;
        double low,high;

        low = b1.getX();
        high = b2.getX();
        x = r.nextDouble()*(high-low) + low;

        low = b1.getY();
        high = b2.getY();
        y = r.nextDouble()*(high-low) + low;

        low = b1.getZ();
        high = b2.getZ();
        z = r.nextDouble()*(high-low) + low;

        Location returnLoc = new Location(Bukkit.getWorld("world"),x,y,z);
        return returnLoc;
    }

    private int calculateLevel(int roomLevel, Difficulty difficulty) {
        double tempLevel = pow(roomLevel,0.8) * 1.3;

        switch (difficulty) {
            case EASY:
                tempLevel *= 0.2;
                break;
            case MEDIUM:
                tempLevel *= 0.3;
                break;
            case HARD:
                tempLevel *= 0.5;
                break;
            case INSANE:
                tempLevel *= 0.7;
                break;
            case IMPOSSIBLE:
                tempLevel *= 1;
                break;
        }

        return (int) Math.floor(tempLevel);
    }

    /*
        getters and setters
    */

    public MobType getMobType() {
        return mobType;
    }
    public Location getSpawnLocation() {
        return spawnLocation;
    }
    public EntityType getEntityType() {
        return entityType;
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public ArrayList<ItemStack> getLoot() {
        return loot;
    }
    public LivingEntity getEntity() {
        return entity;
    }
}
