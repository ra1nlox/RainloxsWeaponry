package md.rainlox.weaponryPlugin;

import md.rainlox.weaponryPlugin.factories.RecipesFactory;
import md.rainlox.weaponryPlugin.factories.WeaponFactory;
import md.rainlox.weaponryPlugin.weaponry.Load;
import md.rainlox.weaponryPlugin.weaponry.WeaponEventHandler;
import md.rainlox.weaponryPlugin.types.Status;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public final Logger log = Logger.getLogger("RainloxsWeaponry");

    private final WeaponEventHandler weaponEventHandler = new WeaponEventHandler(this);
    private final WeaponFactory weaponFactory = new WeaponFactory(this);
    private final RecipesFactory recipesFactory = new RecipesFactory(this);

    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        registerEvents();
        registerCommands();
        registerRecipes();

        log.info(config.getString("messages.onEnable"));
    }

    @Override
    public void onDisable() {
        log.info(config.getString("messages.onDisable"));
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(weaponEventHandler, this);
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("hands")).setExecutor(new Hands(this));
        Objects.requireNonNull(getCommand("load")).setExecutor(new Load(this));
    }

    public void registerRecipes() {
        recipesFactory.createRifle1Recipe(weaponFactory.createRifle(1, new Status(false)));
        recipesFactory.createRifle2Recipe(weaponFactory.createRifle(2, new Status(false)));
        recipesFactory.createRifle3Recipe(weaponFactory.createRifle(3, new Status(false)));
        recipesFactory.createRifle4Recipe(weaponFactory.createRifle(4, new Status(false)));
        recipesFactory.createRifle5Recipe(weaponFactory.createRifle(5, new Status(false)));

        recipesFactory.createPistol1Recipe(weaponFactory.createPistol(1, new Status(false)));
        recipesFactory.createPistol2Recipe(weaponFactory.createPistol(2, new Status(false)));
        recipesFactory.createPistol3Recipe(weaponFactory.createPistol(3, new Status(false)));

        recipesFactory.createRifleProjectileRecipe(weaponFactory.createRifleProjectile());
        recipesFactory.createPistolProjectileRecipe(weaponFactory.createPistolProjectile());
    }
}