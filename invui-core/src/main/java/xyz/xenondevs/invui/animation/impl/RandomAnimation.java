package xyz.xenondevs.invui.animation.impl;

import xyz.xenondevs.invui.item.Item;

import java.util.List;
import java.util.Random;

/**
 * Lets the {@link Item}s pop up randomly.
 */
public class RandomAnimation extends AbstractSoundAnimation {
    
    private final Random random = new Random();
    
    public RandomAnimation(int tickDelay, boolean sound) {
        super(tickDelay, sound);
    }
    
    @Override
    protected void handleFrame(int frame) {
        List<Integer> slots = getSlots();
        
        if (!slots.isEmpty()) {
            int slot = slots.get(random.nextInt(slots.size()));
            slots.remove(Integer.valueOf(slot));
            show(slot);
        } else finish();
    }
    
}
