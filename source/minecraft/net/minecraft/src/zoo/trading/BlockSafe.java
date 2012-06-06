package net.minecraft.src.zoo.trading;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooTrade;

public class BlockSafe extends BlockContainer
{
	
	private Random random = new Random();
	
	public BlockSafe(int par1) {
		super(par1, Material.iron);
		this.blockIndexInTexture = Block.blockSteel.blockIndexInTexture;
		setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.95F, 0.95F);
	}
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving) {
		int var6 = MathHelper.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
		}

		if (var6 == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
		}

		if (var6 == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
		}

		if (var6 == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
		}
	}
	
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
        TileEntitySafe safe = (TileEntitySafe)par1World.getBlockTileEntity(par2, par3, par4);
        if(safe.locked)
        {
        	if(par5EntityPlayer.username.equals(safe.username))
        	{
        		this.setHardness(1F);
        	}
        	else{
        		this.setBlockUnbreakable();
        	}
        }else{
        	this.setHardness(1F);
        }
    }
	
	public void onBlockRemoval(World world, int par2, int par3, int par4)
    {
        TileEntitySafe var5 = (TileEntitySafe)world.getBlockTileEntity(par2, par3, par4);

        if (var5 != null)
        {
            for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
            {
                ItemStack var7 = var5.getStackInSlot(var6);

                if (var7 != null)
                {
                    float var8 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var12;

                    for (float var10 = this.random.nextFloat() * 0.8F + 0.1F; var7.stackSize > 0; world.spawnEntityInWorld(var12))
                    {
                        int var11 = this.random.nextInt(21) + 10;

                        if (var11 > var7.stackSize)
                        {
                            var11 = var7.stackSize;
                        }

                        var7.stackSize -= var11;
                        var12 = new EntityItem(world, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));
                        float var13 = 0.05F;
                        var12.motionX = (double)((float)this.random.nextGaussian() * var13);
                        var12.motionY = (double)((float)this.random.nextGaussian() * var13 + 0.2F);
                        var12.motionZ = (double)((float)this.random.nextGaussian() * var13);

                        if (var7.hasTagCompound())
                        {
                            var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                        }
                    }
                }
            }
            Trade.increaseMoney(var5.money);
        }

        super.onBlockRemoval(world, par2, par3, par4);
    }
	
	public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		if (par1World.isRemote) {
			return true;
		} else {
			TileEntitySafe var6 = (TileEntitySafe)par1World.getBlockTileEntity(par2, par3, par4);

			if (var6 != null) {
				var6.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
			}

			return true;
		}
	}
	
	public int quantityDropped(Random random)
    {
        return 1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }   
    
    public int getRenderType()
    {
        return mod_ZooTrade.safeRender;
    }
	
	public TileEntity getBlockEntity() {
		return new TileEntitySafe();
	}

}
