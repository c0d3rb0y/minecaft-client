package wug.modules.render;

import java.awt.Color;
import java.util.List;

import org.lwjgl.input.Keyboard;
import wug.Client;
import net.minecraft.client.gui.Gui;
import wug.events.Event;
import wug.events.listeners.EventKey;
import wug.events.listeners.EventRenderGUI;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;
import wug.modules.fun.Rainbow;

public class TabGUI extends Module {
	
	public int currentTab, moduleIndex;
	public boolean expanded;
	public static int gscolor;
	public static float gshue;
	
	public TabGUI() {
		super("TabGUI", Keyboard.KEY_NONE, Category.RENDER);
		toggled = true;
	}
	
	public void text(String text, Integer x, Integer y, Integer color) {
		mc.fontRendererObj.drawString(text, x+1, y+1, 1);
		mc.fontRendererObj.drawString(text, x, y, color);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventRenderGUI){
			
			float hue = (System.currentTimeMillis() % 5000)/5000f;
			int color = Color.HSBtoRGB(hue, 1, 1);
			gscolor = color;
			gshue=hue;
			
			Gui.drawRect(4, mc.fontRendererObj.FONT_HEIGHT + 70, 100,  mc.fontRendererObj.FONT_HEIGHT + 14, 0x90000000);
			if(!expanded) {
				if(Rainbow.on)
					Gui.drawRect(5, mc.fontRendererObj.FONT_HEIGHT*2 + 4 + currentTab*(mc.fontRendererObj.FONT_HEIGHT+2), 100, mc.fontRendererObj.FONT_HEIGHT*3 + 5 + currentTab*(mc.fontRendererObj.FONT_HEIGHT+2), color);
				else
					Gui.drawRect(5, mc.fontRendererObj.FONT_HEIGHT*2 + 4 + currentTab*(mc.fontRendererObj.FONT_HEIGHT+2), 100, mc.fontRendererObj.FONT_HEIGHT*3 + 5 + currentTab*(mc.fontRendererObj.FONT_HEIGHT+2), 0xff3454d1);
			}
			List<Module> modules = Client.getModulesByCategory(Category.values()[currentTab]);
			int i = 1;
			for(Category c : Module.Category.values()) {
				text(c.name, 5, mc.fontRendererObj.FONT_HEIGHT + 4 + i*(mc.fontRendererObj.FONT_HEIGHT+2), -1);
				i++;
			}
			
			
			
			if(expanded) {
				Gui.drawRect(104, mc.fontRendererObj.FONT_HEIGHT + 70, 200,  mc.fontRendererObj.FONT_HEIGHT + 14, 0x90000000);
				if(Rainbow.on)
					Gui.drawRect(105, mc.fontRendererObj.FONT_HEIGHT*2 + 4 + moduleIndex*(mc.fontRendererObj.FONT_HEIGHT+2), 200, mc.fontRendererObj.FONT_HEIGHT*3 + 5 + moduleIndex*(mc.fontRendererObj.FONT_HEIGHT+2), color);
				else
					Gui.drawRect(105, mc.fontRendererObj.FONT_HEIGHT*2 + 4 + moduleIndex*(mc.fontRendererObj.FONT_HEIGHT+2), 200, mc.fontRendererObj.FONT_HEIGHT*3 + 5 + moduleIndex*(mc.fontRendererObj.FONT_HEIGHT+2), 0xff3454d1);
				int i2 = 1;
				for(Module m : modules) {
					text(m.name, 105, mc.fontRendererObj.FONT_HEIGHT + 4 + i2*(mc.fontRendererObj.FONT_HEIGHT+2), -1);
					i2++;
			}
			}
		}
		if (e instanceof EventKey) {
			int key = ((EventKey)e).key;
			List<Module> modules = Client.getModulesByCategory(Category.values()[currentTab]);
			if(!expanded) {
			if(key == Keyboard.KEY_UP) {
				if(currentTab <= 0) {
				currentTab = Module.Category.values().length - 1;
				}else {
					currentTab--;
				}
			}
			if(key == Keyboard.KEY_DOWN) {
				if(currentTab >= Module.Category.values().length - 1) {
					currentTab = 0;
				}else {
					currentTab++;
				}
			}
			}else {
				if(key == Keyboard.KEY_UP) {
					if(moduleIndex <= 0) {
					moduleIndex = modules.size() - 1;
					}else {
						moduleIndex--;
					}
				}
				if(key == Keyboard.KEY_DOWN) {
					if(moduleIndex >= modules.size() - 1) {
						moduleIndex = 0;
					}else {
						moduleIndex++;
					}
			}
			}
			if(key == Keyboard.KEY_RIGHT) {
				if(expanded && modules.get(moduleIndex).name != "TabGUI") {
					modules.get(moduleIndex).toggle();
				}else {
				expanded = true;
				}
			}
			if(key == Keyboard.KEY_LEFT) {
				moduleIndex = 0;
				expanded = false;
			}
			
		}
	}
}
