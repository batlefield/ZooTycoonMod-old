package net.minecraft.src.zoo.trading;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.InventoryBasic;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.zoo.core.GUIIDEnum;

public class GUISafeUnlocked extends GuiContainer{

	private static TileEntitySafe safe;
	private static EntityPlayer player;
	public GuiButton lockButton;
	
	public GUISafeUnlocked(EntityPlayer player, TileEntitySafe safe) {
		super(new GuiContainerSafe(player, safe));
		this.safe = safe;
		this.player = player;
		ySize = 208;
	}

	public void initGui()
	{
		super.initGui();
		controlList.clear();
		controlList.add(lockButton = new GuiButton(1, (width / 2) - 80, (height / 2), 50, 20, "Lock"));
		controlList.add(new GuiButton(2, (width / 2) - 10 , (height / 2), 95, 20, "Change password"));
		
		controlList.add(new GuiButton(3, (width / 2) - 70, (height / 2) - 91, 25, 20, "+10"));
		controlList.add(new GuiButton(4, (width / 2) - 45, (height / 2) - 91, 30, 20, "+100"));
		controlList.add(new GuiButton(5, (width / 2) - 14, (height / 2) - 91, 35, 20, "+1000"));
		
		controlList.add(new GuiButton(6, (width / 2) - 70, (height / 2) - 70, 25, 20, "-10"));
		controlList.add(new GuiButton(7, (width / 2) - 45, (height / 2) - 70, 30, 20, "-100"));
		controlList.add(new GuiButton(8, (width / 2) - 14, (height / 2) - 70, 35, 20, "-1000"));
		
	}
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		int i =  mc.renderEngine.getTexture("/zoo/gui/guiSafeU.png");
		mc.renderEngine.bindTexture(i);
		int l = guiLeft;
        int i1 = guiTop;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        drawString(fontRenderer, "Your money $" + Trade.getMoney(), 140, 100, 0xFFFFFF);
        drawString(fontRenderer, "Stored money $" + safe.money, 140, 90, 0xFFFFFF);
	}
	
	protected void actionPerformed(GuiButton gb) {
		
		switch(gb.id){
		case 1:
			safe.locked = true;
			player.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SAFE_LOCKED.ID, safe.worldObj, safe.getX(), safe.getY(), safe.getZ());
			break;
		case 2:
			safe.locked = true;
			safe.setPassword = true;
			player.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SAFE_LOCKED.ID, safe.worldObj, safe.getX(), safe.getY(), safe.getZ());
			break;
		case 3:
			if(Trade.decreaseMoney(10))
			{
				safe.money += 10;
			}
			break;
		case 4:
			if(Trade.decreaseMoney(100))
			{
				safe.money += 100;
			}
			break;
		case 5:
			if(Trade.decreaseMoney(1000))
			{
				safe.money += 1000;
			}
			break;
		case 6:
			if(safe.money >= 10)
			{
				safe.money -= 10;
				Trade.increaseMoney(10);
			}
			break;
		case 7:
			if(safe.money >= 100)
			{
				safe.money -= 100;
				Trade.increaseMoney(100);
			}
			break;
		case 8:
			if(safe.money > 1000)
			{
				safe.money -= 1000;
				Trade.increaseMoney(1000);
			}
			break;
		}
	}
	
	public boolean doesGuiPauseGame()
    {
        return false;
    }
	
}
