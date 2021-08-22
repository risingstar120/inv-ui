package de.studiocode.invui.gui.builder.guitype;

import de.studiocode.invui.gui.GUI;
import de.studiocode.invui.gui.builder.GUIContext;
import de.studiocode.invui.gui.impl.*;
import de.studiocode.invui.item.Item;

public interface GUIType<G extends GUI> {
    
    GUIType<SimpleGUI> NORMAL = new NormalGUIType();
    GUIType<SimplePagedItemsGUI> PAGED_ITEMS = new PagedItemsGUIType();
    GUIType<SimplePagedNestedGUI> PAGED_GUIs = new PagedGUIsGUIType();
    GUIType<SimpleTabGUI> TAB = new TabGUIType();
    GUIType<SimpleScrollGUI> SCROLL = new ScrollGUIType();
    
    /**
     * Creates a {@link GUI} of type {@link G} with the given {@link GUIContext}
     *
     * @param context The {@link GUIContext} to create the {@link G} from.
     * @return The created {@link G}
     */
    G createGUI(GUIContext context);
    
    /**
     * @return If this {@link GUIType} accepts {@link GUI GUIs} from the {@link GUIContext}.
     */
    boolean acceptsGUIs();
    
    /**
     * @return If this {@link GUIType} accepts {@link Item Items} from the {@link GUIContext}.
     */
    boolean acceptsItems();
    
}
