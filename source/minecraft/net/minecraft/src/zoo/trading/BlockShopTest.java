package net.minecraft.src.zoo.trading;

import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.zoo.core.ZooBlock;

public class BlockShopTest extends Block implements ITextureProvider{

	public BlockShopTest(int par1) {
		super(par1, Material.iron);
		blockIndexInTexture = 42;
	}
	
	public TileEntity getTileEntity(int metadata)
    {
    	return new TileEntityShop();
    }
	
	public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        int var6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        if(par5 != var6)
        {
        	return this.blockIndexInTexture;
        }else{ 
        	return this.blockIndexInTexture - 1;
        }
        
    }
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        par1World.setBlockTileEntity(par2, par3, par4, new TileEntityShop());
        this.setDefaultDirection(par1World, par2, par3, par4);
    }
	
	public void onBlockRemoval(World par1World, int par2, int par3, int par4)
    {
        super.onBlockRemoval(par1World, par2, par3, par4);
        par1World.removeBlockTileEntity(par2, par3, par4);
    }
	
	public void receiveClientEvent(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.receiveClientEvent(par1World, par2, par3, par4, par5, par6);
        TileEntity var7 = par1World.getBlockTileEntity(par2, par3, par4);

        if (var7 != null)
        {
            var7.receiveClientEvent(par5, par6);
        }
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int var5 = par1World.getBlockId(par2, par3, par4 - 1);
            int var6 = par1World.getBlockId(par2, par3, par4 + 1);
            int var7 = par1World.getBlockId(par2 - 1, par3, par4);
            int var8 = par1World.getBlockId(par2 + 1, par3, par4);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
        }
    }
	
	public int getBlockTextureFromSide(int par1)
    {
	   if(par1 == 3){
		   return this.blockIndexInTexture - 1;
	   }
	   else{
		   return this.blockIndexInTexture;
	   }
    }
	
	public int getRenderBlockPass()
	{
		return 0;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
            System.out.println(var6);
            
            if (var6 != null)
            {
            	System.out.println("Is tile");
                //ModLoader.openGUI(par5EntityPlayer, new GUIShop(var6));
            }

            return true;
        }
    }
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
        }

        if (var6 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
        }

        if (var6 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
        }

        if (var6 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
        }
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}

}
