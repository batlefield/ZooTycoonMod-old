package net.minecraft.src.zoo.trading;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

;

public class BlockShop extends Block implements ITextureProvider
{

	public BlockShop(int i)
	{
		super(i, Material.wood);
	}

	public String getTextureFile()
	{
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
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 1);
					break;
				case 1:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 2);
					break;
				case 2:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 3);
					break;
				case 3:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 0);
					break;
				case 4:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 5);
					break;
				case 5:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 6);
					break;
				case 6:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 7);
					break;
				case 7:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 4);
					break;
				case 8:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 9);
					break;
				case 9:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 10);
					break;
				case 10:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 11);
					break;
				case 11:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 8);
					break;
				case 12:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 13);
					break;
				case 13:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 14);
					break;
				case 14:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 15);
					break;
				case 15:
					world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopkeeperblockdouble.blockID, 12);
					break;

				}
			}
			else
			{
				if (md == 0 || md == 1 || md == 2 || md == 3)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					foodShop(world, i, j, k, md);
				}
				if (md == 4 || md == 5 || md == 6 || md == 7)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					dirtShop(world, i, j, k, md);
				}
				if (md == 8 || md == 9 || md == 10 || md == 11)
				{
					houseBase(world, i, j, k, Block.blockSteel.blockID, 0, Block.stoneBrick.blockID, md);
					diamondShop(world, i, j, k, md);
				}
				if (md == 12 || md == 13 || md == 14 || md == 15)
				{
					houseBase(world, i, j, k, Block.planks.blockID, 0, Block.wood.blockID, md);
					technicShop(world, i, j, k, md);
				}
			}
		}

		return true;
	}

	public void foodShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 0)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);

			world.setBlockWithNotify(x, y + 1, z - 1, Block.cake.blockID);
			world.setBlockWithNotify(x, y + 1, z + 2, Block.cake.blockID);
		}
		if (direction == 1)
		{
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);

			world.setBlockWithNotify(x - 1, y + 1, z, Block.cake.blockID);
			world.setBlockWithNotify(x + 2, y + 1, z, Block.cake.blockID);
		}
		if (direction == 2)
		{
			world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);

			world.setBlockWithNotify(x, y + 1, z + 2, Block.cake.blockID);
			world.setBlockWithNotify(x, y + 1, z - 1, Block.cake.blockID);
		}
		if (direction == 3)
		{
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);

			world.setBlockWithNotify(x + 2, y + 1, z, Block.cake.blockID);
			world.setBlockWithNotify(x - 1, y + 1, z, Block.cake.blockID);
		}
	}

	public void dirtShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 4)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.grass.blockID);
		}
		if (direction == 5)
		{
			world.setBlockWithNotify(x - 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.grass.blockID);
		}
		if (direction == 6)
		{
			world.setBlockWithNotify(x, y, z + 2, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.grass.blockID);
		}
		if (direction == 7)
		{
			world.setBlockWithNotify(x + 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.grass.blockID);
		}
	}

	public void diamondShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 8)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x, y + 1, z - 1, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y + 1, z + 2, Block.blockDiamond.blockID);
		}
		if (direction == 9)
		{
			world.setBlockWithNotify(x - 1, y, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x - 1, y + 1, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x + 2, y + 1, z, Block.blockDiamond.blockID);
		}
		if (direction == 10)
		{
			world.setBlockWithNotify(x, y, z + 2, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x, y + 1, z + 2, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y + 1, z - 1, Block.blockDiamond.blockID);
		}
		if (direction == 11)
		{
			world.setBlockWithNotify(x + 1, y, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x + 2, y + 1, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x - 1, y + 1, z, Block.blockDiamond.blockID);
		}
	}

	public void technicShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 12)
		{
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z + 1, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x + 1, y + 2, z - 1, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x + 1, y + 2, z + 2, Block.torchRedstoneActive.blockID);
		}
		if (direction == 13)
		{
			world.setBlockAndMetadataWithNotify(x - 1, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 1, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x - 1, y + 2, z - 1, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z - 1, Block.torchRedstoneActive.blockID);
		}
		if (direction == 14)
		{
			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z + 1, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x - 1, y + 2, z + 2, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x - 1, y + 2, z - 1, Block.torchRedstoneActive.blockID);
		}
		if (direction == 15)
		{
			world.setBlockAndMetadataWithNotify(x + 1, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x - 1, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x + 2, y + 2, z + 1, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x - 1, y + 2, z + 1, Block.torchRedstoneActive.blockID);
		}
	}

	public void potionShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 0)
		{
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);

			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.cauldron.blockID, 3);
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.cauldron.blockID, 3);
			
			world.setBlockWithNotify(x + 2, y, z + 2, Block.brewingStand.blockID);
			world.setBlockWithNotify(x + 2, y, z - 1, Block.brewingStand.blockID);
		}
		if (direction == 8)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x, y + 1, z - 1, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y + 1, z + 2, Block.blockDiamond.blockID);
		}
		if (direction == 9)
		{
			world.setBlockWithNotify(x - 1, y, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x - 1, y + 1, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x + 2, y + 1, z, Block.blockDiamond.blockID);
		}
		if (direction == 10)
		{
			world.setBlockWithNotify(x, y, z + 2, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x, y + 1, z + 2, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y + 1, z - 1, Block.blockDiamond.blockID);
		}
		if (direction == 11)
		{
			world.setBlockWithNotify(x + 1, y, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x + 2, y + 1, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x - 1, y + 1, z, Block.blockDiamond.blockID);
		}
	}

	public void armorShop(World world, int x, int y, int z, int direction)
	{

	}

	public void decorationShop(World world, int x, int y, int z, int direction)
	{

	}

	public void houseBase(World world, int x, int y, int z, int blockID, int blockMD, int pillarID, int direction)
	{
		StructureGenerator generator = new StructureGenerator();

		world.editingBlocks = true;
		if (direction == 0 || direction == 4 || direction == 8 || direction == 12)
		{
			generator.generateCuboid(world, x, y - 1, z - 2, x + 3, y + 5, z + 3, 0);

			generator.generatePillar(world, x, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x + 3, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x, y, z + 3, pillarID, 3);
			generator.generatePillar(world, x + 3, y, z + 3, pillarID, 3);

			generator.generateCuboid(world, x + 1, y, z - 2, x + 2, y + 2, z - 2, blockID);
			generator.generateCuboid(world, x + 1, y, z + 3, x + 2, y + 2, z + 3, blockID);

			generator.generateCuboid(world, x + 3, y, z - 1, x + 3, y + 2, z + 2, blockID, blockMD);

			generator.generateFloor(world, y - 1, x, z - 2, x + 3, z + 3, blockID);

			generator.generateFloor(world, y + 3, x, z - 1, x, z + 2, blockID);
			generator.generateFloor(world, y + 3, x + 3, z - 1, x + 3, z + 2, blockID);
			generator.generateFloor(world, y + 2, x, z - 1, x, z + 2, Block.thinGlass.blockID);

			generator.placeBlock(world, x, y + 4, z, blockID);
			generator.placeBlock(world, x, y + 4, z + 1, blockID);
			generator.placeBlock(world, x + 3, y + 4, z, blockID);
			generator.placeBlock(world, x + 3, y + 4, z + 1, blockID);

			world.setBlockAndMetadataWithNotify(x + 3, y, z + 1, Block.doorWood.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y, z, Block.doorWood.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y + 1, z + 1, Block.doorWood.blockID, 8);
			world.setBlockAndMetadataWithNotify(x + 3, y + 1, z, Block.doorWood.blockID, 9);

			world.setBlockWithNotify(x + 2, y + 2, z - 1, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z + 2, Block.torchWood.blockID);

			generator.generateFloor(world, y + 3, x, z + 3, x + 3, z + 3, Block.stairCompactCobblestone.blockID, generator.StairsPointSouthward);
			generator.generateFloor(world, y + 4, x, z + 2, x + 3, z + 2, Block.stairCompactCobblestone.blockID, generator.StairsPointSouthward);
			generator.generateFloor(world, y + 5, x, z + 1, x + 3, z + 1, Block.stairCompactCobblestone.blockID, generator.StairsPointSouthward);

			generator.generateFloor(world, y + 3, x, z - 2, x + 3, z - 2, Block.stairCompactCobblestone.blockID, generator.StairsPointNorthward);
			generator.generateFloor(world, y + 4, x, z - 1, x + 3, z - 1, Block.stairCompactCobblestone.blockID, generator.StairsPointNorthward);
			generator.generateFloor(world, y + 5, x, z, x + 3, z, Block.stairCompactCobblestone.blockID, generator.StairsPointNorthward);
		}
		if (direction == 1 || direction == 5 || direction == 9 || direction == 13)
		{
			generator.generateCuboid(world, x - 2, y - 1, z, x + 3, y + 6, z - 3, 0);

			generator.generatePillar(world, x + 3, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z - 3, pillarID, 0, 3);
			generator.generatePillar(world, x + 3, y, z - 3, pillarID, 0, 3);

			generator.generateCuboid(world, x - 2, y, z - 1, x - 2, y + 2, z - 2, blockID);
			generator.generateCuboid(world, x + 3, y, z - 1, x + 3, y + 2, z - 2, blockID);

			generator.generateCuboid(world, x - 1, y, z - 3, x + 2, y + 2, z - 3, blockID, blockMD);

			generator.generateFloor(world, y - 1, x - 2, z, x + 4, z - 3, blockID);

			generator.generateFloor(world, y + 3, x - 1, z, x + 2, z, blockID);
			generator.generateFloor(world, y + 3, x - 1, z - 3, x + 2, z - 3, blockID);
			generator.generateFloor(world, y + 2, x - 1, z, x + 2, z, Block.thinGlass.blockID);

			generator.placeBlock(world, x, y + 4, z, blockID);
			generator.placeBlock(world, x + 1, y + 4, z, blockID);
			generator.placeBlock(world, x, y + 4, z - 3, blockID);
			generator.placeBlock(world, x + 1, y + 4, z - 3, blockID);

			world.setBlockAndMetadataWithNotify(x, y, z - 3, Block.doorWood.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 1, y, z - 3, Block.doorWood.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y + 1, z - 3, Block.doorWood.blockID, 9);
			world.setBlockAndMetadataWithNotify(x + 1, y + 1, z - 3, Block.doorWood.blockID, 8);

			world.setBlockWithNotify(x - 1, y + 2, z - 2, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z - 2, Block.torchWood.blockID);

			for (int i = 0; i < 4; i++)
			{
				world.setBlockAndMetadataWithNotify(x - 2, y + 3, z - i, Block.stairCompactCobblestone.blockID, generator.StairsPointWestward);
				world.setBlockAndMetadataWithNotify(x - 1, y + 4, z - i, Block.stairCompactCobblestone.blockID, generator.StairsPointWestward);
				world.setBlockAndMetadataWithNotify(x, y + 5, z - i, Block.stairCompactCobblestone.blockID, generator.StairsPointWestward);

				world.setBlockAndMetadataWithNotify(x + 1, y + 5, z - i, Block.stairCompactCobblestone.blockID, generator.StairsPointEastward);
				world.setBlockAndMetadataWithNotify(x + 2, y + 4, z - i, Block.stairCompactCobblestone.blockID, generator.StairsPointEastward);
				world.setBlockAndMetadataWithNotify(x + 3, y + 3, z - i, Block.stairCompactCobblestone.blockID, generator.StairsPointEastward);
			}

		}
		if (direction == 2 || direction == 6 || direction == 10 || direction == 14)
		{
			generator.generateCuboid(world, x, y - 1, z - 2, x - 3, y + 5, z + 3, 0);

			generator.generatePillar(world, x, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x - 3, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x, y, z + 3, pillarID, 3);
			generator.generatePillar(world, x - 3, y, z + 3, pillarID, 3);

			generator.generateCuboid(world, x - 1, y, z - 2, x - 2, y + 2, z - 2, blockID);
			generator.generateCuboid(world, x - 1, y, z + 3, x - 2, y + 2, z + 3, blockID);

			generator.generateCuboid(world, x - 3, y, z - 1, x - 3, y + 2, z + 2, blockID, blockMD);

			generator.generateFloor(world, y - 1, x, z - 2, x - 3, z + 3, blockID);

			generator.generateFloor(world, y + 3, x, z - 1, x, z + 2, blockID);
			generator.generateFloor(world, y + 3, x - 3, z - 1, x - 3, z + 2, blockID);
			generator.generateFloor(world, y + 2, x, z - 1, x, z + 2, Block.thinGlass.blockID);

			generator.placeBlock(world, x, y + 4, z, blockID);
			generator.placeBlock(world, x, y + 4, z + 1, blockID);
			generator.placeBlock(world, x - 3, y + 4, z, blockID);
			generator.placeBlock(world, x - 3, y + 4, z + 1, blockID);

			world.setBlockAndMetadataWithNotify(x - 3, y, z + 1, Block.doorWood.blockID, 0);
			world.setBlockAndMetadataWithNotify(x - 3, y, z, Block.doorWood.blockID, 0);
			world.setBlockAndMetadataWithNotify(x - 3, y + 1, z + 1, Block.doorWood.blockID, 9);
			world.setBlockAndMetadataWithNotify(x - 3, y + 1, z, Block.doorWood.blockID, 8);

			world.setBlockWithNotify(x - 2, y + 2, z - 1, Block.torchWood.blockID);
			world.setBlockWithNotify(x - 2, y + 2, z + 2, Block.torchWood.blockID);

			generator.generateFloor(world, y + 3, x, z + 3, x - 3, z + 3, Block.stairCompactCobblestone.blockID, generator.StairsPointSouthward);
			generator.generateFloor(world, y + 4, x, z + 2, x - 3, z + 2, Block.stairCompactCobblestone.blockID, generator.StairsPointSouthward);
			generator.generateFloor(world, y + 5, x, z + 1, x - 3, z + 1, Block.stairCompactCobblestone.blockID, generator.StairsPointSouthward);

			generator.generateFloor(world, y + 3, x, z - 2, x - 3, z - 2, Block.stairCompactCobblestone.blockID, generator.StairsPointNorthward);
			generator.generateFloor(world, y + 4, x, z - 1, x - 3, z - 1, Block.stairCompactCobblestone.blockID, generator.StairsPointNorthward);
			generator.generateFloor(world, y + 5, x, z, x - 3, z, Block.stairCompactCobblestone.blockID, generator.StairsPointNorthward);
		}
		if (direction == 3 || direction == 7 || direction == 11 || direction == 15)
		{
			generator.generateCuboid(world, x - 2, y - 1, z, x + 3, y + 6, z + 3, 0);

			generator.generatePillar(world, x + 3, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z + 3, pillarID, 0, 3);
			generator.generatePillar(world, x + 3, y, z + 3, pillarID, 0, 3);

			generator.generateCuboid(world, x - 2, y, z + 1, x - 2, y + 2, z + 2, blockID);
			generator.generateCuboid(world, x + 3, y, z + 1, x + 3, y + 2, z + 2, blockID);

			generator.generateCuboid(world, x - 1, y, z + 3, x + 2, y + 2, z + 3, blockID, blockMD);

			generator.generateFloor(world, y - 1, x - 2, z, x + 3, z + 3, blockID);

			generator.generateFloor(world, y + 3, x - 1, z, x + 2, z, blockID);
			generator.generateFloor(world, y + 3, x - 1, z + 3, x + 2, z + 3, blockID);
			generator.generateFloor(world, y + 2, x - 1, z, x + 2, z, Block.thinGlass.blockID);

			generator.placeBlock(world, x, y + 4, z, blockID);
			generator.placeBlock(world, x + 1, y + 4, z, blockID);
			generator.placeBlock(world, x, y + 4, z + 3, blockID);
			generator.placeBlock(world, x + 1, y + 4, z + 3, blockID);

			world.setBlockAndMetadataWithNotify(x, y, z + 3, Block.doorWood.blockID, 3);
			world.setBlockAndMetadataWithNotify(x + 1, y, z + 3, Block.doorWood.blockID, 3);
			world.setBlockAndMetadataWithNotify(x, y + 1, z + 3, Block.doorWood.blockID, 8);
			world.setBlockAndMetadataWithNotify(x + 1, y + 1, z + 3, Block.doorWood.blockID, 9);

			world.setBlockWithNotify(x - 1, y + 2, z + 2, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z + 2, Block.torchWood.blockID);

			for (int i = 0; i < 4; i++)
			{
				world.setBlockAndMetadataWithNotify(x - 2, y + 3, z + i, Block.stairCompactCobblestone.blockID, generator.StairsPointWestward);
				world.setBlockAndMetadataWithNotify(x - 1, y + 4, z + i, Block.stairCompactCobblestone.blockID, generator.StairsPointWestward);
				world.setBlockAndMetadataWithNotify(x, y + 5, z + i, Block.stairCompactCobblestone.blockID, generator.StairsPointWestward);

				world.setBlockAndMetadataWithNotify(x + 1, y + 5, z + i, Block.stairCompactCobblestone.blockID, generator.StairsPointEastward);
				world.setBlockAndMetadataWithNotify(x + 2, y + 4, z + i, Block.stairCompactCobblestone.blockID, generator.StairsPointEastward);
				world.setBlockAndMetadataWithNotify(x + 3, y + 3, z + i, Block.stairCompactCobblestone.blockID, generator.StairsPointEastward);
			}

		}
		world.editingBlocks = false;
	}

	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this, 1, 0));
		itemList.add(new ItemStack(this, 1, 4));
		itemList.add(new ItemStack(this, 1, 8));
		itemList.add(new ItemStack(this, 1, 12));
	}
}
