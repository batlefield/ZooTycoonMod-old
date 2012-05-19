package net.minecraft.src.zoo.dimension;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Tessellator;
import net.minecraft.src.ZooDimension;
import net.minecraft.src.mod_ZooDimension;
import net.minecraft.src.BAPI.interfaces.IGameOverlay;

public class ZooPortalOverlay implements IGameOverlay {

	public void render(Minecraft mc, int height, int width, float partialTicks, boolean isDisplayingGUI) {
		if(mod_ZooDimension.isInPortal)
		{
	        float par1 = mc.thePlayer.prevTimeInPortal + (mc.thePlayer.timeInPortal - mc.thePlayer.prevTimeInPortal) * partialTicks;
			
			if (par1 < 1.0F)
	        {
	            par1 *= par1;
	            par1 *= par1;
	            par1 = par1 * 0.8F + 0.2F;
	        }
	
	        GL11.glDisable(GL11.GL_ALPHA_TEST);
	        GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(false);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, par1);
	        GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/zoo/dimension/blocks.png"));
	        float var4 = (float)(ZooDimension.portal.blockIndexInTexture % 16) / 16.0F;
	        float var5 = (float)(ZooDimension.portal.blockIndexInTexture / 16) / 16.0F;
	        float var6 = (float)(ZooDimension.portal.blockIndexInTexture % 16 + 1) / 16.0F;
	        float var7 = (float)(ZooDimension.portal.blockIndexInTexture / 16 + 1) / 16.0F;
	        Tessellator var8 = Tessellator.instance;
	        var8.startDrawingQuads();
	        var8.addVertexWithUV(0.0D, (double)width, -90.0D, (double)var4, (double)var7);
	        var8.addVertexWithUV((double)height, (double)width, -90.0D, (double)var6, (double)var7);
	        var8.addVertexWithUV((double)height, 0.0D, -90.0D, (double)var6, (double)var5);
	        var8.addVertexWithUV(0.0D, 0.0D, -90.0D, (double)var4, (double)var5);
	        var8.draw();
	        GL11.glDepthMask(true);
	        GL11.glEnable(GL11.GL_DEPTH_TEST);
	        GL11.glEnable(GL11.GL_ALPHA_TEST);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

}
