package net.minecraft.src.zoo.core.entities;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public abstract class ZooEntityAnimal extends EntityCreature
{
    private int inLove;
    private int breeding;
    protected int hunger;
    public EntityLiving roped;
    public boolean captured;
    private int hungertimer;
    private float foodSaturationLevel;
    private float foodExhaustionLevel;

    public ZooEntityAnimal(World world)
    {
        super(world);
        breeding = 0;
        hunger = getMaxHunger();
    }
    
    public ZooEntityAnimal(World world, boolean flag)
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
    
    public abstract ItemStack dropMeat();
    
    protected void dropFewItems(boolean par1, int par2)
    {
        int var4 = this.rand.nextInt(3);

        if (par2 > 0)
        {
            var4 += this.rand.nextInt(par2 + 1);
        }

        for (int var5 = 0; var5 < var4; ++var5)
        {
            entityDropItem(dropMeat(), 0.0F);
        }
    }
    
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        int i = getDelay();
        if (i < 0)
        {
            i++;
            setDelay(i);
        }
        else if (i > 0)
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
                worldObj.spawnParticle(s, (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
            }
        }
        else
        {
            breeding = 0;
        }
        if(!captured)
        {
        	hunger = getMaxHunger();
        }
		if (foodExhaustionLevel > 4F)
        {
            foodExhaustionLevel -= 4F;
            if (foodSaturationLevel > 0.0F)
            {
                foodSaturationLevel = Math.max(foodSaturationLevel - 1.0F, 0.0F);
            }
            else if (i > 0)
            {
                hunger = Math.max(hunger - 1, 0);
            }
        }
        if(rand.nextInt(1000) == 0)
        {
        	feed(-1);
        }
        if(!captured)
        {
        	hunger = 10;
        }
        if (hunger >= 7 && health < getMaxHealth())
        {
        	hungertimer++;
            if (hungertimer >= 100)
            {
                heal(1);
                hungertimer = 0;
            }
        }
        else if (hunger <= 0)
        {
            hungertimer++;
            if (hungertimer >= 100)
            {
                if (health > getMaxHealth()/2 || health > 1)
                {
                    attackEntityFrom(DamageSource.starve, 1);
                }
                hungertimer = 0;
            }
        }else{
        	hungertimer = 0;
        }
        double d = posX;
        double d1 = posZ;
        double d2 = posY;
        addMovementStat(d - posX, d1 - posZ, d2 - posY);
    }

    protected void attackEntity(Entity entity, float f)
    {
    	if (this instanceof ZooEntityAfricanWDog && entity instanceof EntityChicken && attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2);
        }
        if (entity instanceof EntityPlayer)
        {
            if (f < 3F)
            {
                double d = entity.posX - posX;
                double d1 = entity.posZ - posZ;
                rotationYaw = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
                hasAttacked = true;
            }
            EntityPlayer entityplayer = (EntityPlayer)entity;
            if (entityplayer.getCurrentEquippedItem() == null || !isWheat(entityplayer.getCurrentEquippedItem()))
            {
                entityToAttack = null;
            }
        }
        else if (entity instanceof ZooEntityAnimal)
        {
            ZooEntityAnimal entityanimal = (ZooEntityAnimal)entity;
            if (getDelay() > 0 && entityanimal.getDelay() < 0)
            {
                if ((double)f < 2.5D)
                {
                    hasAttacked = true;
                }
            }
            else if (inLove > 0 && entityanimal.inLove > 0)
            {
                if (entityanimal.entityToAttack == null)
                {
                    entityanimal.entityToAttack = this;
                }
                if (entityanimal.entityToAttack == this && (double)f < 3.5D)
                {
                    entityanimal.inLove++;
                    inLove++;
                    breeding++;
                    if (breeding % 4 == 0)
                    {
                        worldObj.spawnParticle("heart", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, 0.0D, 0.0D, 0.0D);
                    }
                    if (breeding == 60)
                    {
                        procreate((ZooEntityAnimal)entity);
                    }
                }
                else
                {
                    breeding = 0;
                }
            }
            else
            {
                breeding = 0;
                entityToAttack = null;
            }
        }
    }

    private void procreate(ZooEntityAnimal entityanimal)
    {
        ZooEntityAnimal entityanimal1 = spawnBabyAnimal(entityanimal);
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
                worldObj.spawnParticle("heart", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
            }

            worldObj.spawnEntityInWorld(entityanimal1);
        }
    }

    protected abstract ZooEntityAnimal spawnBabyAnimal(ZooEntityAnimal entityanimal);
    
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        if (itemstack != null && isWheat(itemstack) && getDelay() == 0)
        {
            itemstack.stackSize--;
            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            }
            inLove = 600;
            entityToAttack = null;
            for (int i = 0; i < 7; i++)
            {
                double d = rand.nextGaussian() * 0.02D;
                double d1 = rand.nextGaussian() * 0.02D;
                double d2 = rand.nextGaussian() * 0.02D;
                worldObj.spawnParticle("heart", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
            }

            return true;
        }if(itemstack != null && riddenByEntity == null && roped == null &&  itemstack.itemID == Zoo.lasso.shiftedIndex)
        {
        	if(!captured)
        	{
        		captured = true;
        	}
            if(--itemstack.stackSize == 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            }
            roped = player;
            return true;
        }
        if(roped != null)
        {
            player.inventory.addItemStackToInventory(new ItemStack(Zoo.lasso));
            roped = null;
            return true;
        }else
        {
        	return false;
        }
    }
    
    protected void updateEntityActionState()
    {
        if(riddenByEntity == null)
        {
            super.updateEntityActionState();
        }
        if(ridingEntity == null && roped != null)
        {
            float f = roped.getDistanceToEntity(this);
            if(f > 5F)
            {
                getPathOrWalkableBlock(roped, f);
            }
        }
    }
	
	protected void getPathOrWalkableBlock(Entity entity, float f)
    {
        PathEntity pathentity = worldObj.getPathEntityToEntity(this, entity, 16F, false, true, false, true);
        if(pathentity == null && f > 12F)
        {
            int i = MathHelper.floor_double(entity.posX) - 2;
            int j = MathHelper.floor_double(entity.posZ) - 2;
            int k = MathHelper.floor_double(entity.boundingBox.minY);
            for(int l = 0; l <= 4; l++)
            {
                for(int i1 = 0; i1 <= 4; i1++)
                {
                    if((l < 1 || i1 < 1 || l > 3 || i1 > 3) && worldObj.isBlockNormalCube(i + l, k - 1, j + i1) && !worldObj.isBlockNormalCube(i + l, k, j + i1) && !worldObj.isBlockNormalCube(i + l, k + 1, j + i1))
                    {
                        setLocationAndAngles((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, rotationYaw, rotationPitch);
                        return;
                    }
                }

            }

        } else
        {
            setPathToEntity(pathentity);
        }
    }
    
    protected void attackBlockedEntity(Entity entity, float f)
    {
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        fleeingTick = 60;
        entityToAttack = null;
        inLove = 0;
        return super.attackEntityFrom(damagesource, i);
    }

    public float getBlockPathWeight(int i, int j, int k)
    {
        if (worldObj.getBlockId(i, j - 1, k) == Block.grass.blockID)
        {
            return 10F;
        }
        else
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
    }
    
    protected Entity findPlayerToAttack()
    {
    	if(this instanceof ZooEntityAfricanWDog)
    	{
    		double d1 = -1D;
            Entity chicken = null;
    		for(int i = 0; i < worldObj.loadedEntityList.size(); i++)
            {
                Entity entity1 = (Entity)worldObj.loadedEntityList.get(i);
                
                if(!(entity1 instanceof EntityChicken))
                {
                    continue;
                }
                
                double d2 = entity1.getDistance(posX, posY, posZ);
                if((d2 < 16) && (d1 == -1D || d2 < d1) && ((EntityChicken)entity1).canEntityBeSeen(this))
                {
                    d1 = d2;
                    chicken = (EntityChicken) entity1;
                    return chicken;
                }
            }
    	}
        if (fleeingTick > 0)
        {
            return null;
        }
        float f = 8F;
        if (inLove > 0)
        {
            List list = worldObj.getEntitiesWithinAABB(getClass(), boundingBox.expand(f, f, f));
            for (int i = 0; i < list.size(); i++)
            {
                ZooEntityAnimal entityanimal = (ZooEntityAnimal)list.get(i);
                if (entityanimal != this && entityanimal.inLove > 0)
                {
                    return entityanimal;
                }
            }
        }
        else if (getDelay() == 0)
        {
            List list1 = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityPlayer.class, boundingBox.expand(f, f, f));
            for (int j = 0; j < list1.size(); j++)
            {
                EntityPlayer entityplayer = (EntityPlayer)list1.get(j);
                if (entityplayer.getCurrentEquippedItem() != null && isWheat(entityplayer.getCurrentEquippedItem()))
                {
                    return entityplayer;
                }
            }
        }
        else if (getDelay() > 0)
        {
            List list2 = worldObj.getEntitiesWithinAABB(getClass(), boundingBox.expand(f, f, f));
            for (int k = 0; k < list2.size(); k++)
            {
                ZooEntityAnimal entityanimal1 = (ZooEntityAnimal)list2.get(k);
                if (entityanimal1 != this && entityanimal1.getDelay() < 0)
                {
                    return entityanimal1;
                }
            }
        }
        return null;
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

    protected boolean isWheat(ItemStack itemstack)
    {
        return itemstack.itemID == Item.wheat.shiftedIndex;
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
        for(int k = 0; k < list.size(); k++)
        {
            Entity entity1 = (Entity)list.get(k);
            if(!(entity1 instanceof EntityItem))
            {
                continue;
            }
            EntityItem entityitem1 = (EntityItem)entity1;
            if(entityitem1.item.itemID != i && entityitem1.item.getItemDamage() != j)
            {
                continue;
            }
            double d2 = entityitem1.getDistanceSq(entity.posX, entity.posY, entity.posZ);
            if((d < 0.0D || d2 < d * d) && (d1 == -1D || d2 < d1))
            {
                d1 = d2;
                entityitem = entityitem1;
            }
        }
        return entityitem;
    }
    
    public void getCustomPath(Entity entity, float f)
    {
    	PathEntity pathentity = worldObj.getPathEntityToEntity(this, entity, 16F, false, true, false, true);
        if(pathentity != null)
        {
            setPathToEntity(pathentity);
        }
    }
    
    public void feed(int i)
    {
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
                addExhaustion(0.015F * (float)i * 0.01F);
            }
        }
        else if (isInWater())
        {
            int j = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
            if (j > 0)
            {
                addExhaustion(0.015F * (float)j * 0.01F);
            }
        }
        else if (onGround)
        {
            int k = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
            if (k > 0)
            {
                if (isSprinting())
                {
                    addExhaustion(0.09999999F * (float)k * 0.01F);
                }
                else
                {
                    addExhaustion(0.01F * (float)k * 0.01F);
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
