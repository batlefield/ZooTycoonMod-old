package net.minecraft.src.zoo.dimension;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.WorldProvider;

public class WorldProviderZoo extends WorldProvider{

	public String getSaveFolder() {
		return "Zoo";
	}

	public String getWelcomeMessage() {
		return "Entering Zoo dimension";
	}

	public String getDepartMessage() {
		return "Leaving zoo dimension";
	}

    
    public void registerWorldChunkManager()
    {
        worldChunkMgr = new ZooChunkManager(worldObj);
    }
    
    public double getMovementFactor()
    {
        return 1.0;
    }
        
    public IChunkProvider getChunkProvider()
    {
        return new ZooChunkProvider(worldObj, worldObj.getSeed(), true);
    }

}
