package wug;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.lwjgl.opengl.Display;

import wug.events.Event;
import wug.events.listeners.EventKey;
import wug.modules.Module;
import wug.modules.Module.Category;
import wug.modules.combat.KillAura;
import wug.modules.fun.Rainbow;
import wug.modules.movement.Fly;
import wug.modules.movement.Sprint;
import wug.modules.player.NoFall;
import wug.modules.render.Fullbright;
import wug.modules.render.TabGUI;
import wug.ui.HUD;

public class Client {

	public static String name = "WugClient";
	public static String v = "1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	
	
	public static void start() {
		System.out.println("Starting "+ name + " " + v);
		Display.setTitle(name + " " + v);
		
		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new Fullbright());
		modules.add(new NoFall());
		modules.add(new TabGUI());
		modules.add(new KillAura());
		modules.add(new Rainbow());
	}
	
	public static void onEvent(Event e) {
		for(Module m : modules) {
			if (!m.toggled)
				continue;
			
			m.onEvent(e);
		}
	}
	
	public static void keyPress(int key) {
		Client.onEvent(new EventKey(key));
		for(Module m : modules) {
			if(m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Client.modules) {
			if(m.category == c) {
				modules.add(m);
			}
		}
		
		return modules;
	}
}