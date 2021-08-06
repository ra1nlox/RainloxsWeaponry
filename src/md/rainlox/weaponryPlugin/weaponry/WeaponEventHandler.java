package md.rainlox.weaponryPlugin.weaponry;

import md.rainlox.weaponryPlugin.Main;
import md.rainlox.weaponryPlugin.factories.WeaponFactory;
import md.rainlox.weaponryPlugin.utils.Tools;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class WeaponEventHandler implements Listener {

    private final Main main;
    private final Tools tools;
    private final WeaponFactory weaponFactory;
    private final Loading loading;

    public WeaponEventHandler(Main plugin) {
        this.main = plugin;
        weaponFactory = new WeaponFactory(plugin);
        tools = new Tools(plugin, weaponFactory);
        loading = new Loading(plugin, weaponFactory);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GREEN + "Привет, " + p.getDisplayName());
    }

    @EventHandler
    public void fromRifle(PlayerInteractEvent e) {
        Shooting shooting = new Shooting(main);
        Player p = e.getPlayer();
        ItemStack itemM = p.getInventory().getItemInMainHand();
        Action action = e.getAction();
        if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            if (tools.isRifle(itemM)) {
                e.setCancelled(true);
                if (tools.isLoaded(itemM)) {
                    if (tools.getLevel(itemM) == 1) {
                        shooting.shootRifle(p, 1);
                        loading.unLoadRifle(p, itemM, 1);
                        e.setCancelled(true);
                    } else if (tools.getLevel(itemM) == 2) {
                        shooting.shootRifle(p, 2);
                        loading.unLoadRifle(p, itemM, 2);
                        e.setCancelled(true);
                    } else if (tools.getLevel(itemM) == 3) {
                        shooting.shootRifle(p, 3);
                        loading.unLoadRifle(p, itemM, 3);
                        e.setCancelled(true);
                    } else if (tools.getLevel(itemM) == 4) {
                        shooting.shootRifle(p, 4);
                        loading.unLoadRifle(p, itemM, 4);
                        e.setCancelled(true);
                    } else if (tools.getLevel(itemM) == 5) {
                        shooting.shootRifle(p, 5);
                        loading.unLoadRifle(p, itemM, 5);
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void fromPistol(PlayerInteractEvent e) {
        Shooting shooting = new Shooting(main);
        Player p = e.getPlayer();
        ItemStack itemM = p.getInventory().getItemInMainHand();
        Action action = e.getAction();
        if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            if (tools.isPistol(itemM)) {
                e.setCancelled(true);
                if (tools.isLoaded(itemM)) {
                    if (tools.getLevel(itemM) == 1) {
                        shooting.shootPistol(p, 0.2);
                        loading.unLoadPistol(p, itemM, 1);
                        e.setCancelled(true);
                    } else if (tools.getLevel(itemM) == 2) {
                        shooting.shootPistol(p, 0.4);
                        loading.unLoadPistol(p, itemM, 2);
                        e.setCancelled(true);
                    } else if (tools.getLevel(itemM) == 3) {
                        shooting.shootPistol(p, 0.5);
                        loading.unLoadPistol(p, itemM, 3);
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void loadRifle(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack proj = p.getInventory().getItemInMainHand();
        ItemStack rifle = p.getInventory().getItemInOffHand();
        Action action = e.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (tools.isRifle(rifle)) {
                e.setCancelled(true);
                if (!tools.isLoaded(rifle)) {
                    if (tools.isRifleProjectile(proj)) {
                        if (tools.getLevel(rifle) == 1) {
                            tools.deleteItem(proj, 1);
                            loading.loadRifle(p, rifle, 1);
                            e.setCancelled(true);
                        } else if (tools.getLevel(rifle) == 2) {
                            tools.deleteItem(proj, 1);
                            loading.loadRifle(p, rifle, 2);
                            e.setCancelled(true);
                        } else if (tools.getLevel(rifle) == 3) {
                            tools.deleteItem(proj, 1);
                            loading.loadRifle(p, rifle, 3);
                            e.setCancelled(true);
                        } else if (tools.getLevel(rifle) == 4) {
                            tools.deleteItem(proj, 1);
                            loading.loadRifle(p, rifle, 4);
                            e.setCancelled(true);
                        } else if (tools.getLevel(rifle) == 5) {
                            tools.deleteItem(proj, 1);
                            loading.loadRifle(p, rifle, 5);
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void loadPistol(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack proj = p.getInventory().getItemInMainHand();
        ItemStack pistol = p.getInventory().getItemInOffHand();
        Action action = e.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (tools.isPistol(pistol)) {
                e.setCancelled(true);
                if (!tools.isLoaded(pistol)) {
                    if (tools.isPistolProjectile(proj)) {
                        if (tools.getLevel(pistol) == 1) {
                            tools.deleteItem(proj, 1);
                            loading.loadPistol(p, pistol, 1);
                            e.setCancelled(true);
                        } else if (tools.getLevel(pistol) == 2) {
                            tools.deleteItem(proj, 1);
                            loading.loadPistol(p, pistol, 2);
                            e.setCancelled(true);
                        } else if (tools.getLevel(pistol) == 3) {
                            tools.deleteItem(proj, 1);
                            loading.loadPistol(p, pistol, 3);
                            e.setCancelled(true);
                        } else if (tools.getLevel(pistol) == 4) {
                            tools.deleteItem(proj, 1);
                            loading.loadPistol(p, pistol, 4);
                            e.setCancelled(true);
                        } else if (tools.getLevel(pistol) == 5) {
                            tools.deleteItem(proj, 1);
                            loading.loadPistol(p, pistol, 5);
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}