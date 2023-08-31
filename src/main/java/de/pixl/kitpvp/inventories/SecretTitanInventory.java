package de.pixl.kitpvp.inventories;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class SecretTitanInventory implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getView().getTitle() == "§cSecret Inventory") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {

                    case "titan":
                        player.getInventory().clear();

                        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                        ItemMeta helmetMeta = helmet.getItemMeta();
                        helmetMeta.setDisplayName("§cTitan Helmet");
                        helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        helmet.setItemMeta(helmetMeta);

                        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        ItemMeta chestplateMeta = chestplate.getItemMeta();
                        chestplateMeta.setDisplayName("§cTitan Chestplate");
                        chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        chestplate.setItemMeta(chestplateMeta);

                        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                        ItemMeta leggingsMeta = leggings.getItemMeta();
                        leggingsMeta.setDisplayName("§cTitan Leggings");
                        leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        leggings.setItemMeta(leggingsMeta);

                        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                        ItemMeta bootsMeta = boots.getItemMeta();
                        bootsMeta.setDisplayName("§cTitan Boots");
                        bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        boots.setItemMeta(bootsMeta);

                        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
                        ItemMeta swordMeta = sword.getItemMeta();
                        swordMeta.setDisplayName("§cTitan Sword");
                        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                        sword.setItemMeta(swordMeta);

                        ItemStack apples = new ItemStack(Material.GOLDEN_APPLE, 5);
                        ItemStack carrots = new ItemStack(Material.GOLDEN_CARROT, 16);

                        player.getInventory().setHelmet(helmet);
                        player.getInventory().setChestplate(chestplate);
                        player.getInventory().setLeggings(leggings);
                        player.getInventory().setBoots(boots);
                        player.getInventory().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                        player.getInventory().addItem(sword, apples, carrots);

                        player.removePotionEffect(PotionEffectType.JUMP);
                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                        break;
                }
            }
        }
    }
}
