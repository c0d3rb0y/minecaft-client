package wug.util;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;

public class RenderUtil {

	public static void entityESPBox(Entity entity, Color c) {
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glColor4f(c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f);
		RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
		RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(
				entity.boundingBox.minX - 0.05 - entity.posX + (entity.posX - renderManager.renderPosX),
				entity.boundingBox.minY - entity.posY + (entity.posY - renderManager.renderPosY),
				entity.boundingBox.minZ - 0.05 - entity.posZ + (entity.posZ - renderManager.renderPosZ),
				entity.boundingBox.maxX + 0.05 - entity.posX + (entity.posX - renderManager.renderPosX),
				entity.boundingBox.maxY + 0.1 - entity.posY + (entity.posY - renderManager.renderPosY),
				entity.boundingBox.maxZ + 0.05 - entity.posZ + (entity.posZ - renderManager.renderPosZ)), c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}
}
