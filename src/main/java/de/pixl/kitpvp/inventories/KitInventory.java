package de.pixl.kitpvp.inventories;

import de.pixl.kitpvp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitInventory implements Listener {

    @EventHandler
    public void onSignClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;

        if (event.getClickedBlock().getState() instanceof Sign) {
            String kitWarp = ((Sign) event.getClickedBlock().getState()).getLine(1);

            if (kitWarp.equalsIgnoreCase("§7[§1Choose your Kit§7]")) {

                Inventory inventoryKits = Bukkit.createInventory(null, 9 * 6, "§cKit Inventory");

                inventoryKits.setItem(19, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§aTank").setLocalizedName("tank").build());
                inventoryKits.setItem(20, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setDisplayname("§aKnight").setLocalizedName("knight").build());
                inventoryKits.setItem(21, new ItemBuilder(Material.BOW).setDisplayname("§aArcher").setLocalizedName("archer").build());
                inventoryKits.setItem(22, new ItemBuilder(Material.IRON_SWORD).setDisplayname("§aWarrior").setLocalizedName("warrior").build());
                inventoryKits.setItem(23, new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§aEnderMan").setLocalizedName("enderman").build());
                inventoryKits.setItem(24, new ItemBuilder(Material.GOLDEN_HELMET).setDisplayname("§aKing").setLocalizedName("king").build());
                inventoryKits.setItem(25, new ItemBuilder(Material.RABBIT_FOOT).setDisplayname("§aKangaroo").setLocalizedName("kangaroo").build());
                inventoryKits.setItem(28, new ItemBuilder(Material.SUGAR).setDisplayname("§aSpeeed").setLocalizedName("sonic").build());
                inventoryKits.setItem(29, new ItemBuilder(Material.TRIDENT).setDisplayname("§aAquaman").setLocalizedName("aquaman").build());
                inventoryKits.setItem(30, new ItemBuilder(Material.TNT).setDisplayname("§aBomber").setLocalizedName("bomber").build());
                inventoryKits.setItem(31, new ItemBuilder(Material.GHAST_TEAR).setDisplayname("§aGhost").setLocalizedName("ghost").build());
                inventoryKits.setItem(32, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§aAngel").setLocalizedName("angel").build());
                inventoryKits.setItem(33, new ItemBuilder(Material.NETHERRACK).setDisplayname("§aDemon").setLocalizedName("demon").build());

                event.getPlayer().openInventory(inventoryKits);
            }
        }
    }

    @EventHandler
    public boolean onInvClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("§cKit Inventory")) {

            if (event.getCurrentItem() == null) {
                event.setCancelled(true);
                return false;
            }

            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "tank" -> {
                        player.getInventory().clear();

                        ItemStack tankHelmet = new ItemStack(Material.DIAMOND_HELMET);
                        ItemMeta tankHelmetM = tankHelmet.getItemMeta();
                        tankHelmetM.setDisplayName("§aTank Helmet");
                        tankHelmet.setItemMeta(tankHelmetM);

                        ItemStack tankChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemMeta tankChestplateM = tankHelmet.getItemMeta();
                        tankChestplateM.setDisplayName("§aTank Chestplate");
                        tankChestplateM.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
                        tankChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                        tankChestplate.setItemMeta(tankChestplateM);

                        ItemStack tankLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                        ItemMeta tankLeggingsM = tankLeggings.getItemMeta();
                        tankLeggingsM.setDisplayName("§aTank Leggings");
                        tankLeggings.setItemMeta(tankLeggingsM);

                        ItemStack tankBoots = new ItemStack(Material.DIAMOND_BOOTS);
                        ItemMeta tankBootsM = tankBoots.getItemMeta();
                        tankBootsM.setDisplayName("§aTank Boots");
                        tankBoots.setItemMeta(tankBootsM);

                        ItemStack tankSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta tankSwordM = tankSword.getItemMeta();
                        tankSwordM.setDisplayName("§aSword");
                        tankSwordM.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                        tankSword.setItemMeta(tankSwordM);

                        player.getInventory().setHelmet(tankHelmet);
                        player.getInventory().setChestplate(tankChestplate);
                        player.getInventory().setLeggings(tankLeggings);
                        player.getInventory().setBoots(tankBoots);
                        player.getInventory().setItem(0, tankSword);

                        player.setInvisible(false);

                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 72000, 2));
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "knight" -> {
                        player.getInventory().clear();
                        ItemStack knightHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
                        ItemMeta knigtHelmetM = knightHelmet.getItemMeta();
                        knigtHelmetM.setDisplayName("§aKnight Helmet");
                        knigtHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        knigtHelmetM.addEnchant(Enchantment.DURABILITY, 6, true);
                        knightHelmet.setItemMeta(knigtHelmetM);
                        ItemStack knightChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                        ItemMeta knightChestplateM = knightChestplate.getItemMeta();
                        knightChestplateM.setDisplayName("§aKnight Chestplate");
                        knightChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        knightChestplateM.addEnchant(Enchantment.DURABILITY, 6, true);
                        knightChestplate.setItemMeta(knightChestplateM);
                        ItemStack knightLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                        ItemMeta knightLeggingsM = knightLeggings.getItemMeta();
                        knightLeggingsM.setDisplayName("§aKnight Leggings");
                        knightLeggingsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        knightLeggingsM.addEnchant(Enchantment.DURABILITY, 6, true);
                        knightLeggings.setItemMeta(knightLeggingsM);
                        ItemStack knightBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
                        ItemMeta knightBootsM = knightBoots.getItemMeta();
                        knightBootsM.setDisplayName("§aKnight Boots");
                        knightBootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        knightBootsM.addEnchant(Enchantment.DURABILITY, 6, true);
                        knightBoots.setItemMeta(knightBootsM);
                        ItemStack knightSword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta knightSwordM = knightSword.getItemMeta();
                        knightSwordM.setDisplayName("§aSword");
                        knightSwordM.addEnchant(Enchantment.DURABILITY, 5, true);
                        knightSword.setItemMeta(knightSwordM);
                        ItemStack knightShield = new ItemStack(Material.SHIELD);
                        ItemMeta knigtShieldM = knightShield.getItemMeta();
                        knigtShieldM.setUnbreakable(true);
                        knigtShieldM.setDisplayName("§aKnight Shield");
                        knightShield.setItemMeta(knigtShieldM);
                        player.getInventory().setHelmet(knightHelmet);
                        player.getInventory().setChestplate(knightChestplate);
                        player.getInventory().setLeggings(knightLeggings);
                        player.getInventory().setBoots(knightBoots);
                        player.getInventory().setItem(0, knightSword);
                        player.getInventory().setItemInOffHand(knightShield);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "archer" -> {
                        player.getInventory().clear();
                        ItemStack archerHelmet = new ItemStack(Material.LEATHER_HELMET);
                        ItemMeta archerHelmetM = archerHelmet.getItemMeta();
                        archerHelmetM.setDisplayName("§aArcher's Helmet");
                        archerHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        archerHelmetM.addEnchant(Enchantment.DURABILITY, 5, true);
                        archerHelmet.setItemMeta(archerHelmetM);
                        ItemStack archerChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        ItemMeta archerChestplateM = archerChestplate.getItemMeta();
                        archerChestplateM.setDisplayName("§aArcher's Chestplate");
                        archerChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        archerChestplateM.addEnchant(Enchantment.DURABILITY, 5, true);
                        archerChestplate.setItemMeta(archerChestplateM);
                        ItemStack archerLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
                        ItemMeta archerLeggingsM = archerLeggings.getItemMeta();
                        archerLeggingsM.setDisplayName("§aArcher's Leggings");
                        archerLeggingsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        archerLeggingsM.addEnchant(Enchantment.DURABILITY, 5, true);
                        archerLeggings.setItemMeta(archerLeggingsM);
                        ItemStack archerBoots = new ItemStack(Material.LEATHER_BOOTS);
                        ItemMeta archerBootsM = archerBoots.getItemMeta();
                        archerBootsM.setDisplayName("§aArcher's Boots");
                        archerBootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        archerBootsM.addEnchant(Enchantment.DURABILITY, 5, true);
                        archerBoots.setItemMeta(archerBootsM);
                        ItemStack archerSword = new ItemStack(Material.STONE_SWORD);
                        ItemMeta archerSwordM = archerSword.getItemMeta();
                        archerSwordM.setDisplayName("§aSword");
                        archerSword.setItemMeta(archerSwordM);
                        ItemStack archerBow = new ItemStack(Material.BOW);
                        ItemMeta archerBowM = archerSword.getItemMeta();
                        archerBowM.setDisplayName("§aArcher's Bow");
                        archerBowM.addEnchant(Enchantment.ARROW_FIRE, 2, true);
                        archerBow.setItemMeta(archerBowM);
                        player.getInventory().setHelmet(archerHelmet);
                        player.getInventory().setChestplate(archerChestplate);
                        player.getInventory().setLeggings(archerLeggings);
                        player.getInventory().setBoots(archerBoots);
                        player.getInventory().setItem(0, archerSword);
                        player.getInventory().setItem(1, archerBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().addItem(new ItemStack(Material.ARROW, 16));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "warrior" -> {
                        player.getInventory().clear();
                        ItemStack warriorHelmet = new ItemStack(Material.IRON_HELMET);
                        ItemMeta warriorHelmetM = warriorHelmet.getItemMeta();
                        warriorHelmetM.setDisplayName("§aWarrior Helmet");
                        warriorHelmet.setItemMeta(warriorHelmetM);
                        ItemStack warriorChestplate = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemMeta warriorChestplateM = warriorChestplate.getItemMeta();
                        warriorChestplateM.setDisplayName("§aWarrior Chestplate");
                        warriorChestplate.setItemMeta(warriorChestplateM);
                        ItemStack warriorLeggings = new ItemStack(Material.IRON_LEGGINGS);
                        ItemMeta warriorLeggingsM = warriorLeggings.getItemMeta();
                        warriorLeggingsM.setDisplayName("§aWarrior Leggings");
                        warriorLeggings.setItemMeta(warriorLeggingsM);
                        ItemStack warriorBoots = new ItemStack(Material.IRON_BOOTS);
                        ItemMeta warriorBootsM = warriorBoots.getItemMeta();
                        warriorBootsM.setDisplayName("§aWarrior Boots");
                        warriorBoots.setItemMeta(warriorBootsM);
                        ItemStack warriorSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta warriorSwordM = warriorSword.getItemMeta();
                        warriorSwordM.setDisplayName("§aSword");
                        warriorBoots.setItemMeta(warriorSwordM);
                        player.getInventory().setHelmet(warriorHelmet);
                        player.getInventory().setChestplate(warriorChestplate);
                        player.getInventory().setLeggings(warriorLeggings);
                        player.getInventory().setBoots(warriorBoots);
                        player.getInventory().setItem(0, warriorSword);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "enderman" -> {
                        player.getInventory().clear();
                        ItemStack enderHelmet = new ItemStack(Material.IRON_HELMET);
                        ItemMeta enderHelmetM = enderHelmet.getItemMeta();
                        enderHelmetM.setDisplayName("§aEnderman Helmet");
                        enderHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        enderHelmet.setItemMeta(enderHelmetM);
                        ItemStack enderCestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                        ItemMeta enderChestplateM = enderCestplate.getItemMeta();
                        enderChestplateM.setDisplayName("§aEnderman Chestplate");
                        enderChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                        enderCestplate.setItemMeta(enderChestplateM);
                        ItemStack enderLeggings = new ItemStack(Material.IRON_LEGGINGS);
                        ItemMeta enderLeggingsM = enderLeggings.getItemMeta();
                        enderLeggingsM.setDisplayName("§aEnderman Leggings");
                        enderLeggingsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        enderLeggings.setItemMeta(enderLeggingsM);
                        ItemStack enderBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
                        ItemMeta enderBootsM = enderBoots.getItemMeta();
                        enderBootsM.setDisplayName("§aEnderman Boots");
                        enderBootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        enderBoots.setItemMeta(enderBootsM);
                        ItemStack enderSword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta enderSwordM = enderSword.getItemMeta();
                        enderSwordM.setDisplayName("§aSword");
                        enderSwordM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        enderSword.setItemMeta(enderSwordM);
                        player.getInventory().setHelmet(enderHelmet);
                        player.getInventory().setChestplate(enderCestplate);
                        player.getInventory().setLeggings(enderLeggings);
                        player.getInventory().setBoots(enderBoots);
                        player.getInventory().setItem(0, enderSword);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 4));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "king" -> {
                        player.getInventory().clear();
                        ItemStack kingHelmet = new ItemStack(Material.GOLDEN_HELMET);
                        ItemMeta kingHelmetM = kingHelmet.getItemMeta();
                        kingHelmetM.setDisplayName("§aKing Crown");
                        kingHelmetM.addEnchant(Enchantment.DURABILITY, 2, true);
                        kingHelmet.setItemMeta(kingHelmetM);
                        ItemStack kingCestplate = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemMeta kingChestplateM = kingCestplate.getItemMeta();
                        kingChestplateM.setDisplayName("§aKing Chestplate");
                        kingCestplate.setItemMeta(kingChestplateM);
                        ItemStack kingLeggings = new ItemStack(Material.IRON_LEGGINGS);
                        ItemMeta kingLeggingsM = kingLeggings.getItemMeta();
                        kingLeggingsM.setDisplayName("§aKing Leggings");
                        kingLeggings.setItemMeta(kingLeggingsM);
                        ItemStack kingBoots = new ItemStack(Material.IRON_BOOTS);
                        ItemMeta kingBootsM = kingBoots.getItemMeta();
                        kingBootsM.setDisplayName("§aKing Boots");
                        kingBoots.setItemMeta(kingBootsM);
                        ItemStack kingSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta kingSwordM = kingSword.getItemMeta();
                        kingSwordM.setDisplayName("§aSword");
                        kingSword.setItemMeta(kingSwordM);
                        ItemStack kingAxe = new ItemStack(Material.IRON_SWORD);
                        ItemMeta kingAxeM = kingAxe.getItemMeta();
                        kingAxeM.setDisplayName("§aSword");
                        kingBootsM.addEnchant(Enchantment.DURABILITY, 20, true);
                        kingAxe.setItemMeta(kingAxeM);
                        player.getInventory().setHelmet(kingHelmet);
                        player.getInventory().setChestplate(kingCestplate);
                        player.getInventory().setLeggings(kingLeggings);
                        player.getInventory().setBoots(kingBoots);
                        player.getInventory().setItem(0, kingSword);
                        player.getInventory().setItem(0, kingAxe);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "kangaroo" -> {
                        player.getInventory().clear();
                        ItemStack kangarooHelmet = new ItemStack(Material.GOLDEN_HELMET);
                        ItemMeta kangarooHelmetM = kangarooHelmet.getItemMeta();
                        kangarooHelmetM.setDisplayName("§aKangaroo Helmet");
                        kangarooHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        kangarooHelmetM.addEnchant(Enchantment.DURABILITY, 10, true);
                        kangarooHelmet.setItemMeta(kangarooHelmetM);
                        ItemStack kangarooCestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
                        ItemMeta kangarooChestplateM = kangarooCestplate.getItemMeta();
                        kangarooChestplateM.setDisplayName("§aKangaroo Chestplate");
                        kangarooChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        kangarooChestplateM.addEnchant(Enchantment.DURABILITY, 10, true);
                        kangarooCestplate.setItemMeta(kangarooChestplateM);
                        ItemStack kangarooLeggings = new ItemStack(Material.GOLDEN_LEGGINGS);
                        ItemMeta kangarooLeggingsM = kangarooLeggings.getItemMeta();
                        kangarooLeggingsM.setDisplayName("§aKangaroo Leggings");
                        kangarooLeggingsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        kangarooLeggingsM.addEnchant(Enchantment.DURABILITY, 10, true);
                        kangarooLeggings.setItemMeta(kangarooLeggingsM);
                        ItemStack kangarooBoots = new ItemStack(Material.GOLDEN_BOOTS);
                        ItemMeta kangarooBootsM = kangarooBoots.getItemMeta();
                        kangarooBootsM.setDisplayName("§aKangaroo Boots");
                        kangarooBootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        kangarooBootsM.addEnchant(Enchantment.DURABILITY, 10, true);
                        kangarooBootsM.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
                        kangarooBoots.setItemMeta(kangarooBootsM);
                        ItemStack kangarooSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta kangarooSwordM = kangarooSword.getItemMeta();
                        kangarooSwordM.setDisplayName("§aSword");
                        kangarooSwordM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        kangarooBoots.setItemMeta(kangarooBootsM);
                        player.getInventory().setHelmet(kangarooHelmet);
                        player.getInventory().setChestplate(kangarooCestplate);
                        player.getInventory().setLeggings(kangarooLeggings);
                        player.getInventory().setBoots(kangarooBoots);
                        player.getInventory().setItem(0, kangarooSword);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
                        player.setInvisible(false);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 72000, 5));
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "sonic" -> {
                        player.getInventory().clear();
                        ItemStack sonicHelmet = new ItemStack(Material.LEATHER_HELMET);
                        ItemMeta sonicHelmetM = sonicHelmet.getItemMeta();
                        sonicHelmetM.setDisplayName("§aSonic Helmet");
                        sonicHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        sonicHelmetM.addEnchant(Enchantment.DURABILITY, 12, true);
                        sonicHelmet.setItemMeta(sonicHelmetM);
                        ItemStack sonicCestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        ItemMeta sonicChestplateM = sonicCestplate.getItemMeta();
                        sonicChestplateM.setDisplayName("§aSonic Chestplate");
                        sonicChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        sonicChestplateM.addEnchant(Enchantment.DURABILITY, 12, true);
                        sonicCestplate.setItemMeta(sonicChestplateM);
                        ItemStack sonicLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
                        ItemMeta sonicLeggingsM = sonicLeggings.getItemMeta();
                        sonicLeggingsM.setDisplayName("§aSonic Leggings");
                        sonicLeggingsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        sonicLeggingsM.addEnchant(Enchantment.DURABILITY, 12, true);
                        sonicLeggings.setItemMeta(sonicLeggingsM);
                        ItemStack sonicBoots = new ItemStack(Material.LEATHER_BOOTS);
                        ItemMeta sonicBootsM = sonicBoots.getItemMeta();
                        sonicBootsM.setDisplayName("§aSonic Boots");
                        sonicBootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        sonicBootsM.addEnchant(Enchantment.DURABILITY, 12, true);
                        sonicBoots.setItemMeta(sonicBootsM);
                        ItemStack sonicSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta sonicSwordM = sonicSword.getItemMeta();
                        sonicSwordM.setDisplayName("§aSword");
                        sonicSwordM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        sonicSword.setItemMeta(sonicSwordM);
                        player.getInventory().setHelmet(sonicHelmet);
                        player.getInventory().setChestplate(sonicCestplate);
                        player.getInventory().setLeggings(sonicLeggings);
                        player.getInventory().setBoots(sonicBoots);
                        player.getInventory().setItem(0, sonicSword);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 72000, 3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 7200, 1));
                        player.removePotionEffect(PotionEffectType.SLOW);

                        player.closeInventory();
                    }
                    case "aquaman" -> {
                        player.getInventory().clear();
                        ItemStack aquamanHelmet = new ItemStack(Material.TURTLE_HELMET);
                        ItemMeta aquamanHelmetM = aquamanHelmet.getItemMeta();
                        aquamanHelmetM.setDisplayName("§aAquaman Crown");
                        aquamanHelmetM.addEnchant(Enchantment.DURABILITY, 2, true);
                        aquamanHelmet.setItemMeta(aquamanHelmetM);
                        ItemStack aquamanChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemMeta aquamanChestplateM = aquamanChestplate.getItemMeta();
                        aquamanChestplateM.setDisplayName("§aAquaman Chestplate");
                        aquamanChestplate.setItemMeta(aquamanChestplateM);
                        ItemStack aquamanLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                        ItemMeta aquamanLeggingsM = aquamanLeggings.getItemMeta();
                        aquamanLeggingsM.setDisplayName("§aAquaman Leggings");
                        aquamanLeggings.setItemMeta(aquamanLeggingsM);
                        ItemStack aquamanBoots = new ItemStack(Material.DIAMOND_BOOTS);
                        ItemMeta aquamanBootsM = aquamanBoots.getItemMeta();
                        aquamanBootsM.setDisplayName("§aAquaman Boots");
                        aquamanBootsM.addEnchant(Enchantment.PROTECTION_FALL, 100, true);
                        aquamanBoots.setItemMeta(aquamanBootsM);
                        ItemStack aquamanTrident = new ItemStack(Material.TRIDENT);
                        ItemMeta aquamanTridentM = aquamanTrident.getItemMeta();
                        aquamanTridentM.setDisplayName("§aTrident");
                        aquamanTridentM.addEnchant(Enchantment.LOYALTY, 10, true);
                        aquamanTridentM.addEnchant(Enchantment.RIPTIDE, 3, true);
                        aquamanTrident.setItemMeta(aquamanTridentM);
                        player.getInventory().setHelmet(aquamanHelmet);
                        player.getInventory().setChestplate(aquamanChestplate);
                        player.getInventory().setLeggings(aquamanLeggings);
                        player.getInventory().setBoots(aquamanBoots);
                        player.getInventory().setItem(0, aquamanTrident);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.setInvisible(false);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "bomber" -> {
                        player.getInventory().clear();
                        ItemStack bomberHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
                        ItemMeta bomberHelmetM = bomberHelmet.getItemMeta();
                        bomberHelmetM.setDisplayName("§aBomber Helmet");
                        bomberHelmetM.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
                        bomberHelmet.setItemMeta(bomberHelmetM);

                        ItemStack bomberChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                        ItemMeta bomberChestplateM = bomberChestplate.getItemMeta();
                        bomberChestplateM.setDisplayName("§aBomber Chestplate");
                        bomberChestplateM.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
                        bomberChestplate.setItemMeta(bomberChestplateM);

                        ItemStack bomberLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                        ItemMeta bomberLeggingsM = bomberLeggings.getItemMeta();
                        bomberLeggingsM.setDisplayName("§aBomber Leggings");
                        bomberLeggingsM.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
                        bomberLeggings.setItemMeta(bomberLeggingsM);

                        ItemStack bomberBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
                        ItemMeta bomberBootsM = bomberBoots.getItemMeta();
                        bomberBootsM.setDisplayName("§aBomber Boots");
                        bomberBootsM.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
                        bomberBoots.setItemMeta(bomberBootsM);

                        ItemStack bomberSword = new ItemStack(Material.STONE_SWORD);
                        ItemMeta bomberSwordM = bomberSword.getItemMeta();
                        bomberSwordM.setDisplayName("§aSword");
                        bomberSword.setItemMeta(bomberSwordM);

                        player.getInventory().setItem(0, bomberSword);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().addItem(new ItemStack(Material.TNT, 16));
                        player.setInvisible(false);

                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "ghost" -> {
                        player.getInventory().clear();

                        ItemStack ghostSword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta ghostSwordM = ghostSword.getItemMeta();
                        ghostSwordM.setDisplayName("§aSword");
                        ghostSword.setItemMeta(ghostSwordM);

                        ItemStack ghostAxe = new ItemStack(Material.DIAMOND_AXE);
                        ItemMeta ghostAxeM = ghostAxe.getItemMeta();
                        ghostAxeM.setDisplayName("§aAxe");
                        ghostAxe.setItemMeta(ghostAxeM);
                        player.getInventory().setItem(0, ghostSword);
                        player.getInventory().setItem(1, ghostAxe);

                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));

                        player.setInvisible(true);

                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "angel" -> {
                        player.getInventory().clear();

                        ItemStack angelHelmet = new ItemStack(Material.GOLDEN_HELMET);
                        ItemMeta angelHelmetM = angelHelmet.getItemMeta();
                        angelHelmetM.setDisplayName("§aAngel Helmet");
                        angelHelmetM.addEnchant(Enchantment.DURABILITY, 10, true);
                        angelHelmet.setItemMeta(angelHelmetM);

                        ItemStack angelChestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
                        ItemMeta angelChestplateM = angelChestplate.getItemMeta();
                        angelChestplateM.setDisplayName("§aAngel Chestplate");
                        angelChestplateM.addEnchant(Enchantment.DURABILITY, 10, true);
                        angelChestplate.setItemMeta(angelChestplateM);

                        ItemStack angelLeggings = new ItemStack(Material.GOLDEN_LEGGINGS);
                        ItemMeta angelLeggingsM = angelLeggings.getItemMeta();
                        angelLeggingsM.setDisplayName("§aAngel Leggings");
                        angelLeggingsM.addEnchant(Enchantment.DURABILITY, 10, true);
                        angelLeggings.setItemMeta(angelLeggingsM);

                        ItemStack angelBoots = new ItemStack(Material.GOLDEN_BOOTS);
                        ItemMeta angelBootsM = angelBoots.getItemMeta();
                        angelBootsM.setDisplayName("§aAngel Boots");
                        angelBootsM.addEnchant(Enchantment.DURABILITY, 10, true);
                        angelBoots.setItemMeta(angelBootsM);

                        ItemStack angelSword = new ItemStack(Material.GOLDEN_SWORD);
                        ItemMeta angelSwordM = angelSword.getItemMeta();
                        angelSwordM.setDisplayName("§aSword");
                        angelSwordM.addEnchant(Enchantment.DURABILITY, 10, true);
                        angelSword.setItemMeta(angelSwordM);

                        player.getInventory().setHelmet(angelHelmet);
                        player.getInventory().setChestplate(angelChestplate);
                        player.getInventory().setLeggings(angelLeggings);
                        player.getInventory().setBoots(angelBoots);
                        player.getInventory().setItem(0, angelSword);
                        player.getInventory().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));

                        player.setInvisible(false);

                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 72000, 1));
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                    case "demon" -> {
                        player.getInventory().clear();

                        ItemStack demonHelmet = new ItemStack(Material.IRON_HELMET);
                        ItemMeta demonHelmetM = demonHelmet.getItemMeta();
                        demonHelmetM.setDisplayName("§aDemon Helmet");
                        demonHelmetM.addEnchant(Enchantment.THORNS, 4, true);
                        demonHelmet.setItemMeta(demonHelmetM);

                        ItemStack demonChestplate = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemMeta demonChestplateM = demonChestplate.getItemMeta();
                        demonChestplateM.setDisplayName("§aDemon Chestplate");
                        demonChestplateM.addEnchant(Enchantment.THORNS, 4, true);
                        demonChestplate.setItemMeta(demonChestplateM);

                        ItemStack demonLeggings = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemMeta demonLeggingsM = demonLeggings.getItemMeta();
                        demonLeggingsM.setDisplayName("§aDemon Leggings");
                        demonLeggingsM.addEnchant(Enchantment.THORNS, 4, true);
                        demonLeggings.setItemMeta(demonLeggingsM);

                        ItemStack demonBoots = new ItemStack(Material.IRON_BOOTS);
                        ItemMeta demonBootsM = demonBoots.getItemMeta();
                        demonBootsM.setDisplayName("§aDemon Boots");
                        demonBootsM.addEnchant(Enchantment.THORNS, 4, true);
                        demonBoots.setItemMeta(demonBootsM);

                        ItemStack demonSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta demonSwordM = demonSword.getItemMeta();
                        demonSwordM.setDisplayName("§aSword");
                        demonSwordM.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
                        demonSword.setItemMeta(demonSwordM);

                        player.getInventory().setHelmet(demonHelmet);
                        player.getInventory().setChestplate(demonChestplate);
                        player.getInventory().setLeggings(demonLeggings);
                        player.getInventory().setBoots(demonBoots);
                        player.getInventory().setItem(0, demonSword);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 8));

                        player.setInvisible(false);

                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);

                        player.closeInventory();
                    }
                }
            }
        }
        return false;
    }
}

