package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;


public class ZooEntityAfricanWDog extends ZooEntityAnimal
{

    public ZooEntityAfricanWDog(World world, boolean flag)
    {
        super(world, flag);
        texture = "/zoo/modells/african wild dog.png";
        setSize(0.75F, 0.5F);
    }
    
    public ZooEntityAfricanWDog(World world)
    {
        this(world, false);
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
    	boolean should;
    	if(entityanimal.captured)
    	{
    		should = true;
    	}else{
    		should = false;
    	}
		return new ZooEntityAfricanWDog(worldObj, should);
	}

	public int getMaxHealth() {
		return 10;
	}
    
    protected float getSpeedModifier()
    {
    	super.getSpeedModifier();
        float f = super.getSpeedModifier();
        if(entityToAttack instanceof EntityPlayer)
        {
        	return super.getSpeedModifier();
        }
        else if (entityToAttack instanceof EntityChicken)
        {
            f *= 2.0F;
        }
        return f;
    }
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	if(hunger < 10)
    	{
	    	EntityItem entityitem = getClosestItem(this, 10D, Item.chickenRaw.shiftedIndex, 0);
	        if(entityitem != null)
	        {
	            float f = entityitem.getDistanceToEntity(this);
	            if(f > 2.0F)
	            {
	                getCustomPath(entityitem, f);
	            }
	            if(f < 2.0F && entityitem != null && deathTime == 0)
	            {
	                entityitem.setDead();
	                feed(1);
	            }
	        }
    	}
    }
    
	public int getMaxHunger() {
		return 10;
	}
}