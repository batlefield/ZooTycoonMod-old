package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;

public class ZooEntityTiger extends EntityMob
{

	private int field_35189_a;
	
    public ZooEntityTiger(World world)
    {
        super(world);
        texture = "/zoo/modells/tiger texture.png";
        setSize(1.5F, 1.9F);
    }
    
    public ZooEntityTiger(World world, boolean flag)
    {
        this(world);
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
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected Entity findPlayerToAttack()
    {
        double d = 8D;
        return worldObj.getClosestVulnerablePlayerToEntity(this, d);
    }
	
	public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if(field_35189_a <= 0 && (damagesource instanceof EntityDamageSource))
        {
            field_35189_a = 20;
        }
        return super.attackEntityFrom(damagesource, i);
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(attackTime <= 0 && f < 1.2F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
        }
    }
    
    public boolean getCanSpawnHere()
    {
        if(super.getCanSpawnHere())
        {
            EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 5D);
            return entityplayer == null;
        } else
        {
            return false;
        }
    }

}