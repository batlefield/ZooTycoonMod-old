package net.minecraft.src.zoo.core.entities;
import net.minecraft.src.*;

public class ZooEntityWolf extends EntityMob
{

	private int field_35189_a;

    private float field_25048_b;
    private float field_25054_c;
    
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    
    private boolean isShaking;
    private boolean field_25052_g;
	
    public ZooEntityWolf(World world)
    {
        super(world);
        this.texture = "/mob/wolf.png";
        this.setSize(0.6F, 0.8F);
        this.moveSpeed = 0.3F;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
    }
    
    public ZooEntityWolf(World world, boolean flag)
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
        return "mob.wolf.growl";
    }

    protected String getHurtSound()
    {
        return "mob.wolf.hurt";
    }

    protected String getDeathSound()
    {
        return "mob.wolf.death";
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected int getDropItemId()
    {
        return -1;
    }

	public int getMaxHealth() {
		return 6;
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
    
    public void onUpdate()
    {
        super.onUpdate();
        this.field_25054_c = this.field_25048_b;

        if (this.isWet())
        {
            this.isShaking = true;
            this.field_25052_g = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if ((this.isShaking || this.field_25052_g) && this.field_25052_g)
        {
            if (this.timeWolfIsShaking == 0.0F)
            {
                this.worldObj.playSoundAtEntity(this, "mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;

            if (this.prevTimeWolfIsShaking >= 2.0F)
            {
                this.isShaking = false;
                this.field_25052_g = false;
                this.prevTimeWolfIsShaking = 0.0F;
                this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F)
            {
                float var1 = (float)this.boundingBox.minY;
                int var2 = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int var3 = 0; var3 < var2; ++var3)
                {
                    float var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.worldObj.spawnParticle("splash", this.posX + (double)var4, (double)(var1 + 0.8F), this.posZ + (double)var5, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    public boolean getWolfShaking()
    {
        return this.isShaking;
    }
    
    /**
     * Used when calculating the amount of shading to apply while the wolf is shaking.
     */
    public float getShadingWhileShaking(float par1)
    {
        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1) / 2.0F * 0.25F;
    }

    public float getShakeAngle(float par1, float par2)
    {
        float var3 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1 + par2) / 1.8F;

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }
        else if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        return MathHelper.sin(var3 * (float)Math.PI) * MathHelper.sin(var3 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }
    public float getTailRotation()
    {
        return 1.5393804F ;
    }

    public boolean func_48135_b(EntityAnimal par1EntityAnimal)
    {
        return false;
    }
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }
}