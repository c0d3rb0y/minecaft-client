package wug.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.network.play.client.CPacketUseEntity;
import wug.events.Event;
import wug.events.listeners.EventMotion;
import wug.modules.Module;
import wug.util.Timer;

public class CrystalAura extends Module {

	public Timer timer = new Timer();
	
	public CrystalAura() {
		super("CrystalAura", Keyboard.KEY_NONE, Category.COMBAT);
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventMotion) {
			if(e.isPre()) {

				List<Entity> targets = mc.world.loadedEntityList.stream().filter(EntityEnderCrystal.class::isInstance).collect(Collectors.toList());
				
				targets = targets.stream().filter(ent -> ent.getDistanceToEntity(mc.player) < 4 && ent != mc.player).collect(Collectors.toList());
				
				targets.sort(Comparator.comparingDouble(ent -> ((EntityLivingBase)ent).getDistanceToEntity(mc.player)));
				
				if(!targets.isEmpty()) {
					Entity target = targets.get(0);
					
					if(timer.hasTimeElapsed(1000/10, true))
					mc.player.connection.sendPacket(new CPacketUseEntity(target));
				}
			}
		}
	}
	
	public void onEnable() {

	}
	
	public void onDisable() {
		
	}
}
