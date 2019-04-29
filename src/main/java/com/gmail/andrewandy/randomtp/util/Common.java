package com.gmail.andrewandy.randomtp.util;

import com.gmail.andrewandy.randomtp.RandomTP;
import com.google.common.collect.BiMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class Common {

    public static void tell(Entity entity, String... message ) {
        entity.sendMessage(message);
    }


    public static String[] colorise(String... message) {
        for (int index = 0; index < message.length; index++) {
            message[index] = ChatColor.translateAlternateColorCodes('&', message[index]);
        }
        return message;
    }

    public static String colorise(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void log(Level level, String... messages) {
        for (String message:messages) {
            RandomTP.getInstance().getLogger().log(level, message);
        }
    }

    public static void log(BiMap<Level, String> messages) {
        for (String message: messages.values()) {
            RandomTP.getInstance().getLogger().log(messages.inverse().get(message), message);
        }
    }

    public static String capitalise(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static List<String> capitalise(String... strings) {
        List<String> stringList = new ArrayList<>();
        for (String string : strings) {
            capitalise(string);
        }
        return stringList;
    }

    public static Inventory createGUI(InventoryHolder owner, String name, int size, ItemStack defaultItem, Map<Integer, ItemStack> buttons) {
        Inventory inv = Bukkit.createInventory(owner, size, name);
        ItemStack[] contents = inv.getContents();
        for (int index = 0; index < contents.length; index++) {
            contents[index] = (buttons.get(index) != null) ? buttons.get(index) : defaultItem;
        }
        inv.setContents(contents);
        return inv;
    }

    public static Inventory createGUI(InventoryHolder owner, String name, int size, Material defaultItem, Map<Integer, ItemStack> buttons) {
        Inventory inv = Bukkit.createInventory(owner, size, name);
        ItemStack[] contents = inv.getContents();
        for (int index = 0; index < contents.length; index++) {
            contents[index] = (buttons.get(index) != null) ? buttons.get(index) : new ItemStack(defaultItem);
        }
        inv.setContents(contents);
        return inv;
    }

    public static ItemStack createButton(String name, Material material, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(colorise(name));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createButton(String name, ItemStack item, List<String> lore) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(colorise(name));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
