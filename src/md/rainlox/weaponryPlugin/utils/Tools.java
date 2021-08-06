package md.rainlox.weaponryPlugin.utils;

import md.rainlox.weaponryPlugin.Main;
import md.rainlox.weaponryPlugin.factories.WeaponFactory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Tools {

    private final WeaponFactory weaponFactory;
    private Main main;

    public Tools(Main plugin, WeaponFactory wF) {
        main = plugin;
        weaponFactory = wF;
    }

    public boolean isArgumentPermissible(int arg, int minArgLength, int maxArgLength) {
        return arg <= maxArgLength && arg > minArgLength;
    }

    public boolean hasRequiredEnchantment(ItemStack item, int level, Enchantment enchantment) {
        if (!item.containsEnchantment(enchantment)) return false;
        return item.getEnchantmentLevel(enchantment) == level;
    }

    public void deleteItem(ItemStack item) {
        item.setAmount(0);
    }

    public void deleteItem(ItemStack item, int amount) {
        item.setAmount(item.getAmount() - amount);
    }

    public boolean isRifle(ItemStack item) {
        Tools tools = new Tools(main, weaponFactory);
        if (item.getType() == Material.CLAY_BALL) {
            if (item.hasItemMeta()) {
                if (tools.hasRequiredEnchantment(item, 1, Enchantment.ARROW_INFINITE)) {
                    if (item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPistol(ItemStack item) {
        Tools tools = new Tools(main, weaponFactory);
        if (item.getType() == Material.CLAY_BALL) {
            if (item.hasItemMeta()) {
                if (!tools.hasRequiredEnchantment(item, 1, Enchantment.ARROW_INFINITE)) {
                    if (item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getLevel(ItemStack item) {
        return item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
    }

    public boolean isLoaded(ItemStack item) {
        Tools tools = new Tools(main, weaponFactory);
        return item.getItemMeta().getLore().get(1).equals("LOADED");
    }

    public boolean isRifleProjectile(ItemStack item) {
        Tools tools = new Tools(main, weaponFactory);
        return tools.hasRequiredEnchantment(item, 1, Enchantment.PIERCING);
    }

    public boolean isPistolProjectile(ItemStack item) {
        Tools tools = new Tools(main, weaponFactory);
        return tools.hasRequiredEnchantment(item, 2, Enchantment.PIERCING);
    }
}
