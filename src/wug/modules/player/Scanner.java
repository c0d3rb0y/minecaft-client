package wug.modules.player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import wug.events.Event;
import wug.modules.render.TabGUI;
import wug.events.listeners.EventRenderGUI;
import wug.events.listeners.EventUpdate;
import wug.modules.Module;
import wug.modules.fun.Rainbow;

public class Scanner extends Module {

	public List<Integer> xlist = new ArrayList<Integer>();
	public List<Integer> ylist = new ArrayList<Integer>();
	public List<Integer> zlist = new ArrayList<Integer>();
	public List<Integer> pxlist = new ArrayList<Integer>();
	public List<Integer> pylist = new ArrayList<Integer>();
	public List<Integer> pzlist = new ArrayList<Integer>();
	
	public Scanner() {
		super("Scanner", Keyboard.KEY_O, Category.PLAYER);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if(e.isPre()) {
				xlist = new ArrayList<Integer>();
				ylist = new ArrayList<Integer>();
				zlist = new ArrayList<Integer>();
				for(Entity n : mc.world.loadedEntityList) {
					xlist.add((int)n.posX-(int)mc.player.posX);
					ylist.add((int)n.posY);
					zlist.add((int)n.posZ-(int)mc.player.posZ);
				}
			}
		}
		if (e instanceof EventRenderGUI) {
			ScaledResolution sr = new ScaledResolution(mc);
			Gui.drawRect(5, sr.getScaledHeight()-105, 105, sr.getScaledHeight()-5, 0x90000000);
			int i = 0;
			for(Integer x : xlist) {
				if(Rainbow.on)
					Gui.drawRect(x/2+56, zlist.get(i)/2 + sr.getScaledHeight()-58, x/2+58, zlist.get(i)/2+sr.getScaledHeight()-56, TabGUI.gscolor);
				else
					Gui.drawRect(x/2+56, zlist.get(i)/2 + sr.getScaledHeight()-58, x/2+58, zlist.get(i)/2+sr.getScaledHeight()-56, 0xff9000ff);
				i++;
			 Gui.drawRect(55, sr.getScaledHeight()-60, 60, sr.getScaledHeight()-55, 0xffffffff);
			}       
		}
	}
}
