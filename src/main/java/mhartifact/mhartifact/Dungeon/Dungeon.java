package mhartifact.mhartifact.Dungeon;

import mhartifact.mhartifact.Dungeon.Loot.DungeonLoot;
import mhartifact.mhartifact.Dungeon.Room.Room;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Dungeon {

    public static ArrayList<Dungeon> dungeons = new ArrayList<>();

    //Dungeon info
    boolean isUsed;
    Location dungeonSpawn;
    ArrayList<Room> dungeonRooms;
    Room currentRoom;
    Location spawnBound1, spawnBound2;

    //Player info
    Player dungeonOwner;
    ArrayList<Player> playersInDungeon;
    DungeonLoot dungeonLoot;

    public Dungeon() {
        this.isUsed = false;
    }

    public Dungeon(Player p, int indexPlaced) {
        //indicates that the dungeon is used
        this.isUsed = true;

        //sets the dungeon spawn
        dungeonSpawn = new Location(p.getWorld(), -105.5, 96.5, -65.5 + (indexPlaced * 30), -90.0f, 0.0f);

        //calculates the dungeon bounds
        spawnBound1 = dungeonSpawn.clone().add(10, 0, -5);
        spawnBound2 = dungeonSpawn.clone().add(5,0,5);

        //makes a new array that contains all the rooms
        dungeonRooms = new ArrayList<>();
        dungeonRooms.add(new Room((dungeonRooms.size() + 1), spawnBound1, spawnBound2));

        //sets the current room
        this.currentRoom = dungeonRooms.get(dungeonRooms.size() - 1);

        //sets the player info for the dungeon
        this.dungeonOwner = p;
        this.dungeonLoot = new DungeonLoot();
        this.playersInDungeon = new ArrayList<>();
        this.playersInDungeon.add(dungeonOwner);
    }



    /*
        getters and setters
    */

    public static ArrayList<Dungeon> getDungeons() {
        return dungeons;
    }
    public Location getDungeonSpawn() {
        return dungeonSpawn;
    }
    public void setDungeonSpawn(Location dungeonSpawn) {
        this.dungeonSpawn = dungeonSpawn;
        //recalculates the dungeon bounds
        this.spawnBound1 = dungeonSpawn.clone().add(8, 0, -4);
        this.spawnBound2 = dungeonSpawn.clone().add(3,0,4);
    }
    public ArrayList<Room> getDungeonRooms() {
        return dungeonRooms;
    }
    public void setDungeonRooms(ArrayList<Room> dungeonRooms) {
        this.dungeonRooms = dungeonRooms;
    }
    public Player getDungeonOwner() {
        return dungeonOwner;
    }
    public void setDungeonOwner(Player dungeonOwner) {
        this.dungeonOwner = dungeonOwner;
    }
    public ArrayList<Player> getPlayersInDungeon() {
        return playersInDungeon;
    }
    public void setPlayersInDungeon(ArrayList<Player> playersInDungeon) {
        this.playersInDungeon = playersInDungeon;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public Location getSpawnBound1() {
        return spawnBound1;
    }
    public Location getSpawnBound2() {
        return spawnBound2;
    }
    public boolean isUsed() {
        return isUsed;
    }
    public void setUsed(boolean used) {
        isUsed = used;
    }
    public DungeonLoot getDungeonLoot() {
        return dungeonLoot;
    }
}
