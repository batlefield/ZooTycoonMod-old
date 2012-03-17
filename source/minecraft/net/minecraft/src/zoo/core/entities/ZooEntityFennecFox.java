package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;


public class ZooEntityFennecFox extends ZooEntityAnimal
{
	
	public EntityLiving roped;

    public ZooEntityFennecFox(World world)
    {
        super(world);
        texture = "/zoo/modells/fennec fox.png";
        setSize(0.75F, 1F);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected String getLivingSound()
    {
        return null;
    }

    protected String getHurtSound()
    {
        return null;
    }

    protected String getDeathSound()
    {
        return null;
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected int getDropItemId()
    {
        return 287;
    }
    
    protected ZooEntityAnimal spawnBabyAnimal(ZooEntityAnimal entityanimal) {
		return new ZooEntityFennecFox(worldObj);
	}

	public int getMaxHealth() {
		return 10;
	}
	
	public int getMaxHunger() {
		return 10;
	}
}