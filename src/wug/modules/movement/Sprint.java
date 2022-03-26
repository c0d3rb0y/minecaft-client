package wug.modules.movement;

import org.lwjgl.input.Keyboard;

import wug.events.Event;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", Keyboard.KEY_V, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.player.setSprinting(true);	
			}
		}
	}
	
	public void onEnable() {

	}
	
	public void onDisable() {
		mc.player.setSprinting(false);
	}
}
