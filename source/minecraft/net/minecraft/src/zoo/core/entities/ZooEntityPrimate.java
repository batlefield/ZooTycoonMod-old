package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;

public class ZooEntityPrimate extends ZooNeutralMob
{

    public ZooEntityPrimate(World world)
    {
        super(world);
        texture = "/zoo/modells/chimp.png";
        setSize(1.5F, 1.8F);
    }

    public EntityLiving roped;
    
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

    public ItemStack dropMeat()
    {
        return new ItemStack(Zoo.meat, 1, 2);
    }
    
    protected ZooNeutralMob spawnBabyAnimal(ZooNeutralMob entityanimal) {
		return new ZooEntityPrimate(worldObj);
	}

	public int getMaxHealth() {
		return 10;
	}
	
	public int getMaxHunger() {
		return 10;
	}
}