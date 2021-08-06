package md.rainlox.weaponryPlugin.weaponry;

import md.rainlox.weaponryPlugin.Main;
import md.rainlox.weaponryPlugin.factories.WeaponFactory;
import md.rainlox.weaponryPlugin.types.Status;
import md.rainlox.weaponryPlugin.utils.Tools;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class Loading {

    private final Main main;
    private final WeaponFactory weaponFactory;
    private final Tools tools;

    public Loading(Main plugin, WeaponFactory wF) {
        main = plugin;
        weaponFactory = new WeaponFactory(plugin);
        tools = new Tools(plugin, wF);
    }

    public void unLoadRifle(Player p, ItemStack item, int level) {
        PlayerInventory playerInventory = p.getInventory();
        ItemStack newItem = weaponFactory.createRifle(level, new Status(false));
        tools.deleteItem(item);
        if (playerInventory.getItemInOffHand().getType() == Material.AIR) {
            playerInventory.setItemInOffHand(newItem);
        } else {
            for (int i = 0; i < 36  ; i++) {
                if (playerInventory.getItem(i) == null) {
                    playerInventory.setItem(i, newItem);
                    return;
                }
            }
            playerInventory.setItemInMainHand(newItem);
        }
    }

    public void unLoadPistol(Player p, ItemStack item, int level) {
        PlayerInventory playerInventory = p.getInventory();
        ItemStack newItem = weaponFactory.createPistol(level, new Status(false));
        tools.deleteItem(item);
        if (playerInventory.getItemInOffHand().getType() == Material.AIR) {
            playerInventory.setItemInOffHand(newItem);
        } else {
            for (int i = 0; i < 36  ; i++) {
                if (playerInventory.getItem(i) == null) {
                    playerInventory.setItem(i, newItem);
                    return;
                }
            }
            playerInventory.setItemInMainHand(newItem);
        }
    }

    public void loadRifle(Player p, ItemStack item, int level) {
        PlayerInventory playerInventory = p.getInventory();
        ItemStack newItem = weaponFactory.createRifle(level, new Status(true));
        ItemStack proj = playerInventory.getItemInMainHand();
        playerInventory.setItemInMainHand(newItem);
        tools.deleteItem(item);
        for (int i = 0; i < 36 ; i++) {
            if (playerInventory.getItem(i) == null) {
                playerInventory.setItem(i, proj);
                return;
            }
        }
    }

    public void loadPistol(Player p, ItemStack item, int level) {
        PlayerInventory playerInventory = p.getInventory();
        ItemStack newItem = weaponFactory.createPistol(level, new Status(true));
        ItemStack proj = playerInventory.getItemInMainHand();
        playerInventory.setItemInMainHand(newItem);
        tools.deleteItem(item);
        for (int i = 0; i < 36 ; i++) {
            if (playerInventory.getItem(i) == null) {
                playerInventory.setItem(i, proj);
                return;
            }
        }
    }


}
