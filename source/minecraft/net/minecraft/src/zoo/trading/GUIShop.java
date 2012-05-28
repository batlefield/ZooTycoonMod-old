package net.minecraft.src.zoo.trading;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.forge.MinecraftForge;

import org.lwjgl.opengl.GL11;

public class GUIShop extends GuiScreen{
	
	private static TileEntityShop shopTile;
	private int xStart;
    private int yStart;
    private static final int xStartOff = 3;
    private static final int yStartOff = 6;
    private static final int boxsizeY = 15;
    private static final int boxsizeX = 117;
	
	public GUIShop(TileEntityShop tile)
	{
		shopTile = tile;
	}
	
	public void initGui() {
		
		controlList.add(new GuiButton(100, (width / 2) - 40, (height / 2) + 65, 80, 20, "Generate"));
		
	}
	
	protected void actionPerformed(GuiButton gb) {
		if(gb.id == 100 && shopTile.isTypeValid(shopTile.getType()))
		{
			shopTile.generate(shopTile.getType());
			mc.displayGuiScreen((GuiScreen)null);
            mc.setIngameFocus();
		}
	}
	
	public void drawScreen(int mousePosX, int mousePosY, float partialTick)
    {
		drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int tex = mc.renderEngine.getTexture("/zoo/gui/guiShop.png");
		mc.renderEngine.bindTexture(tex);
		int left = (width - 176) / 2;
		int top = (height - 166) / 2;
		xStart = left + 3;
		yStart = top + 15;
		drawTexturedModalRect(left, top, 0, 0, 176, 176);
		
		String[] types = shopTile.getTypesAsString();
		
		for(int i = 0; i < types.length; i++)
		{
			mc.fontRenderer.drawStringWithShadow(types[i], (width / 2) - (mc.fontRenderer.getStringWidth(types[i]) / 2), yStart + (i * 15), 0xffffff);
		}
		
		mc.renderEngine.bindTexture(tex);
		if(shopTile.getType() >= 0)
		{
			drawTexturedModalRect((width / 2) - (boxsizeX / 2), yStart + (15 * shopTile.getType()) - 3, 0, 176, boxsizeX, boxsizeY);
		}
		
		super.drawScreen(mousePosX, mousePosY, partialTick);
    }
	
	protected void mouseClicked(int x, int y, int button)
    {
        super.mouseClicked(x, y, button);
        
        if(button == 0 || button == 1)
        {
        	x -= xStart;
            y -= yStart;

            if (x >= 0 && y >= 0)
            {
                x /= boxsizeX;
                y /= boxsizeY;

                if (x >= 0 && x < 1)
                {
                    int var4 = x + y * 1;

                    if (var4 >= 0 && var4 < shopTile.getTypesAsString().length)
                    {
                    	if(shopTile.getType() != var4)
                    	{
                        	shopTile.setType(var4);
                        	mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
                    	}
                    }
                }
            }
        }
        
    }
	
	public boolean doesGuiPauseGame()
    {
        return false;
    }

}
