package wug.modules.movement;

import org.lwjgl.input.Keyboard;

import wug.events.Event;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.player.capabilities.isFlying = true;
			}
		}
	}
	
	public void onEnable() {
		mc.player.jump();
	}
	
	public void onDisable() {
		mc.player.capabilities.isFlying = false;
	}
}
