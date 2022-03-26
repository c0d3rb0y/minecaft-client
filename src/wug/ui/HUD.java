package wug.ui;

import java.util.Comparator;
import wug.modules.render.TabGUI;
import wug.modules.fun.Rainbow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import wug.Client;
import wug.events.listeners.EventRenderGUI;
import wug.modules.Module;

public class HUD {
	public Minecraft mc = Minecraft.getMinecraft();
	
	public void text(String text, Integer x, Integer y, Integer color) {
		mc.fontRendererObj.drawString(text, x+1, y+1, 1);
		mc.fontRendererObj.drawString(text, x, y, color);
	}
	
	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc);
		
		Client.modules.sort(Comparator.comparingInt(m -> mc.fontRendererObj.getStringWidth(((Module)m).name)).reversed());
		
		text(Client.name + " " + Client.v + " - X:" + (int)mc.player.posX + " Y:" + (int)mc.player.posY + " Z:" + (int)mc.player.posZ, 3, 3, -1);
		int i = 9;
		for(Module m : Client.modules) {
			if(m.toggled && m.name != "TabGUI") {
			
			Gui.drawRect(sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.name) - 7, i - 2, sr.getScaledWidth(), i + mc.fontRendererObj.FONT_HEIGHT + 1, 0x90252525 );
			
			if(Rainbow.on)
				mc.fontRendererObj.drawString(m.name, sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.name) - 3, i, TabGUI.gscolor);
			else
				mc.fontRendererObj.drawString(m.name, sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.name) - 3, i, -1);

			i += 12;
			}
		}
	
		
	Client.onEvent(new EventRenderGUI());
	}
}
