package wug.ui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen {
	
	public static String splashtext = "l bozo";
	
	public MainMenu() {
		
	}
	
	public void initGui() {
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("wug.jpg"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
	}
	
	public void mouseClicked(int mouseX, int mouseY, int button) {
		
	}
	
	public void onGuiClosed() {
		
	}
}
