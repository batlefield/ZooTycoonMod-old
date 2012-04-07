package net.minecraft.src.zoo.core;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import net.minecraft.src.GuiAchievements;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiStats;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModLoader;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class GuiOptions extends GuiScreen
{
    private int updateCounter2 = 0;
    private int updateCounter = 0;
    
    private GuiButton biomesButton;
    
    private ZooSettings settings = new ZooSettings();

    public void initGui()
    {
        updateCounter2 = 0;
        controlList.clear();
        byte var1 = -16;
        
        controlList.add(biomesButton = new GuiButton(5, width / 2 - 130, height / 4 + 48 + var1, 120, 20, "Generate biomes: " + settings.generateBiomesInOver));
        controlList.add(new GuiButton(6, width / 2 + 10, height / 4 + 48 + var1, 120, 20, "Version check: " + settings.version));
        
        /*controlList.add(new GuiButton(5, width / 2 - 130, height / 4 + 68 + var1, 120, 20, "Generate biomes: " + settings.generateBiomesInOver));
        controlList.add(new GuiButton(6, width / 2 + 10, height / 4 + 68 + var1, 120, 20, "Version check: " + settings.version));*/

        controlList.add(new GuiButton(4, width / 2 - 100, height / 4 + 150 + var1, StatCollector.translateToLocal("menu.returnToGame")));
    }

    protected void actionPerformed(GuiButton button)
    {
    	if(button.id == 5)
    	{
    		settings.generateBiomesInOver = !settings.generateBiomesInOver;
    		settings.saveOptions();
    		initGui();
    	}
    	if(button.id == 6)
    	{
    		settings.version = !settings.version;
    		settings.saveOptions();
    		initGui();
    	}
    	if (button.id == 4)
        {
            mc.displayGuiScreen((GuiScreen)null);
            mc.setIngameFocus();
        }
    }

    public void updateScreen()
    {
        super.updateScreen();
        updateCounter++;
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, "Zoo options", width / 2, 40, 16777215);
        super.drawScreen(par1, par2, par3);
    }
}
