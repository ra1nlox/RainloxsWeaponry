package md.rainlox.weaponryPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hands implements CommandExecutor {

    private final Main plugin;

    public Hands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String mainHand = plugin.config.getString("messages.commands.mainHand");
        String offHand = plugin.config.getString("messages.commands.offHand");

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Command sender must be player!");
            return true;
        }
        Player p = (Player) sender;

        ItemStack itemM = p.getInventory().getItemInMainHand();
        ItemStack itemS = p.getInventory().getItemInOffHand();

        sender.sendMessage(ChatColor.YELLOW + mainHand + itemM.getType() + " " + offHand + itemS.getType());
        sender.sendMessage(mainHand + itemM.getItemMeta().getDisplayName() + " " + offHand + itemS.getItemMeta().getDisplayName());
        return true;
    }
}
