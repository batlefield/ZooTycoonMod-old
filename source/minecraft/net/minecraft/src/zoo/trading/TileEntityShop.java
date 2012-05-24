package net.minecraft.src.zoo.trading;

import net.minecraft.src.Block;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

public class TileEntityShop extends TileEntity{
	
	private short type = 0;
	private String[] types = "Decoration Shop, Dirt Shop, Fencing shop, Food Shop, Plants Shop, Potion Shop, Special Shop, Tech Shop, Tools Shop".split(", ");
	
	public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        type = nbt.getShort("type");
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("type", type);
    }
    
    public String[] getTypesAsString()
    {
    	return types;
    }
    
    public int getType()
    {
    	return type;
    }
    
    public void setType(int i)
    {
    	if(!(i < 0) && !(i >= 9))
    	{
    		type = (short)i;
    	}
    }
    
    //TODO: finish off all od generations, so that shops generate properly
    public void generate(int t)
    {
    	if(t == 0)
    	{
    		houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
    		decorationShop(worldObj, xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
    	}
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
		if (direction == 4)
		{
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);
			
			world.setBlockAndMetadataWithNotify(x - 2, y, z - 1, Block.chest.blockID, 3);
			world.setBlockAndMetadataWithNotify(x - 2, y, z - 2, Block.chest.blockID, 3);
		}
		if (direction ==5)
		{
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
			
			world.setBlockAndMetadataWithNotify(x - 1, y, z - 2, Block.chest.blockID, 3);
			world.setBlockAndMetadataWithNotify(x - 2, y, z - 2, Block.chest.blockID, 3);
			}
		if (direction == 6)
		{
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z - 2, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
			
			world.setBlockAndMetadataWithNotify(x + 2, y, z + 1, Block.chest.blockID, 3);
			world.setBlockAndMetadataWithNotify(x + 2, y, z + 2, Block.chest.blockID, 3);
		}
		if (direction == 7)
		{
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x - 2, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
			
			world.setBlockAndMetadataWithNotify(x + 1, y, z + 2, Block.chest.blockID, 3);
			world.setBlockAndMetadataWithNotify(x + 2, y, z + 2, Block.chest.blockID, 3);
		}
		

	}

	public void decorationShop(World world, int x, int y, int z, int direction)
	{
		System.out.println("decor2");
		StructureGenerator generator = new StructureGenerator();
		if (direction == 2)
		{
			world.setBlockWithNotify(x, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.cloth.blockID);
			
			generator.generatePillar(world, x - 2, y, z - 1, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x - 2, y, z + 2, Block.bookShelf.blockID, 2);
		}
		if (direction == 3)
		{
			world.setBlockWithNotify(x, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.cloth.blockID);
			 
			generator.generatePillar(world, x - 1, y, z - 2, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x - 2, y, z + 2, Block.bookShelf.blockID, 2);
		}
		if (direction == 4)
		{
			world.setBlockWithNotify(x, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z - 2, Block.cloth.blockID);
			
			generator.generatePillar(world, x + 2, y, z + 1, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x + 2, y, z - 2, Block.bookShelf.blockID, 2);
		}
		if (direction == 5)
		{
			world.setBlockWithNotify(x, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x - 2, y, z, Block.cloth.blockID);
			 
			generator.generatePillar(world, x + 1, y, z + 2, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x + 2, y, z - 2, Block.bookShelf.blockID, 2);
		}
			

	}

	public void houseBase(World world, int x, int y, int z, int blockID, int blockMD, int pillarID, int direction)
	{
		StructureGenerator generator = new StructureGenerator();

		world.editingBlocks = true;
		if (direction == 5)
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
		if (direction == 2)
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
		if (direction == 4)
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
		if (direction == 3)
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
}
