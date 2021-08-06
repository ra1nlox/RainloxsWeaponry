package md.rainlox.weaponryPlugin.weaponry;

import md.rainlox.weaponryPlugin.Main;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

public class Shooting {

    private final Main main;

    public Shooting(Main plugin) {
        main = plugin;
    }

    public void shootRifle(Player p, double damage) {
        Arrow proj = p.launchProjectile(Arrow.class, p.getEyeLocation().getDirection());
        proj.setCustomName(main.config.getString("bullets.names.rifles"));
        proj.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        proj.setVelocity(proj.getVelocity().multiply(15));
        proj.setDamage(damage);
        proj.setCustomNameVisible(false);
    }

    public void shootPistol(Player p, double damage) {
        Arrow proj = p.launchProjectile(Arrow.class, p.getEyeLocation().getDirection());
        proj.setCustomName(main.config.getString("bullets.names.pistols"));
        proj.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        proj.setVelocity(proj.getVelocity().multiply(12));
        proj.setDamage(damage);
        proj.setCustomNameVisible(false);
    }

}
