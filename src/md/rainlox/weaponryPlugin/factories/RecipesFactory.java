package md.rainlox.weaponryPlugin.factories;

import md.rainlox.weaponryPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RecipesFactory {

    private final Main main;
    public RecipesFactory(Main plugin) {
        main = plugin;
    }

    public void createRifle1Recipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Rifle1");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("ABB", "DC ", "   ");
        shape.setIngredient('A', Material.IRON_INGOT);
        shape.setIngredient('B', Material.NETHERITE_INGOT);
        shape.setIngredient('C', Material.FLINT);
        shape.setIngredient('D', Material.OAK_PLANKS);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createRifle2Recipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Rifle2");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("CBB", "BBA", "AAD");
        shape.setIngredient('A', Material.IRON_INGOT);
        shape.setIngredient('B', Material.NETHERITE_INGOT);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.GOLD_INGOT);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createRifle3Recipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Rifle3");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("CAA", "BAB", "BBD");
        shape.setIngredient('A', Material.NETHERITE_INGOT);
        shape.setIngredient('B', Material.OAK_PLANKS);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.IRON_NUGGET);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createRifle4Recipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Rifle4");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("CAA", "AAE", "BBD");
        shape.setIngredient('A', Material.NETHERITE_INGOT);
        shape.setIngredient('B', Material.OAK_PLANKS);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.IRON_NUGGET);
        shape.setIngredient('E', Material.IRON_INGOT);

        Bukkit.getServer().addRecipe(shape);
    }

    public void createRifle5Recipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Rifle5");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape(" C ", "DAA", "BA ");
        shape.setIngredient('A', Material.NETHERITE_INGOT);
        shape.setIngredient('B', Material.OAK_PLANKS);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.IRON_NUGGET);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createRifleProjectileRecipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_RifleProjectile");

//        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("AAA", "CBC", "AAA");
        shape.setIngredient('A', Material.IRON_INGOT);
        shape.setIngredient('B', Material.BLAZE_POWDER);
        shape.setIngredient('C', Material.GUNPOWDER);

//        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createPistol1Recipe(ItemStack item) {
        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Pistol1");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("CAA", "BBD", "B  ");
        shape.setIngredient('A', Material.NETHERITE_INGOT);
        shape.setIngredient('B', Material.OAK_PLANKS);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.IRON_NUGGET);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createPistol2Recipe(ItemStack item) {
        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Pistol2");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("AAA", "BBB", "BCD");
        shape.setIngredient('A', Material.NETHERITE_INGOT);
        shape.setIngredient('B', Material.OAK_PLANKS);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.GOLD_INGOT);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createPistol3Recipe(ItemStack item) {
        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_Pistol3");

        //        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape("AAA", "ABD", "BEC");
        shape.setIngredient('A', Material.NETHERITE_INGOT);
        shape.setIngredient('B', Material.OAK_PLANKS);
        shape.setIngredient('C', Material.STRING);
        shape.setIngredient('D', Material.GOLD_INGOT);
        shape.setIngredient('E', Material.IRON_NUGGET);

        //        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

    public void createPistolProjectileRecipe(ItemStack item) {

        NamespacedKey key = new NamespacedKey(main, "rainloxsWeaponry_PistolProjectile");

//        Creating recipe
        ShapedRecipe shape = new ShapedRecipe(key, item);
        shape.shape(" A ", "ABA", " A ");
        shape.setIngredient('A', Material.IRON_INGOT);
        shape.setIngredient('B', Material.GUNPOWDER);

//        Adding recipe
        Bukkit.getServer().addRecipe(shape);
    }

}
