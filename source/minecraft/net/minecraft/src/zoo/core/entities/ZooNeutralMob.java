package net.minecraft.src.zoo.core.entities;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public abstract class ZooNeutralMob extends EntityCreature
{
	private int inLove;
	private int breeding;
	protected int hunger;
	protected int prevHunger;
	public EntityLiving roped;
	public boolean captured;
	private int hungertimer;
	private float foodSaturationLevel;
	private float foodExhaustionLevel;
	protected int attackStrength = 2;
	private int angerLevel = 0;

	public ZooNeutralMob(World world)
	{
		super(world);
		breeding = 0;
		hunger = getMaxHunger();
	}

	public ZooNeutralMob(World world, boolean flag)
	{
		this(world);
		captured = flag;
	}

	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(12, new Integer(0));
	}

	public int getDelay()
	{
		return dataWatcher.getWatchableObjectInt(12);
	}

	public void setDelay(int i)
	{
		dataWatcher.updateObject(12, Integer.valueOf(i));
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		int i = getDelay();
		if (i < 0)
		{
			i++;
			setDelay(i);
		} else if (i > 0)
		{
			i--;
			setDelay(i);
		}
		if (inLove > 0)
		{
			inLove--;
			String s = "heart";
			if (inLove % 10 == 0)
			{
				double d = rand.nextGaussian() * 0.02D;
				double d1 = rand.nextGaussian() * 0.02D;
				double d2 = rand.nextGaussian() * 0.02D;
				worldObj.spawnParticle(s, (posX + (double) (rand.nextFloat() * width * 2.0F)) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), (posZ + (double) (rand.nextFloat() * width * 2.0F)) - (double) width, d, d1, d2);
			}
		} else
		{
			breeding = 0;
		}
		if (!captured)
		{
			hunger = getMaxHunger();
		}
		if (foodExhaustionLevel > 4F)
		{
			foodExhaustionLevel -= 4F;
			if (foodSaturationLevel > 0.0F)
			{
				foodSaturationLevel = Math.max(foodSaturationLevel - 1.0F, 0.0F);
			} else if (i > 0)
			{
				hunger = Math.max(hunger - 1, 0);
			}
		}
		if (hunger >= 7 && health < getMaxHealth())
		{
			hungertimer++;
			if (hungertimer >= 100)
			{
				heal(1);
				hungertimer = 0;
			}
		} else if (hunger <= 0)
		{
			hungertimer++;
			if (hungertimer >= 100)
			{
				if (health > getMaxHealth() / 2 || health > 1)
				{
					attackEntityFrom(DamageSource.starve, 1);
				}
				hungertimer = 0;
			}
		} else
		{
			hungertimer = 0;
		}
		double d = posX;
		double d1 = posZ;
		double d2 = posY;
		addMovementStat(d - posX, d1 - posZ, d2 - posY);
	}

	// MAKING THE ENTITY HOSTILE (FROM ENTITYMOB)
    public void onUpdate()
    {
        this.moveSpeed = this.entityToAttack != null ? 0.95F : 0.5F;

        super.onUpdate();
    }
    
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        int var2 = this.attackStrength;

        if (this.isPotionActive(Potion.damageBoost))
        {
            var2 += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
        }

        if (this.isPotionActive(Potion.weakness))
        {
            var2 -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
        }

        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.5F && par1Entity.boundingBox.maxY >= this.boundingBox.minY && par1Entity.boundingBox.minY <= this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.angerLevel == 0 ? null : attackPlayer();
    }

    protected Entity attackPlayer()
    {
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return var1 != null && this.canEntityBeSeen(var1) ? var1 : null;
    }
    
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        Entity var3 = par1DamageSource.getEntity();

        if (var3 instanceof EntityPlayer)
        {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for (int var5 = 0; var5 < var4.size(); ++var5)
            {
                Entity var6 = (Entity)var4.get(var5);

                if (var6 instanceof ZooNeutralMob)
                {
                	ZooNeutralMob var7 = (ZooNeutralMob)var6;
                    var7.becomeAngryAt(var3);
                }
            }

            this.becomeAngryAt(var3);
        }

        return super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Causes this PigZombie to become angry at the supplied Entity (which will be a player).
     */
    private void becomeAngryAt(Entity par1Entity)
    {
        this.entityToAttack = par1Entity;
        this.angerLevel = 400 + this.rand.nextInt(400);
    }

	// /////////////////////////////////END OF HOSTILE
	// CODE/////////////////////////////////

	private void procreate(ZooNeutralMob entityanimal)
	{
		ZooNeutralMob entityanimal1 = spawnBabyAnimal(entityanimal);
		if (entityanimal1 != null)
		{
			setDelay(6000);
			entityanimal.setDelay(6000);
			inLove = 0;
			breeding = 0;
			entityToAttack = null;
			entityanimal.entityToAttack = null;
			entityanimal.breeding = 0;
			entityanimal.inLove = 0;
			entityanimal1.setDelay(-24000);
			entityanimal1.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
			for (int i = 0; i < 7; i++)
			{
				double d = rand.nextGaussian() * 0.02D;
				double d1 = rand.nextGaussian() * 0.02D;
				double d2 = rand.nextGaussian() * 0.02D;
				worldObj.spawnParticle("heart", (posX + (double) (rand.nextFloat() * width * 2.0F)) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), (posZ + (double) (rand.nextFloat() * width * 2.0F)) - (double) width, d, d1, d2);
			}

			worldObj.spawnEntityInWorld(entityanimal1);
		}
	}

	protected abstract ZooNeutralMob spawnBabyAnimal(ZooNeutralMob entityanimal);

	protected void updateEntityActionState()
	{
		if (riddenByEntity == null)
		{
			super.updateEntityActionState();
		}
		if (ridingEntity == null && roped != null)
		{
			float f = roped.getDistanceToEntity(this);
			if (f > 5F)
			{
				getPathOrWalkableBlock(roped, f);
			}
		}
	}

	protected void getPathOrWalkableBlock(Entity entity, float f)
	{
		PathEntity pathentity = worldObj.getPathEntityToEntity(this, entity, 16F, false, true, false, true);
		if (pathentity == null && f > 12F)
		{
			int i = MathHelper.floor_double(entity.posX) - 2;
			int j = MathHelper.floor_double(entity.posZ) - 2;
			int k = MathHelper.floor_double(entity.boundingBox.minY);
			for (int l = 0; l <= 4; l++)
			{
				for (int i1 = 0; i1 <= 4; i1++)
				{
					if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && worldObj.isBlockNormalCube(i + l, k - 1, j + i1) && !worldObj.isBlockNormalCube(i + l, k, j + i1) && !worldObj.isBlockNormalCube(i + l, k + 1, j + i1))
					{
						setLocationAndAngles((float) (i + l) + 0.5F, k, (float) (j + i1) + 0.5F, rotationYaw, rotationPitch);
						return;
					}
				}

			}

		} else
		{
			setPathToEntity(pathentity);
		}
	}

	public float getBlockPathWeight(int i, int j, int k)
	{
		if (worldObj.getBlockId(i, j - 1, k) == Block.grass.blockID)
		{
			return 10F;
		} else
		{
			return worldObj.getLightBrightness(i, j, k) - 0.5F;
		}
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setInteger("Age", getDelay());
		nbttagcompound.setInteger("InLove", inLove);
		nbttagcompound.setInteger("Hunger", hunger);
		nbttagcompound.setBoolean("Captured", captured);
		nbttagcompound.setInteger("HungerTimer", hungertimer);
		nbttagcompound.setFloat("foodSaturationLevel", foodSaturationLevel);
		nbttagcompound.setFloat("foodExhaustionLevel", foodExhaustionLevel);
		nbttagcompound.setShort("Anger", (short)angerLevel);
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
		setDelay(nbttagcompound.getInteger("Age"));
		inLove = nbttagcompound.getInteger("InLove");
		hunger = nbttagcompound.getInteger("Hunger");
		captured = nbttagcompound.getBoolean("Captured");
		hungertimer = nbttagcompound.getInteger("HungerTimer");
		foodSaturationLevel = nbttagcompound.getFloat("foodSaturationLevel");
		foodExhaustionLevel = nbttagcompound.getFloat("foodExhaustionLevel");
		angerLevel = nbttagcompound.getShort("Anger");
	}

	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(posX);
		int j = MathHelper.floor_double(boundingBox.minY);
		int k = MathHelper.floor_double(posZ);
		return worldObj.getBlockId(i, j - 1, k) == Block.grass.blockID && worldObj.getFullBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
	}

	public int getTalkInterval()
	{
		return 120;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	protected int getExperiencePoints(EntityPlayer entityplayer)
	{
		return 1 + worldObj.rand.nextInt(3);
	}

	public boolean isChild()
	{
		return getDelay() < 0;
	}

	public EntityItem getClosestItem(Entity entity, double d, int i, int j)
	{
		double d1 = -1D;
		EntityItem entityitem = null;
		List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(d, d, d));
		for (int k = 0; k < list.size(); k++)
		{
			Entity entity1 = (Entity) list.get(k);
			if (!(entity1 instanceof EntityItem))
			{
				continue;
			}
			EntityItem entityitem1 = (EntityItem) entity1;
			if (entityitem1.item.itemID != i && entityitem1.item.getItemDamage() != j)
			{
				continue;
			}
			double d2 = entityitem1.getDistanceSq(entity.posX, entity.posY, entity.posZ);
			if ((d < 0.0D || d2 < d * d) && (d1 == -1D || d2 < d1))
			{
				d1 = d2;
				entityitem = entityitem1;
			}
		}
		return entityitem;
	}

	public void feed(int i)
	{
		if (hunger <= 0)
		{
			return;
		}
		hunger += i;
		if (hunger > getMaxHunger())
		{
			hunger = getMaxHunger();
		}
	}

	public abstract int getMaxHunger();

	public int getHunger()
	{
		return hunger;
	}

	public void addMovementStat(double d, double d1, double d2)
	{
		if (ridingEntity != null)
		{
			return;
		}
		if (isInsideOfMaterial(Material.water))
		{
			int i = Math.round(MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2) * 100F);
			if (i > 0)
			{
				addExhaustion(0.015F * (float) i * 0.01F);
			}
		} else if (isInWater())
		{
			int j = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
			if (j > 0)
			{
				addExhaustion(0.015F * (float) j * 0.01F);
			}
		} else if (onGround)
		{
			int k = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
			if (k > 0)
			{
				if (isSprinting())
				{
					addExhaustion(0.09999999F * (float) k * 0.01F);
				} else
				{
					addExhaustion(0.01F * (float) k * 0.01F);
				}
			}
		}
	}

	public int getEntityHealth()
	{
		return health;
	}

	protected void jump()
	{
		super.jump();
		addExhaustion(0.2F);
	}

	private void addExhaustion(float f)
	{
		foodExhaustionLevel = Math.min(foodExhaustionLevel + f, 40F);
	}
}
