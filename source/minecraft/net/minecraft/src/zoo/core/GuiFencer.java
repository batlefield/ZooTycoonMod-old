package net.minecraft.src.zoo.core;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.BAPI.ItemKey;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.trading.Trade;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiFencer extends GuiScreen
{

	private static TileEntityFencer tile;
	private int xStart;
	private int yStart;
	private static final int arrowSizeX = 23;
	private static final int arrowSizeY = 15;
	

	public GuiFencer(TileEntityFencer tile, EntityPlayer player)
	{
		this.tile = tile;
	}

	public void initGui()
	{
		controlList.clear();
		controlList.add(new GuiButton(1, (width / 2) - 80, (height / 2) + 23, 17, 20, "<<"));
		controlList.add(new GuiButton(2, (width / 2) - 28, (height / 2) + 23, 17, 20, ">>"));
		controlList.add(new GuiButton(3, (width / 2) - 40, (height / 2) + 65, 80, 20, "Generate"));
		
		initStacks();
	}
	
	private void initStacks()
	{
		tile.currentFence = tile.createStack((ItemKey) Fence.getFence().get(tile.currentFenceIndex));
		tile.currentBlock = tile.createStack((ItemKey) Fence.getDirts().get(tile.currentBlockIndex));
	}

	protected void actionPerformed(GuiButton gb)
	{
		if (gb.id == 1)
		{
			if(tile.sizeIndex > 0)
			{
				tile.sizeIndex--;
			}
		}
		if(gb.id == 2)
		{
			if(tile.sizeIndex < tile.availableSizes.length - 1)
			{
				tile.sizeIndex++;
			}
		}
		if(gb.id == 3)
		{
			tile.generate();
			mc.displayGuiScreen((GuiScreen)null);
            mc.setIngameFocus();
		}
	}

	public void drawScreen(int mousePosX, int mousePosY, float partialTick)
	{
		drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int tex = mc.renderEngine.getTexture("/zoo/gui/guiFencer.png");
		mc.renderEngine.bindTexture(tex);
		int left = (width - 176) / 2;
		int top = (height - 166) / 2;
		xStart = left + 3;
		yStart = top + 15;
		drawTexturedModalRect(left, top, 0, 0, 176, 176);
		
		drawTexturedModalRect((width / 2) - (arrowSizeX / 2) + 20, yStart + 6, 0, 176, arrowSizeX, arrowSizeY);
		drawTexturedModalRect((width / 2) - (arrowSizeX / 2) - 21, yStart + 6, 24, 176, arrowSizeX, arrowSizeY);
		
		drawTexturedModalRect((width / 2) - (arrowSizeX / 2) + 20, yStart + 57, 0, 176, arrowSizeX, arrowSizeY);
		drawTexturedModalRect((width / 2) - (arrowSizeX / 2) - 21, yStart + 57, 24, 176, arrowSizeX, arrowSizeY);
		
		String s = StatCollector.translateToLocal(tile.currentBlock.getItem().getItemName() + ".name");
		
		drawString(fontRenderer, "Selected soil: " + s, (width / 2) - (mc.fontRenderer.getStringWidth("Selected soil: " + s) / 2), (height / 2) - 40, 0xFFFFFF);
		
		s = StatCollector.translateToLocal(tile.currentFence.getItem().getItemName() + ".name");
		
		drawString(fontRenderer, "Selected fence: " + s, (width / 2) - (mc.fontRenderer.getStringWidth("Selected fence: " + s) / 2), (height / 2) + 10, 0xFFFFFF);
		
		int size = tile.availableSizes[tile.sizeIndex];
		
		drawString(fontRenderer, size + "x" + size, (width / 2) - 61, (height / 2) + 29, 0xFFFFFF);
		
		int price = size * size * Trade.getPrice(tile.currentBlock) + 4 * size * 2 * Trade.getPrice(tile.currentFence) + size * 4 * Trade.getPrice(new ItemStack(Block.torchWood));
		
		drawString(fontRenderer, "Price: $" + price, (width / 2) + 10, (height / 2) + 29, 0xFFFFFF);
		
		RenderItem ri = new RenderItem();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		ri.renderItemIntoGUI(fontRenderer, mc.renderEngine, tile.currentFence, (width / 2) - 8, (height / 2) - 11);
		ri.renderItemIntoGUI(fontRenderer, mc.renderEngine, tile.currentBlock, (width / 2) - 8, (height / 2) - 62);
		RenderHelper.disableStandardItemLighting();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		super.drawScreen(mousePosX, mousePosY, partialTick);
	}

	protected void mouseClicked(int x, int y, int button)
	{
		super.mouseClicked(x, y, button);

		if (button == 0 || button == 1)
		{
			int x1 = (width / 2) - (arrowSizeX / 2) + 20;
			int x2 = (width / 2) - (arrowSizeX / 2) - 21;
			int y1 = yStart + 6;
			int y2 = yStart + 57;
			if(isInside(x1, y1, x, y))
			{
				tile.incrementBlockIndex();
				mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			}
			if(isInside(x2, y1, x, y))
			{
				tile.decrementBlockIndex();
				mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			}
			if(isInside(x1, y2, x, y))
			{
				tile.incrementFenceIndex();
				mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			}
			if(isInside(x2, y2, x, y))
			{
				tile.decrementFenceIndex();
				mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			}
		}

	}
	
	private boolean isInside(int x, int y, int xm, int ym)
	{
		int x1 = x + arrowSizeX;
		int y1 = y + arrowSizeY;
		if(xm >= x && xm <= x1)
		{
			if(ym >= y && ym <= y1)
			{
				return true;
			}
		}
		return false;
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
