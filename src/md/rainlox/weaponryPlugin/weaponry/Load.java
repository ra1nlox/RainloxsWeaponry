package md.rainlox.weaponryPlugin.weaponry;

import md.rainlox.weaponryPlugin.Main;
import md.rainlox.weaponryPlugin.factories.WeaponFactory;
import md.rainlox.weaponryPlugin.utils.Tools;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Load implements CommandExecutor {

    private final Main main;
    private final WeaponFactory weaponFactory;
    private final Tools tools;
    private final Loading loading;

    public Load(Main plugin) {
        this.main = plugin;
        weaponFactory = new WeaponFactory(plugin);
        tools = new Tools(plugin, weaponFactory);
        loading = new Loading(plugin, weaponFactory);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String rifle1 = main.config.getString("guns.names.rifles.rifle1");
        String rifle2 = main.config.getString("guns.names.rifles.rifle2");
        String rifle3 = main.config.getString("guns.names.rifles.rifle3");
        String rifle4 = main.config.getString("guns.names.rifles.rifle4");
        String rifle5 = main.config.getString("guns.names.rifles.rifle5");

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Command sender must be player!");
            return true;
        }
        if (!sender.hasPermission("tech.admin")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission");
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "ERROR: NOT ENOUGH ARGUMENTS");
        }
        if (args.length >= 1) {
            sender.sendMessage(ChatColor.RED + "ERROR: TO MANY ARGUMENTS");
        }

        Player p = (Player) sender;
        ItemStack item = p.getInventory().getItemInMainHand();

        if (args[0].equals("rifle1")) {
            if (!tools.hasRequiredEnchantment(item, 1, Enchantment.DAMAGE_ALL)) return true;
            if (!item.hasItemMeta()) return true;
            loading.loadRifle(p, item, 1);
        } else if (args[0].equals("rifle2")) {
            if (!tools.hasRequiredEnchantment(item, 2, Enchantment.DAMAGE_ALL)) return true;
            if (!item.hasItemMeta()) return true;
            loading.loadRifle(p, item, 2);
        } else if (args[0].equals("rifle3")) {
            if (!tools.hasRequiredEnchantment(item, 3, Enchantment.DAMAGE_ALL)) return true;
            if (!item.hasItemMeta()) return true;
            loading.loadRifle(p, item, 3);
        } else if (args[0].equals("rifle4")) {
            if (!tools.hasRequiredEnchantment(item, 4, Enchantment.DAMAGE_ALL)) return true;
            if (!item.hasItemMeta()) return true;
            loading.loadRifle(p, item, 4);
        } else if (args[0].equals("rifle5")) {
            if (!tools.hasRequiredEnchantment(item, 5, Enchantment.DAMAGE_ALL)) return true;
            if (!item.hasItemMeta()) return true;
            loading.loadRifle(p, item, 5);
        } else if (args[0].equals("test")) {
            for (int i = 0; i < 36 ; i++) {
                ItemStack test = p.getInventory().getItem(i);
                if (test != null) {
                    p.sendMessage(String.valueOf(p.getInventory().getItem(i)));
                    p.sendMessage(String.valueOf(p.getInventory().getItem(i).getType()));
                }
            }
        } else {
            p.sendMessage("ERROR: WRONG ARGUMENT");
        }

        sender.sendMessage(ChatColor.BLUE + "Loaded");

        return true;
    }



}
