package mhartifact.mhartifact.Variables;

import mhartifact.mhartifact.Dungeon.Dungeon;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDataContainer {

    int coins;

    public PlayerDataContainer(UUID PlayerUUID) {
        this(0);
    }

    public PlayerDataContainer(int Coins) {
        this.coins = Coins;
    }
    /*
        Getters And Setters
    */
    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
}
