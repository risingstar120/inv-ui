package de.studiocode.invgui.item.impl;

import de.studiocode.invgui.item.Item;
import de.studiocode.invgui.window.Window;

import java.util.HashSet;
import java.util.Set;

/**
 * The base for all {@link Item}s.
 */
public abstract class BaseItem implements Item {
    
    private final Set<Window> windows = new HashSet<>();
    
    @Override
    public void addWindow(Window window) {
        windows.add(window);
    }
    
    @Override
    public void removeWindow(Window window) {
        windows.remove(window);
    }
    
    @Override
    public Set<Window> getWindows() {
        return windows;
    }
    
    @Override
    public void notifyWindows() {
        windows.forEach(w -> w.handleItemBuilderUpdate(this));
    }
    
}
