package md.rainlox.weaponryPlugin.factories;

import md.rainlox.weaponryPlugin.Main;
import md.rainlox.weaponryPlugin.types.Status;
import md.rainlox.weaponryPlugin.utils.Tools;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WeaponFactory {

    private final Main main;
    private final Tools tools;

    public WeaponFactory(Main plugin) {
        main = plugin;
        tools = new Tools(plugin,this);
    }

    public ItemStack createRifle(int weaponLevel, Status status) {

        ItemStack item = new ItemStack(Material.CLAY_BALL);
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.YELLOW + main.config.getString("guns.names.rifles.rifle" + weaponLevel));

        List<String> lore = new ArrayList<>();
        lore.add(main.config.getString("guns.descriptions.rifles.rifle" + weaponLevel));
        lore.add(status.getStatusString());

        meta.setLore(lore);

        switch (weaponLevel) {
            case 1:
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1 ,true);
                meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                break;
            case 2:
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1 ,true);
                meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                break;
            case 3:
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1 ,true);
                meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                break;
            case 4:
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1 ,true);
                meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                break;
            case 5:
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1 ,true);
                meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + weaponLevel);
        }

        item.setItemMeta(meta);
        return item;

    }

    public ItemStack createPistol(int weaponLevel, Status status) {

        if (weaponLevel > 3 || weaponLevel <= 0) {
            throw new IllegalArgumentException("weaponLevel must be smaller than 4 and bigger than 0");
        }
        ItemStack item = new ItemStack(Material.CLAY_BALL);
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.YELLOW + main.config.getString("guns.names.pistols.pistol" + weaponLevel));

        List<String> lore = new ArrayList<>();
        lore.add(main.config.getString("guns.descriptions.pistols.pistol" + weaponLevel));
        lore.add(status.getStatusString());

        meta.setLore(lore);

        switch (weaponLevel) {
            case 1:
                meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                break;
            case 2:
                meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                break;
            case 3:
                meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + weaponLevel);
        }

        item.setItemMeta(meta);
        return item;

    }

    public ItemStack createRifleProjectile() {

        ItemStack item = new ItemStack(Material.CLAY_BALL);

        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(main.config.getString("bullets.names.rifles"));

        List<String> lore = new ArrayList<>();
        lore.add(main.config.getString("bullets.descriptions.rifles"));
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PIERCING, 1, true);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack createPistolProjectile() {
        ItemStack item = new ItemStack(Material.CLAY_BALL);

        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(main.config.getString("bullets.names.pistols"));

        List<String> lore = new ArrayList<>();
        lore.add(main.config.getString("bullets.descriptions.pistols"));
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PIERCING, 2, true);
        item.setItemMeta(meta);

        return item;
    }

}
