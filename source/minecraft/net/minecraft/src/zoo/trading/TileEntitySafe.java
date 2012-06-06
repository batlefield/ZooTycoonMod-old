package net.minecraft.src.zoo.trading;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryBasic;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.zoo.core.GUIIDEnum;
import net.minecraft.src.zoo.core.TileEntityBase;

public class TileEntitySafe extends TileEntityBase implements IInventory{

	public ItemStack[] stacks = new ItemStack[6];
	public float prevAngle;
	public float currentAngle;
	public boolean locked = true;
	public boolean setPassword = true;
	public int money;
	public String password = "";
	public String username = "";
	
	public void blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		if(locked || setPassword)
		{
			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SAFE_LOCKED.ID, worldObj, i, j, k);
		}else if(!locked && !setPassword)
		{
			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SAFE_UNLOCKED.ID, worldObj, i, j, k);
		}
	}
	
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		locked = nbt.getBoolean("Lock");
		setPassword = nbt.getBoolean("Password set");
		password = nbt.getString("Password");
		money = nbt.getInteger("Money");
		username = nbt.getString("User");
		
		NBTTagList var2 = nbt.getTagList("Items");
        this.stacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.stacks.length)
            {
                this.stacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
		
	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setBoolean("Lock", locked);
		nbt.setBoolean("Password set", setPassword);
		nbt.setString("Password", password);
		nbt.setInteger("Money", money);
		nbt.setString("User", username);
		
		NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.stacks.length; ++var3)
        {
            if (this.stacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.stacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        nbt.setTag("Items", var2);
	}
	
	public void updateEntity()
    {
        super.updateEntity();

        this.prevAngle = this.currentAngle;
        float var1 = 0.1F;
        double var4;

        if (!locked && this.currentAngle == 0.0F)
        {
            double var2 = (double)this.xCoord;
            var4 = (double)this.zCoord;

            this.worldObj.playSoundEffect(var2, (double)this.yCoord + 0.5D, var4, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (locked && this.currentAngle > 0.0F || !locked && this.currentAngle < 1.0F)
        {
            float var8 = this.currentAngle;

            if (!locked)
            {
                this.currentAngle += var1;
            }
            else
            {
                this.currentAngle -= var1;
            }

            if (this.currentAngle > 1.0F)
            {
                this.currentAngle = 1.0F;
            }

            float var3 = 0.5F;

            if (this.currentAngle < var3 && var8 >= var3)
            {
                var4 = (double)this.xCoord;
                double var6 = (double)this.zCoord;

                this.worldObj.playSoundEffect(var4, (double)this.yCoord + 0.5D, var6, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.currentAngle < 0.0F)
            {
                this.currentAngle = 0.0F;
            }
        }
    }

	public int getSizeInventory()
	{
		return stacks.length;
	}

	public ItemStack getStackInSlot(int var1)
	{
		return stacks[var1];
	}

	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.stacks[par1] != null)
        {
            ItemStack var3;

            if (this.stacks[par1].stackSize <= par2)
            {
                var3 = this.stacks[par1];
                this.stacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.stacks[par1].splitStack(par2);

                if (this.stacks[par1].stackSize == 0)
                {
                    this.stacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
	}

	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.stacks[par1] != null)
        {
            ItemStack var2 = this.stacks[par1];
            this.stacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
	}

	public void setInventorySlotContents(int par1, ItemStack par2)
	{
		this.stacks[par1] = par2;

        if (par2 != null && par2.stackSize > this.getInventoryStackLimit())
        {
            par2.stackSize = this.getInventoryStackLimit();
        }
	}

	public String getInvName()
	{
		return "Safe";
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	public boolean isUseableByPlayer(EntityPlayer var1)
	{
		if(this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this)
		{
			return false;
		}else{
			return var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
		}
	}

	public void openChest(){}

	public void closeChest(){}
	
}
