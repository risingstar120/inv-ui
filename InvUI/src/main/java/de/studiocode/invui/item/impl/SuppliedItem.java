package de.studiocode.invui.item.impl;

import de.studiocode.invui.item.Click;
import de.studiocode.invui.item.ItemProvider;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public class SuppliedItem extends BaseItem {
    
    private final Supplier<? extends ItemProvider> builderSupplier;
    private final Function<Click, Boolean> clickHandler;
    
    public SuppliedItem(@NotNull Supplier<? extends ItemProvider> builderSupplier, @Nullable Function<Click, Boolean> clickHandler) {
        this.builderSupplier = builderSupplier;
        this.clickHandler = clickHandler;
    }
    
    @Override
    public ItemProvider getItemBuilder() {
        return builderSupplier.get();
    }
    
    @Override
    public void handleClick(ClickType clickType, Player player, InventoryClickEvent event) {
        if (clickHandler != null && clickHandler.apply(new Click(event))) notifyWindows();
    }
    
}
