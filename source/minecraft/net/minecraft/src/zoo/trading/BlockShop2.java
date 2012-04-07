package net.minecraft.src.zoo.trading;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

public class BlockShop2 extends BlockShop
{
	public BlockShop2(int i)
	{
		super(i);
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		if ((j == 0 || j == 4 || j == 8 || j == 12) && i == 5)
		{
			return 41;
		}
		if ((j == 1 || j == 5 || j == 9 || j == 13) && i == 2)
		{
			return 41;
		}
		if ((j == 2 || j == 6 || j == 10 || j == 14) && i == 4)
		{
			return 41;
		}
		if ((j == 3 || j == 7 || j == 11 || j == 15) && i == 3)
		{
			return 41;
		}
		return 42;
	}

	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{

		int md = world.getBlockMetadata(i, j, k);

		if (!world.isRemote)
		{
			if (entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID))
			{
				switch (md)
				{
				case 0:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 1);
					break;
				case 1:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 2);
					break;
				case 2:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 3);
					break;
				case 3:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 0);
					break;
				case 4:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 5);
					break;
				case 5:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 6);
					break;
				case 6:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 7);
					break;
				case 7:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 4);
					break;
				case 8:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 9);
					break;
				case 9:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 10);
					break;
				case 10:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 11);
					break;
				case 11:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 8);
					break;
				case 12:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 13);
					break;
				case 13:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 14);
					break;
				case 14:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 15);
					break;
				case 15:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble2.blockID, 12);
					break;

				}
			}
			else
			{
				if (md == 0 || md == 1 || md == 2 || md == 3)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					potionShop(world, i, j, k, md);
				}
				if (md == 4 || md == 5 || md == 6 || md == 7)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					armorShop(world, i, j, k, md);
				}
				if (md == 8 || md == 9 || md == 10 || md == 11)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					decorationShop(world, i, j, k, md);
				}
				if (md == 12 || md == 13 || md == 14 || md == 15)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					natureShop(world, i, j, k, md);
				}
			}
		}

		return true;
	}

	private void natureShop(World world, int x, int y, int z, int direction)
	{
		StructureGenerator generator = new StructureGenerator();
		generator.generateCuboid(world, x, y + 3, z - 2, x + 4, y + 5, z + 3, 0);
	}

}
