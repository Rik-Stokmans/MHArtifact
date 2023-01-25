package mhartifact.mhartifact.Variables;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VariablesCore {

    public static YamlConfiguration File;

    public static HashMap<UUID, PlayerDataContainer> PlayerDataMap = new HashMap<>();

    public static void LoadPlayerVariables(String Path) {
        File = YamlConfiguration.loadConfiguration(new File(Path, "Variables/PlayerData.yml"));

        if (File.contains("data")) {
            File.getConfigurationSection("data.coins").getKeys(false).forEach(key -> {
                int coins = File.getInt("data.coins" + key);
                PlayerDataMap.put(UUID.fromString(key), new PlayerDataContainer(coins));
            });
        }
    }

    public static void SavePlayerVariables(String Path) throws IOException {

        for (Map.Entry<UUID, PlayerDataContainer> value : PlayerDataMap.entrySet()) {
            File.set("data.coins." + value.getKey(), value.getValue().getCoins());
        }
        saveFile(File,"Variables/PlayerData.yml",Path);
    }

    public static void saveFile(YamlConfiguration file, String s, String Path) throws IOException {
        file.save(new File(Path, s));
    }
}
