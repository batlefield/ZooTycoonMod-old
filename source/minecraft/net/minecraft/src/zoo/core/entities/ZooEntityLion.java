package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;


public class ZooEntityLion extends ZooDangerousMob
{
	
	public EntityLiving roped;

    public ZooEntityLion(World world)
    {
        super(world);
        texture = "/zoo/modells/lion.png";
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
    
    protected ZooDangerousMob spawnBabyAnimal(ZooDangerousMob zdm) {
		return new ZooEntityLion(worldObj);
	}

	public int getMaxHealth() {
		return 10;
	}
	
	public int getMaxHunger() {
		return 10;
	}
}