package net.minecraft.src.zoo.core.entities;

import net.minecraft.src.*;

public class ZooVisitorFemale extends EntityCreature{
	
    public ZooVisitorFemale(World world)
    {
        super(world);
        moveSpeed = 0.5F;
        texture = "/zoo/modells/girl npc.png";
    }

	public int getMaxHealth()
    {
        return 20;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected boolean canDespawn()
    {
        return false;
    }

}
