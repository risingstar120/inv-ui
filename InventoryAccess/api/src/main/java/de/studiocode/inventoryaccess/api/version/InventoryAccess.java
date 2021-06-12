package de.studiocode.inventoryaccess.api.version;

import de.studiocode.inventoryaccess.api.abstraction.inventory.AnvilInventory;
import de.studiocode.inventoryaccess.api.abstraction.util.InventoryUtils;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;

public class InventoryAccess {
    
    private static final Class<InventoryUtils> INVENTORY_UTILS_CLASS = ReflectionUtils.getClass("util.InventoryUtilsImpl");
    private static final Class<AnvilInventory> ANVIL_INVENTORY_CLASS = ReflectionUtils.getClass("inventory.AnvilInventoryImpl");
    
    private static final Constructor<AnvilInventory> ANVIL_INVENTORY_CONSTRUCTOR
        = ReflectionUtils.getConstructor(ANVIL_INVENTORY_CLASS, Player.class, String.class, Consumer.class);
    
    private static final InventoryUtils INVENTORY_UTILS = ReflectionUtils.constructEmpty(INVENTORY_UTILS_CLASS);
    
    /**
     * Gets the {@link InventoryUtils}
     *
     * @return The {@link InventoryUtils}
     */
    public static InventoryUtils getInventoryUtils() {
        return INVENTORY_UTILS;
    }
    
    /**
     * Creates a new {@link AnvilInventory}.
     *
     * @param player        The {@link Player} that should see this {@link AnvilInventory}
     * @param title         The title {@link String} of the {@link AnvilInventory}
     * @param renameHandler A {@link Consumer} that is called whenever the {@link Player}
     *                      types something in the renaming section of the anvil
     * @return The {@link AnvilInventory}
     */
    public static AnvilInventory createAnvilInventory(Player player, String title, Consumer<String> renameHandler) {
        return ReflectionUtils.construct(ANVIL_INVENTORY_CONSTRUCTOR, player, title, renameHandler);
    }
    
}
