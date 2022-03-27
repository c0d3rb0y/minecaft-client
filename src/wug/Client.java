package wug;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.lwjgl.opengl.Display;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import wug.command.CommandManager;
import wug.events.Event;
import wug.events.listeners.EventChat;
import wug.events.listeners.EventKey;
import wug.modules.Module;
import wug.modules.Module.Category;
import wug.modules.combat.CrystalAura;
import wug.modules.combat.KillAura;
import wug.modules.fun.Rainbow;
import wug.modules.fun.UwUifier;
import wug.modules.movement.Fly;
import wug.modules.movement.Frog;
import wug.modules.movement.Sprint;
import wug.modules.player.NoFall;
import wug.modules.player.Scanner;
import wug.modules.render.BlurBG;
import wug.modules.render.ESP;
import wug.modules.render.Fullbright;
import wug.modules.render.TabGUI;
import wug.ui.HUD;

public class Client {

	public static String name = "WugClient";
	public static String v = "1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	public static CommandManager cmd = new CommandManager();
	
	
	public static void start() {
		System.out.println("Starting "+ name + " " + v);
		Display.setTitle(name + " " + v);
		Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new Fullbright());
		modules.add(new NoFall());
		modules.add(new TabGUI());
		modules.add(new KillAura());
		modules.add(new CrystalAura());
		modules.add(new Rainbow());
		modules.add(new Frog());
		modules.add(new UwUifier());
		modules.add(new Scanner());
		modules.add(new BlurBG());
		modules.add(new ESP());
	}
	
	public static void onEvent(Event e) {
		if (e instanceof EventChat){
			cmd.handleChat((EventChat)e);
		}
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
	
	public static void addChatMessage(String message) {
		message = "§9[" + name + "]§f " + message;
		Minecraft.getMinecraft().player.addChatMessage(new TextComponentString(message));
	}
}