package net.minecraft.src.zoo.core;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.forge.ForgeHooks;
import net.minecraft.src.forge.IBonemealHandler;

public class ZooBonemealHandler implements IBonemealHandler
{
	private Random itemRand = new Random();

	public boolean onUseBonemeal(World world, int bid, int i, int j, int k)
	{
		if (!world.isRemote)
		{
			if (bid == Zoo.sapling.blockID)
			{
				((ZooSapling) Zoo.sapling).growTree(world, i, j, k, world.rand);
				return true;
			}

			if (bid == ZooDirts.savannah.blockID)
			{
				if (!world.isRemote)
				{
					label73:
					for (int var9 = 0; var9 < 128; ++var9)
					{
						int var10 = i;
						int var11 = j + 1;
						int var12 = k;

						for (int var13 = 0; var13 < var9 / 16; ++var13)
						{
							var10 += itemRand.nextInt(3) - 1;
							var11 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2;
							var12 += itemRand.nextInt(3) - 1;

							if (world.getBlockId(var10, var11 - 1, var12) != ZooDirts.savannah.blockID || world.isBlockNormalCube(var10, var11, var12))
							{
								continue label73;
							}
						}

						if (world.getBlockId(var10, var11, var12) == 0)
						{
							if (itemRand.nextInt(10) != 0)
							{
								world.setBlockAndMetadataWithNotify(var10, var11, var12, Zoo.savannahgrass.blockID, 1);
							}else{
								ForgeHooks.plantGrassPlant(world, var10, var11, var12);
							}
						}
					}
				}
				return true;

			}
		}
		return false;
	}
}