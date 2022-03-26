package wug.modules.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.CPacketPlayer;
import wug.events.Event;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;

public class NoFall extends Module {

	public NoFall() {
		super("NoFall", Keyboard.KEY_H, Category.PLAYER);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.player.fallDistance > 2) {
					mc.player.connection.sendPacket(new CPacketPlayer(true));
				}
			}
		}
	}
}
