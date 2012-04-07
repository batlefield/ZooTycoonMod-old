package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;


public class ZooVisitorMale extends EntityCreature
{
	
    public ZooVisitorMale(World world)
    {
        super(world);
        texture = "/zoo/modells/npcs/npc1.png";
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

	public int getMaxHealth() {
		return 10;
	}
}