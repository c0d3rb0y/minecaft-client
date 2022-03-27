package wug.modules.fun;

import org.lwjgl.input.Keyboard;

import wug.events.Event;
import wug.events.listeners.EventChat;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class UwUifier extends Module {

	public static boolean on = false;
	
	public UwUifier() {
		super("UwUChat", Keyboard.KEY_NONE, Category.FUN);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventChat) {
			((EventChat)e).setMessage(((EventChat)e).getMessage().toLowerCase().replace("l", "w").replace("r", "w").replace("o", "u").replace("p", "pw").replace("'", "").replace(",", "").replace("su", "so").replace("tuu", "2").replace("hewwu", "hewwo").replace("yuu", "u") + " uwu");
		}
	}
}
