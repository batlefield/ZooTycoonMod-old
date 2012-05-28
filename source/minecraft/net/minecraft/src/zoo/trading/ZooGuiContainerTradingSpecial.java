package net.minecraft.src.zoo.trading;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.api.Trade;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ZooGuiContainerTradingSpecial extends GuiContainer
{

    private static InventoryBasic inventory = new InventoryBasic("tmp", 72);
    private float currentScroll;
    private boolean isScrolling;
    private boolean wasClicking;
    private Minecraft minecraft;

    public ZooGuiContainerTradingSpecial()
    {
        super(new ZooContainerTradingSpecial());
        minecraft = ModLoader.getMinecraftInstance();
        currentScroll = 0.0F;
        isScrolling = false;
        minecraft.thePlayer.craftingInventory = inventorySlots;
        allowUserInput = true;
        ySize = 208;
    }

    protected void handleMouseClick(Slot slot, int i, int j, boolean flag)
	{
		Trade.handleMouseClick(slot, minecraft, inventorySlots, inventory, j, flag);
	}

    public void drawScreen(int i, int j, float f)
    {
        boolean flag = Mouse.isButtonDown(0);
        int k = guiLeft;
        int l = guiTop;
        int i1 = k + 154;
        int j1 = l + 17;
        int k1 = i1 + 14;
        int l1 = j1 + 90;
        if(!wasClicking && flag && i >= i1 && j >= j1 && i < k1 && j < l1)
        {
            isScrolling = true;
        }
        if(!flag)
        {
            isScrolling = false;
        }
        wasClicking = flag;
        if(isScrolling)
        {
            currentScroll = (float)(j - (j1 + 8)) / ((float)(l1 - j1) - 16F);
            if(currentScroll < 0.0F)
            {
                currentScroll = 0.0F;
            }
            if(currentScroll > 1.0F)
            {
                currentScroll = 1.0F;
            }
            ((ZooContainerTradingSpecial)inventorySlots).scrollTo(currentScroll);
        }
        super.drawScreen(i, j, f);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int k = mc.renderEngine.getTexture("/zoo/gui/guiTrading.png");
        mc.renderEngine.bindTexture(k);
        int l = guiLeft;
        int i1 = guiTop;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        int j1 = l + 155;
        int k1 = i1 + 17;
        int l1 = k1 + 160 + 2;
        drawTexturedModalRect(l + 154, i1 + 17 + (int)((float)(l1 - k1 - 89) * currentScroll), 0, 208, 16, 16);
    }

    protected void drawGuiContainerForegroundLayer()
    {
        if(mod_ZooTrade.debug())
        {
            fontRenderer.drawString("You are in debug mode!", 8, 6, 0x404040);
        } else
        {
            fontRenderer.drawString("Hold P and click for price.", 8, 6, 0x404040);
        }
    }

    public void initGui()
    {
        super.initGui();
        controlList.clear();
        ZooContainerTradingSpecial.interact = true;
    }

    public void actionPerformed(GuiButton guibutton)
    {
        ZooContainerTradingSpecial zoo = ZooContainerTradingSpecial.instance;
    }

    public void onGuiClosed()
    {
        ZooContainerTradingSpecial.interact = false;
    }

    public void handleMouseInput()
    {
        super.handleMouseInput();
        int i = Mouse.getEventDWheel();
        if(i != 0 && ((ZooContainerTradingSpecial)inventorySlots).itemList.size() > 40)
        {
            int j = (((ZooContainerTradingSpecial)inventorySlots).itemList.size() / 8 - 5) + 1;
            if(i > 0)
            {
                i = 1;
            }
            if(i < 0)
            {
                i = -1;
            }
            currentScroll -= (double)i / (double)j;
            if(currentScroll < 0.0F)
            {
                currentScroll = 0.0F;
            }
            if(currentScroll > 1.0F)
            {
                currentScroll = 1.0F;
            }
            ((ZooContainerTradingSpecial)inventorySlots).scrollTo(currentScroll);
        }
    }


    static InventoryBasic getInventory()
    {
        return inventory;
    }

}
