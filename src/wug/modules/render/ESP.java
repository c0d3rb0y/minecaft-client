package wug.modules.render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import wug.events.Event;
import wug.events.listeners.EventRender;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;
import wug.modules.fun.Rainbow;
import wug.util.RenderUtil;

public class ESP extends Module {

	public ESP() {
		super("ESP", Keyboard.KEY_NONE, Category.RENDER);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventRender) {
				for(Entity n : mc.world.loadedEntityList) {
					if (n != (Entity)mc.player) {
					if (Rainbow.on)
						RenderUtil.entityESPBox(n, Color.getHSBColor(TabGUI.gshue, 1, 1));
					else
						RenderUtil.entityESPBox(n, Color.green);
			}}
		}
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
}
