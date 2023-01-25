package mhartifact.mhartifact.Dungeon.Room;

import mhartifact.mhartifact.Dungeon.Enemy.Enemy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;
import static mhartifact.mhartifact.Utils.ChatUtils.format;

public class Room {
    //room attributes
    boolean isCleared = false;
    boolean isBossRoom;
    double goldReward;
    int roomLevel;

    //enums
    Difficulty difficulty;
    RoomTheme theme;

    //room characteristics
    ArrayList<Enemy> enemies;
    Location spawnBound1, spawnBound2;

    public Room(int roomLevel, Location spawnBound1, Location spawnBound2) {
        //generate the new room

        //sets the level of the room (floor level)
        this.roomLevel = roomLevel;

        //sets the difficulty
        if (roomLevel < 5) difficulty = Difficulty.EASY;
        else if (roomLevel < 20) difficulty = Difficulty.MEDIUM;
        else if (roomLevel < 40) difficulty = Difficulty.HARD;
        else if (roomLevel < 100) difficulty = Difficulty.INSANE;
        else difficulty = Difficulty.IMPOSSIBLE;

        //chooses a random theme
        theme = RoomTheme.values()[new Random().nextInt(RoomTheme.values().length)];
        goldReward = calculateGoldReward();

        //sets the spawnbounds for the mobs and bosses
        this.spawnBound1 = spawnBound1;
        this.spawnBound2 = spawnBound2;

        //makes a new list for all the enemies
        enemies = new ArrayList<>();

        //generates all the enemies
        generateEnemies();
    }

    private double calculateGoldReward() {
        //base reward
        double reward = 5;

        //multiplies based on the difficulty of the room
        switch (difficulty) {
            case EASY:
                reward *= 0.5;
                break;
            case MEDIUM:
                reward *= 1;
                break;
            case HARD:
                reward *= 1.5;
                break;
            case INSANE:
                reward *= 2.5;
                break;
            case IMPOSSIBLE:
                reward *= 4;
                break;
        }

        //defines the multiplier
        double multiplier = pow(roomLevel, 1.5) * 0.04 + 1;
        //applies the multiplier
        reward = reward * multiplier;

        //rounds the number
        DecimalFormat df = new DecimalFormat("#.#");
        reward = Double.parseDouble(df.format(reward));

        return reward;
    }

    public void printInfo(Player p) {
        p.sendMessage(" ");
        p.sendMessage(format("&7== &fRoomLevel: &9" + String.valueOf(roomLevel)  + " &7=="));
        if (difficulty == Difficulty.EASY) p.sendMessage(format("  Difficulty: &aEASY"));
        if (difficulty == Difficulty.MEDIUM) p.sendMessage(format("  Difficulty: &eMEDIUM"));
        if (difficulty == Difficulty.HARD) p.sendMessage(format("  Difficulty: &cHARD"));
        if (difficulty == Difficulty.INSANE) p.sendMessage(format("  Difficulty: &5INSANE"));
        if (difficulty == Difficulty.IMPOSSIBLE) p.sendMessage(format("  Difficulty: &4IMPOSSIBLE"));
        p.sendMessage(format("  Theme: &d" + String.valueOf(theme)));
        p.sendMessage(format("  GoldReward: &6" + String.valueOf(goldReward)));
        p.sendMessage(format("&7================"));
        p.sendMessage(" ");
    } // TEMPORARY

    private void generateEnemies() {
        //generates a new random object
        Random rand = new Random();

        //creates the bound variables
        int bound = 0;
        int min = 1;
        //sets the minimum and maximum amount of mobs that can spawn
        // min = min  ||  max = min + bound
        switch (difficulty) {
            case EASY:
                bound = 2;
                min = 2;
                break;
            case MEDIUM:
                bound = 3;
                min = 3;
                break;
            case HARD:
                bound = 5;
                min = 4;
                break;
            case INSANE:
                bound = 8;
                min = 7;
                break;
            case IMPOSSIBLE:
                bound = 15;
                min = 10;
                break;
        }

        //generates the enemy amount based on the bounds
        int enemyAmount = rand.nextInt(bound) + min;

        //generates all the enemies
        for (int i = 0; i < enemyAmount; i++) {
            //make the new enemy
            Enemy enemy = new Enemy(difficulty, theme, roomLevel, spawnBound1, spawnBound2);

            //add the enemy to the list
            enemies.add(enemy);
        }
    }

    /*
        getters and setters
    */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    public boolean isCleared() {
        return isCleared;
    }
    public void setCleared(boolean cleared) {
        isCleared = cleared;
    }
    public boolean isBossRoom() {
        return isBossRoom;
    }
    public void setBossRoom(boolean bossRoom) {
        isBossRoom = bossRoom;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public RoomTheme getTheme() {
        return theme;
    }
    public void setTheme(RoomTheme theme) {
        this.theme = theme;
    }
    public double getGoldReward() {
        return goldReward;
    }
    public void setGoldReward(double goldReward) {
        this.goldReward = goldReward;
    }
    public int getRoomLevel() {
        return roomLevel;
    }
    public void setRoomLevel(int roomLevel) {
        this.roomLevel = roomLevel;
    }
    public Location getSpawnBound1() {
        return spawnBound1;
    }
    public void setSpawnBound1(Location spawnBound1) {
        this.spawnBound1 = spawnBound1;
    }
    public Location getSpawnBound2() {
        return spawnBound2;
    }
    public void setSpawnBound2(Location spawnBound2) {
        this.spawnBound2 = spawnBound2;
    }
}
