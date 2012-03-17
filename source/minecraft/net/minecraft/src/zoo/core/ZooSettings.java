package net.minecraft.src.zoo.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import net.minecraft.client.Minecraft;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;

public class ZooSettings {
	
	private static Minecraft mc = ModLoader.getMinecraftInstance();
	private File options = new File(mc.getMinecraftDir(), "/Zoo/Options.txt");
	
	public boolean generateBiomesInOver;
	public boolean version;
	
	public ZooSettings()
	{
		generateBiomesInOver = false;
		version = false;
		
		loadOptions();
	}
	
	public void loadOptions()
    {
        try
        {
            if (!options.exists())
            {
                return;
            }

            BufferedReader var1 = new BufferedReader(new FileReader(options));
            String var2 = "";

            while ((var2 = var1.readLine()) != null)
            {
                try
                {
                    String[] var3 = var2.split(":");

                    if (var3[0].equals("biomes"))
                    {
                        generateBiomesInOver = var3[1].equals("true");
                    }
                    if (var3[0].equals("version"))
                    {
                        version = var3[1].equals("true");
                    }
                }
                catch (Exception var5)
                {
                    System.out.println("Skipping bad option: " + var2);
                }
            }

            KeyBinding.resetKeyBindingArrayAndHash();
            var1.close();
        }
        catch (Exception var6)
        {
            System.out.println("Failed to load options");
            var6.printStackTrace();
        }
    }
	
	public void saveOptions()
    {
    	try
        {
            PrintWriter var1 = new PrintWriter(new FileWriter(options));
            var1.println("biomes:" + generateBiomesInOver);
            var1.println("version:" + version);

            var1.close();
        }
        catch (Exception var3)
        {
            System.out.println("Failed to save options");
            var3.printStackTrace();
        }
    }
}
