package de.studiocode.invgui.gui.builder.impl;

import de.studiocode.invgui.gui.impl.SimplePagedItemsGUI;
import de.studiocode.invgui.item.Item;

import java.util.List;

public class SimplePagedItemsGUIBuilder extends PagedGUIBuilder {
    
    private List<Item> items;
    
    public SimplePagedItemsGUIBuilder(int width, int height) {
        super(width, height);
    }
    
    @Override
    public SimplePagedItemsGUI build() {
        if (getBackBuilder() == null || getForwardBuilder() == null)
            throw new IllegalStateException("BackBuilder or ForwardBuilder haven't been set yet");
        if (items == null)
            throw new IllegalStateException("Items haven't been set yet");
        
        SimplePagedItemsGUI gui = new SimplePagedItemsGUI(getWidth(), getHeight(), getBackItemIndex(), getBackBuilder(),
            getForwardItemIndex(), getForwardBuilder(), items, getListSlots());
        setItems(gui);
        
        return gui;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
