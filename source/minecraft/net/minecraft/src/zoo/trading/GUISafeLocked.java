package net.minecraft.src.zoo.trading;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.zoo.core.GUIIDEnum;

import org.lwjgl.input.Keyboard;

public class GUISafeLocked extends GuiScreen
{
	private EntityPlayer player;
	private TileEntitySafe safe;
	private GuiTextField passWindow;
	protected int xSize = 176;
	protected int ySize = 129;
	protected int guiLeft;
	protected int guiTop;

	public GUISafeLocked(EntityPlayer player, TileEntitySafe safe)
	{
		this.player = player;
		this.safe = safe;
	}

	public void initGui()
	{
		Keyboard.enableRepeatEvents(true);
		guiLeft = (width - xSize) / 2;
		guiTop = (height - ySize) / 2;

		String s = "Unlock";
		if (safe.setPassword)
		{
			s = "Set password";
		}

		controlList.clear();
		controlList.add(new GuiButton(1, (width / 2) - 35, (height / 2) + 35, 70, 20, s));

		passWindow = new GuiTextField(fontRenderer, (width / 2) - 50, 76, 100, 20);
		passWindow.setFocused(true);
		passWindow.setMaxStringLength(15);
	}

	public void onGuiClosed()
	{
		Keyboard.enableRepeatEvents(false);
	}

	public void drawScreen(int mousePosX, int mousePosY, float partialTick)
	{
		int i = mc.renderEngine.getTexture("/zoo/gui/guiSafeL.png");
		mc.renderEngine.bindTexture(i);
		int l = guiLeft;
		int i1 = guiTop;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);

		passWindow.drawTextBox();
		super.drawScreen(mousePosX, mousePosY, partialTick);
	}

	protected void keyTyped(char par1, int par2)
	{
		passWindow.textboxKeyTyped(par1, par2);

		if (par1 == 13)
		{
			this.actionPerformed((GuiButton) this.controlList.get(0));
		}

		if (par2 == 1)
		{
			mc.displayGuiScreen((GuiScreen) null);
			mc.setIngameFocus();
		}
	}

	protected void actionPerformed(GuiButton gb)
	{
		if (gb.id == 1)
		{
			if (safe.setPassword)
			{
				if(MathHelper.stringNullOrLengthZero(safe.username))
				{
					safe.username = mc.thePlayer.username;
				}
				safe.password = passWindow.getText();
				safe.setPassword = false;
				safe.locked = false;
				player.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SAFE_UNLOCKED.ID, safe.worldObj, safe.getX(), safe.getY(), safe.getZ());
			} else
			{
				if (safe.password.equals(passWindow.getText()))
				{
					safe.locked = false;
					player.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SAFE_UNLOCKED.ID, safe.worldObj, safe.getX(), safe.getY(), safe.getZ());
				} else
				{
					player.addChatMessage("Incorrect password");
				}
			}
		}
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		passWindow.mouseClicked(par1, par2, par3);
	}

	public void updateScreen()
	{
		passWindow.updateCursorCounter();
	}

}
