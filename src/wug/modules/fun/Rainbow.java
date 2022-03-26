package wug.modules.fun;

import org.lwjgl.input.Keyboard;

import wug.events.Event;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class Rainbow extends Module {

	public static boolean on = false;
	
	public Rainbow() {
		super("Rainbow", Keyboard.KEY_NONE, Category.FUN);
	}
	
	public void onEnable() {
		on = true;
	}
	
	public void onDisable() {
		on = false;
	}
}
