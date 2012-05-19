package net.minecraft.src.zoo.trading;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;

public class GUIShop extends GuiScreen{
	
	private static TileEntityShop shopTile;
	
	public GUIShop(TileEntityShop tile)
	{
		shopTile = tile;
	}
	
	public void drawScreen(int mousePosX, int mousePosY, float partialTick)
    {
		drawDefaultBackground();
		fontRenderer.drawString("Test", 100, 100, 0xFFFFFF);
		int tex = mc.renderEngine.getTexture("/zoo/gui/guiShop.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(tex);

		super.drawScreen(mousePosX, mousePosY, partialTick);
    }
	
	protected void mouseClicked(int x, int y, int button)
    {
        super.mouseClicked(x, y, button);
        
        if(button == 0 || button == 1)
        {
        	
        }
        
    }
	
	public boolean doesGuiPauseGame()
    {
        return false;
    }

}
