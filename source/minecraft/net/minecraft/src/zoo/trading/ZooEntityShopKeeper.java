package net.minecraft.src.zoo.trading;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.core.GUIIDEnum;
import net.minecraft.src.zoo.trading.*;

public class ZooEntityShopKeeper extends EntityCreature
{
	
	private int type;

	public ZooEntityShopKeeper(World world)
    {
        this(world, 0);
    }

    public ZooEntityShopKeeper(World world, int i)
    {
        super(world);
        type = i;
        setTextureByType();
        moveSpeed = 0.5F;
    }

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Type", type);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        type = nbttagcompound.getInteger("Type");
        setTextureByType();
    }

    protected String getLivingSound()
    {
        return null;
    }

    protected String getHurtSound()
    {
        return "random.hurt";
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
	
    protected boolean canDespawn()
    {
        return false;
    }
	
    public boolean interact(EntityPlayer entityplayer)
    {
    	Minecraft mc = ModLoader.getMinecraftInstance();
        if(!super.interact(entityplayer))
        {
        	if(mc.currentScreen == null)
            {
        		int x = MathHelper.floor_double(posX);
        		int y = MathHelper.floor_double(posY);
        		int z = MathHelper.floor_double(posZ);
        		if(type == 1)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_DECOR.ID, worldObj, x, y, z);
    			}
        		if(type == 2)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_DIRT.ID, worldObj, x, y, z);
    			}
        		if(type == 3)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_FENCING.ID, worldObj, x, y, z);
    			}
        		if(type == 4)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_FOOD.ID, worldObj, x, y, z);
    			}
        		if(type == 5)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_PLANTS.ID, worldObj, x, y, z);
    			}
        		if(type == 6)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_POTION.ID, worldObj, x, y, z);
    			}
        		if(type == 7)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_SPECIAL.ID, worldObj, x, y, z);
    			}
        		if(type == 8)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_TECH.ID, worldObj, x, y, z);
    			}
        		if(type == 9)
        		{
        			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_TOOLS.ID, worldObj, x, y, z);
    			}
            }
        } else
        {
            return true;
        }
		return true;
    }
    
    private void setTextureByType() {
    	if(type == 1)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 2)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 3)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 4)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 5)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 6)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 7)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 8)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
    	if(type == 9)
    	{
    		texture = "/zoo/modells/npcs/shopkeeper.png";
    	}
	}
}