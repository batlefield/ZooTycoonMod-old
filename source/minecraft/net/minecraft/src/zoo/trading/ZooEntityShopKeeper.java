package net.minecraft.src.zoo.trading;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
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
        		if(type == 1)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingDirt());
    			}
        		if(type == 2)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingFood());
    			}
        		if(type == 3)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingFencing());
    			}
        		if(type == 4)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingSpecial());
    			}
        		if(type == 5)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingTech());
    			}
        		if(type == 6)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingPotion());
    			}
        		if(type == 7)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingPlants());
    			}
        		if(type == 8)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingTools());
    			}
        		if(type == 9)
        		{
        			mc.displayGuiScreen(new ZooGuiContainerTradingDecor());
    			}
        			
            } else
            {
            	mc.displayGuiScreen(null);
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