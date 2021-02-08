package de.studiocode.invui.gui.impl;

import de.studiocode.invui.gui.GUI;
import de.studiocode.invui.gui.SlotElement;
import de.studiocode.invui.gui.builder.GUIBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A {@link PagedGUI} where every page is it's own {@link GUI}.
 *
 * @see GUIBuilder
 * @see SimplePagedItemsGUI
 */
public class SimplePagedGUIsGUI extends PagedGUI {
    
    private List<GUI> guis;
    
    public SimplePagedGUIsGUI(int width, int height, int... itemListSlots) {
        this(width, height, new ArrayList<>(), itemListSlots);
    }
    
    public SimplePagedGUIsGUI(int width, int height, List<GUI> guis, int... itemListSlots) {
        super(width, height, false, itemListSlots);
        this.guis = guis;
        
        update();
    }
    
    @Override
    public int getPageAmount() {
        return guis.size();
    }
    
    @Override
    protected List<SlotElement> getPageElements(int page) {
        return Arrays.asList(guis.get(page).getSlotElements());
    }
    
    public void setGuis(List<GUI> guis) {
        this.guis = guis;
        update();
    }
    
}
