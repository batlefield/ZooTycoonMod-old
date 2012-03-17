package net.minecraft.src.zoo.dimension;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.WorldProviderBase;
import net.minecraft.src.ZooDimension;

public class WorldProviderZoo extends WorldProviderBase{

	public int getDimensionID() {
		return ZooDimension.dimensionId;
	}
	
	public boolean renderClouds()
    {
        return true;
    }

    public boolean renderVoidFog()
    {
        return false;
    }

    public boolean renderStars()
    {
        return true;
    }

    public boolean darkenSkyDuringRain()
    {
        return false;
    }

    public String getRespawnMessage()
    {
        return "Hmm... let me help you by respawning into normal world.";
    }
    
    public void registerWorldChunkManager()
    {
        worldChunkMgr = new ZooChunkManager(worldObj);
    }
        
    public IChunkProvider getChunkProvider()
    {
        return new ZooChunkProvider(worldObj, worldObj.getSeed(), true);
    }

	public String getSaveFolder() {
		return "DIM" + ZooDimension.dimensionId;
	}

	public String getWelcomeMessage() {
		return "Entering Zoo dimension";
	}

	public String getDepartMessage() {
		return "Leaving Zoo dimension";
	}

}
