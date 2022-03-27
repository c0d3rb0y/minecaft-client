package wug.modules.movement;

import org.lwjgl.input.Keyboard;

import wug.events.Event;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class Frog extends Module {

	public static boolean on = false;
	
	public Frog() {
		super("Frog", Keyboard.KEY_Y, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if(mc.player.isInWater()) {
				mc.player.jump();
			}
		}
	}
	
	public void onEnable() {
		on = true;
	}
	
	public void onDisable() {
		on = false;
	}
}
