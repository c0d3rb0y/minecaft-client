package wug.modules.render;

import org.lwjgl.input.Keyboard;

import wug.events.Event;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class BlurBG extends Module {

	public static boolean on = false;
	
	public BlurBG() {
		super("BlurBG", Keyboard.KEY_NONE, Category.RENDER);
	}
	
	public void onEnable() {
		on = true;
	}
	
	public void onDisable() {
		on = false;
	}
}
