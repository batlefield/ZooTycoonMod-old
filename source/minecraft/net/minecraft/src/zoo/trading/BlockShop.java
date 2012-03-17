package net.minecraft.src.zoo.trading;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.*;
import net.minecraft.src.zoo.api.Fence;

public class BlockShop extends Block implements ITextureProvider {

	public BlockShop(int i) {
		super(i, Material.wood);
	}
	
	public String getTextureFile() {
		return "/zoo/blocks.png";
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
		if(j == 0 && (i == 2 || i == 3))
		{
			return 41;
		}
		if(j == 1 && (i == 4 || i == 5))
		{
			return 41;
		}
		return 42;
	}
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		
		int md = world.getBlockMetadata(i, j, k);
		
		if(!world.isRemote)
        {
			if(entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID))
			{
				switch(md)
				{
					case 0:
						world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 1);
						break;
					case 1:
						world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 0);
					
				}
			}else{
				switch(md){
					case 0:
						ZooEntityShopKeeper sk = new ZooEntityShopKeeper(world, 1);
			            sk.setLocationAndAngles((double)i + 0.5D, j, (double)k + 0.5D, 0.0F, 0.0F);
			            world.spawnEntityInWorld(sk);
			            createDirtA(world, i, j - 1, k);
			            break;
					case 1:
						ZooEntityShopKeeper sk1 = new ZooEntityShopKeeper(world, 1);
			            sk1.setLocationAndAngles((double)i + 0.5D, j, (double)k + 0.5D, 0.0F, 0.0F);
			            world.spawnEntityInWorld(sk1);
			            createDirtB(world, i, j - 1, k);
			            break;
				}
			}
        }
		
        return super.blockActivated(world, i, j, k, entityplayer);
	}

	
	private void createDirtA(World world, int x, int y, int z) {
        
        world.setBlockWithNotify(x, y + 1, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 1, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 2, z + 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 1, y + 2, z - 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 1, y + 2, z - 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z + 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z - 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z - 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x, y + 2, z - 2, Block.thinGlass.blockID);
        world.setBlockWithNotify(x, y + 2, z + 3, Block.thinGlass.blockID);
        world.setBlockWithNotify(x, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z - 2, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 1, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z + 2, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z + 3, Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 1, y + 2, z + 3, Block.thinGlass.blockID);
        world.setBlockWithNotify(x, y + 3, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z + 3, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z + 3, Block.planks.blockID);
        world.setBlockAndMetadataWithNotify(x, y + 1, z - 1, Block.torchWood.blockID, 5);
        world.setBlockAndMetadataWithNotify(x, y + 1, z + 2, Block.torchWood.blockID, 5);
        world.setBlockWithNotify(x, y + 1, z, 0);
        world.setBlockWithNotify(x, y + 2, z, 0);
        world.setBlockWithNotify(x, y + 1, z + 1, 0);
        world.setBlockWithNotify(x, y + 2, z + 1, 0);
        world.setBlockWithNotify(x, y + 2, z - 1, 0);
        world.setBlockWithNotify(x, y + 2, z + 2, 0);
	}
	
	private void createDirtB(World world, int x, int y, int z) {
        
        world.setBlockWithNotify(x - 2, y + 1, z, Block.planks.blockID);
        world.setBlockWithNotify(x+ 2, y + 1, z , Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x+ 1, y, z , Block.planks.blockID);
        world.setBlockWithNotify(x, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 2, z + 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z + 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 2, y + 2, z + 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 2, y + 2, z - 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 2, z - 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 2, y + 2, z - 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x- 2, y + 2, z , Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 3, y + 2, z, Block.thinGlass.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x , y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 3, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x , y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 1, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 1, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x - 2, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x, y + 3, z, Block.planks.blockID);
        world.setBlockWithNotify(x, y, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 3, y + 1, z + 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 3, y + 1, z, Block.planks.blockID);
        world.setBlockWithNotify(x + 2, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 3, y + 1, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 3, y + 2, z - 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 3, y + 2, z + 1, Block.thinGlass.blockID);
        world.setBlockWithNotify(x + 3, y + 3, z , Block.planks.blockID);
        world.setBlockWithNotify(x + 3, y + 3, z - 1, Block.planks.blockID);
        world.setBlockWithNotify(x + 3, y + 3, z + 1, Block.planks.blockID);
        world.setBlockAndMetadataWithNotify(x - 1, y + 1, z, Block.torchWood.blockID, 5);
        world.setBlockAndMetadataWithNotify(x + 2, y + 1, z, Block.torchWood.blockID, 5);
        world.setBlockWithNotify(x, y + 1, z, 0);
        world.setBlockWithNotify(x, y + 2, z, 0);
        world.setBlockWithNotify(x + 1, y + 1, z , 0);
        world.setBlockWithNotify(x + 1, y + 2, z, 0);
        world.setBlockWithNotify(x - 1, y + 2, z, 0);
        world.setBlockWithNotify(x + 2, y + 2, z, 0);
	}
	
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this, 1, 0));
	}
}
