package net.minecraft.src.zoo.core;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.trading.TileEntityShop;

public class ZooBlockFencer extends BlockContainer implements ITextureProvider
{

	public ZooBlockFencer(int i)
	{
		super(i, 42, Material.iron);
	}
	
	public int getRenderBlockPass()
    {
        return 0;
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{		
		if(j == 3 && (i == 3 || i == 5))
		{
			return 41;
		}
		else if(j == 5 && (i == 2 || i == 5))
		{
			return 41;
		}
		else if(j == 2 && (i == 2 || i == 4))
		{
			return 41;
		}
		else if(j == 4 && (i == 3 || i == 4))
		{
			return 41;
		}
		return 42;
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
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if (world.isRemote) {
			return true;
		} else {
			TileEntityFencer var6 = (TileEntityFencer)world.getBlockTileEntity(i, j, k);

			if (var6 != null) {
				var6.blockActivated(world, i, j, k, entityplayer);
			}

			return true;
		}
	}

	public TileEntity getBlockEntity()
	{
		return new TileEntityFencer();
	}

	public String getTextureFile()
	{
		return "/zoo/blocks.png";
	}

}
