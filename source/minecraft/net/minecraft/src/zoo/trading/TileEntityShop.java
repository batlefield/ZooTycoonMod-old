package net.minecraft.src.zoo.trading;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.GUIIDEnum;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

public class TileEntityShop extends TileEntity
{

	private short type = -1;
	private String[] types = "Decoration Shop, Dirt Shop, Fencing shop, Food Shop, Florists Shop, Magic and Alchemy Shop, Special Shop, Tech Shop, Tools & Armor Shop".split(", ");
	private int[] prices = {
			485, 265, 317, 565, 260, 783, 36777, 713, 275
	};
	
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
	
	public int[] getPrices()
	{
		return prices;
	}

	public String[] getTypesAsString()
	{
		return types;
	}

	public int getType()
	{
		return type;
	}
	
	public boolean isTypeValid(int i)
	{
		return i >= 0 && i <= 9;
	}

	public void setType(int i)
	{
		if (!(i < 0) && !(i >= 9))
		{
			type = (short) i;
		}
	}

	public void blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		if (entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID))
		{
			int md = world.getBlockMetadata(i, j, k);
			if (md == 4)
			{
				world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopBlock.blockID, 3);
				return;
			}
			if (md == 3)
			{
				world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopBlock.blockID, 5);
				return;
			}
			if (md == 5)
			{
				world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopBlock.blockID, 2);
				return;
			}
			if (md == 2)
			{
				world.setBlockAndMetadataWithNotify(i, j, k, mod_ZooTrade.shopBlock.blockID, 4);
				return;
			}

		} else
		{
			entityplayer.openGui(mod_ZooTrade.getInstance(), GUIIDEnum.SHOP_BLOCK_SETTINGS.ID, world, i, j, k);
		}
	}

	public void generate(int t)
	{
		if(Trade.decreaseMoney(prices[t]))
		{
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Shop generated!");
		}else{
			return;
		}
		
		
		int md = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		Entity entity = new ZooEntityShopKeeper(worldObj, type + 1);
		if (md == 2)
		{
			entity.setLocationAndAngles(xCoord - 0.5, yCoord, zCoord - 1.5, 0.0F, 0.0F);
		}
		if (md == 3)
		{
			entity.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 1.5, 0.0F, 0.0F);
		}
		if (md == 4)
		{
			entity.setLocationAndAngles(xCoord - 1.5, yCoord, zCoord + 0.5, 0.0F, 0.0F);
		}
		if (md == 5)
		{
			entity.setLocationAndAngles(xCoord + 1.5, yCoord, zCoord - 0.5, 0.0F, 0.0F);
		}

		worldObj.spawnEntityInWorld(entity);

		if (t == 0)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, md);
			decorationShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 1)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, md);
			dirtShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 2)
		{
			fenceShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 3)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, md);
			foodShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 4)
		{
			natureShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 5)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, md);
			potionShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 6)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.blockSteel.blockID, 0, Block.stoneBrick.blockID, md);
			specialShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 7)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, md);
			technicShop(worldObj, xCoord, yCoord, zCoord, md);
		}
		if (t == 8)
		{
			houseBase(worldObj, xCoord, yCoord, zCoord, Block.planks.blockID, 0, Block.wood.blockID, md);
			armorAndToolsShop(worldObj, xCoord, yCoord, zCoord, md);
		}
	}

	public void fenceShop(World world, int x, int y, int z, int direction)
	{
		StructureGenerator generator = new StructureGenerator();
		world.editingBlocks = true;
		if (direction == 2)
		{
			x--;
			generator.generateCuboid(world, x + 3, y, z, x - 2, y + 4, z - 3, 0);

			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);

			world.setBlockWithNotify(x, y, z - 1, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 1, y, z - 1, Block.torchWood.blockID);

			world.setBlockWithNotify(x + 2, y, z, Block.fence.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.fence.blockID);

			world.setBlockWithNotify(x - 1, y, z - 3, Block.fence.blockID);
			world.setBlockWithNotify(x + 2, y, z - 3, Block.fence.blockID);

			world.setBlockAndMetadataWithNotify(x + 1, y, z - 3, Block.fenceGate.blockID, 0);
			world.setBlockAndMetadataWithNotify(x, y, z - 3, Block.fenceGate.blockID, 0);

			generator.generateFloor(world, y + 3, x + 2, z, x - 1, z - 3, Block.planks.blockID);

			world.setBlockWithNotify(x - 2, y, z - 1, Block.fence.blockID);
			world.setBlockWithNotify(x - 2, y, z - 2, Block.fence.blockID);
			world.setBlockWithNotify(x + 3, y, z - 1, Block.fence.blockID);
			world.setBlockWithNotify(x + 3, y, z - 2, Block.fence.blockID);

			world.setBlockAndMetadataWithNotify(x - 2, y + 3, z, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x - 2, y + 3, z - 1, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x - 2, y + 3, z - 2, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x - 2, y + 3, z - 3, Block.stairSingle.blockID, 2);

			world.setBlockAndMetadataWithNotify(x + 3, y + 3, z, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y + 3, z - 1, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y + 3, z - 2, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y + 3, z - 3, Block.stairSingle.blockID, 2);

			generator.generateHollowFloor(world, y + 2, x + 3, z, x - 2, z - 3, Block.fence.blockID);

			generator.generatePillar(world, x - 2, y, z, Block.fence.blockID, 3);
			generator.generatePillar(world, x + 3, y, z, Block.fence.blockID, 3);
			generator.generatePillar(world, x - 2, y, z - 3, Block.fence.blockID, 3);
			generator.generatePillar(world, x + 3, y, z - 3, Block.fence.blockID, 3);

			world.editingBlocks = false;
			return;

		}
		if (direction == 4)
		{
			generator.generateCuboid(world, x, y, z + 3, x - 3, y + 4, z - 2, 0);

			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);

			world.setBlockWithNotify(x - 1, y, z, Block.torchWood.blockID);
			world.setBlockWithNotify(x - 1, y, z + 1, Block.torchWood.blockID);

			world.setBlockWithNotify(x, y, z + 2, Block.fence.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.fence.blockID);

			world.setBlockWithNotify(x - 3, y, z - 1, Block.fence.blockID);
			world.setBlockWithNotify(x - 3, y, z + 2, Block.fence.blockID);

			world.setBlockAndMetadataWithNotify(x - 3, y, z + 1, Block.fenceGate.blockID, 1);
			world.setBlockAndMetadataWithNotify(x - 3, y, z, Block.fenceGate.blockID, 1);

			generator.generateFloor(world, y + 3, x, z + 2, x - 3, z - 1, Block.planks.blockID);

			generator.generateCuboid(world, x - 1, y, z - 2, x - 2, y, z - 2, Block.fence.blockID);
			generator.generateCuboid(world, x - 1, y, z + 3, x - 2, y, z + 3, Block.fence.blockID);

			generator.generateCuboid(world, x, y + 3, z - 2, x - 3, y + 3, z - 2, Block.stairSingle.blockID, 2);
			generator.generateCuboid(world, x, y + 3, z + 3, x - 3, y + 3, z + 3, Block.stairSingle.blockID, 2);

			generator.generateHollowFloor(world, y + 2, x, z + 3, x - 3, z - 2, Block.fence.blockID);

			generator.generatePillar(world, x, y, z - 2, Block.fence.blockID, 3);
			generator.generatePillar(world, x, y, z + 3, Block.fence.blockID, 3);
			generator.generatePillar(world, x - 3, y, z - 2, Block.fence.blockID, 3);
			generator.generatePillar(world, x - 3, y, z + 3, Block.fence.blockID, 3);

			world.editingBlocks = false;
			return;

		}
		if (direction == 5)
		{
			generator.generateCuboid(world, x, y, z - 3, x + 3, y + 4, z - 2, 0);

			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);

			world.setBlockWithNotify(x + 1, y, z, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 1, y, z - 1, Block.torchWood.blockID);

			world.setBlockWithNotify(x, y, z - 2, Block.fence.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.fence.blockID);

			world.setBlockWithNotify(x + 3, y, z + 1, Block.fence.blockID);
			world.setBlockWithNotify(x + 3, y, z - 2, Block.fence.blockID);

			world.setBlockAndMetadataWithNotify(x + 3, y, z - 1, Block.fenceGate.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 3, y, z, Block.fenceGate.blockID, 1);

			generator.generateFloor(world, y + 3, x, z - 2, x + 3, z + 1, Block.planks.blockID);

			generator.generateCuboid(world, x + 1, y, z + 2, x + 2, y, z + 2, Block.fence.blockID);
			generator.generateCuboid(world, x + 1, y, z - 3, x + 2, y, z - 3, Block.fence.blockID);

			generator.generateCuboid(world, x, y + 3, z + 2, x + 3, y + 3, z + 2, Block.stairSingle.blockID, 2);
			generator.generateCuboid(world, x, y + 3, z - 3, x + 3, y + 3, z - 3, Block.stairSingle.blockID, 2);

			generator.generateHollowFloor(world, y + 2, x, z - 3, x + 3, z + 2, Block.fence.blockID);

			generator.generatePillar(world, x, y, z + 2, Block.fence.blockID, 3);
			generator.generatePillar(world, x, y, z - 3, Block.fence.blockID, 3);
			generator.generatePillar(world, x + 3, y, z + 2, Block.fence.blockID, 3);
			generator.generatePillar(world, x + 3, y, z - 3, Block.fence.blockID, 3);

			world.editingBlocks = false;
			return;
		}
		if (direction == 3)
		{
			x++;
			generator.generateCuboid(world, x - 3, y, z, x + 2, y + 4, z + 3, 0);

			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);

			world.setBlockWithNotify(x, y, z + 1, Block.torchWood.blockID);
			world.setBlockWithNotify(x - 1, y, z + 1, Block.torchWood.blockID);

			world.setBlockWithNotify(x - 2, y, z, Block.fence.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.fence.blockID);

			world.setBlockWithNotify(x + 1, y, z + 3, Block.fence.blockID);
			world.setBlockWithNotify(x - 2, y, z + 3, Block.fence.blockID);

			world.setBlockAndMetadataWithNotify(x - 1, y, z + 3, Block.fenceGate.blockID, 0);
			world.setBlockAndMetadataWithNotify(x, y, z + 3, Block.fenceGate.blockID, 0);

			generator.generateFloor(world, y + 3, x - 2, z, x + 1, z + 3, Block.planks.blockID);

			world.setBlockWithNotify(x + 2, y, z + 1, Block.fence.blockID);
			world.setBlockWithNotify(x + 2, y, z + 2, Block.fence.blockID);
			world.setBlockWithNotify(x - 3, y, z + 1, Block.fence.blockID);
			world.setBlockWithNotify(x - 3, y, z + 2, Block.fence.blockID);

			world.setBlockAndMetadataWithNotify(x + 2, y + 3, z, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 2, y + 3, z + 1, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 2, y + 3, z + 2, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 2, y + 3, z + 3, Block.stairSingle.blockID, 2);

			world.setBlockAndMetadataWithNotify(x - 3, y + 3, z, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x - 3, y + 3, z + 1, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x - 3, y + 3, z + 2, Block.stairSingle.blockID, 2);
			world.setBlockAndMetadataWithNotify(x - 3, y + 3, z + 3, Block.stairSingle.blockID, 2);

			generator.generateHollowFloor(world, y + 2, x - 3, z, x + 2, z + 3, Block.fence.blockID);

			generator.generatePillar(world, x + 2, y, z, Block.fence.blockID, 3);
			generator.generatePillar(world, x - 3, y, z, Block.fence.blockID, 3);
			generator.generatePillar(world, x + 2, y, z + 3, Block.fence.blockID, 3);
			generator.generatePillar(world, x - 3, y, z + 3, Block.fence.blockID, 3);

			world.editingBlocks = false;
			return;
		}

	}

	public void natureShop(World world, int x, int y, int z, int direction)
	{
		StructureGenerator generator = new StructureGenerator();
		int pillarID = Block.wood.blockID;
		int blockID = Block.planks.blockID;
		int flowerID;
		if(worldObj.rand.nextInt(10) == 0){
			flowerID = Block.plantYellow.blockID;
		}else{
			flowerID = Block.plantRed.blockID;
		}
		world.editingBlocks = true;
		if (direction == 5)
		{
			z--;
			generator.generateCuboid(world, x, y - 1, z - 2, x + 3, y + 4, z + 3, 0);

			generator.generatePillar(world, x, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x + 3, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x, y, z + 3, pillarID, 3);
			generator.generatePillar(world, x + 3, y, z + 3, pillarID, 3);

			generator.generateCuboid(world, x + 1, y, z - 2, x + 2, y + 2, z - 2, blockID);
			generator.generateCuboid(world, x + 1, y, z + 3, x + 2, y + 2, z + 3, blockID);

			generator.generateCuboid(world, x + 3, y, z - 1, x + 3, y + 2, z + 2, blockID, 0);

			generator.generateFloor(world, y - 1, x, z - 2, x + 3, z + 3, blockID);

			generator.generateFloor(world, y, x, z - 1, x, z + 2, Block.leaves.blockID, 4);
			generator.generateFloor(world, y + 2, x, z - 1, x, z + 2, Block.thinGlass.blockID);
			generator.generateHollowFloor(world, y + 3, x, z - 2, x + 3, z + 3, Block.leaves.blockID, 4);
			generator.generateFloor(world, y + 4, x, z - 1, x + 3, z + 2, Block.leaves.blockID, 4);
			
			generator.placeBlock(world, x, y + 2, z + 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 1, y + 2, z + 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x, y + 2, z - 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 1, y + 2, z - 2, Block.leaves.blockID, 4);
			
			generator.placeBlock(world, x + 3, y + 2, z + 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 4, y + 2, z + 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 3, y + 2, z - 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 4, y + 2, z - 2, Block.leaves.blockID, 4);

			world.setBlockAndMetadataWithNotify(x + 3, y, z + 1, Block.doorWood.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y, z, Block.doorWood.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 3, y + 1, z + 1, Block.doorWood.blockID, 8);
			world.setBlockAndMetadataWithNotify(x + 3, y + 1, z, Block.doorWood.blockID, 9);

			world.setBlockWithNotify(x + 2, y + 2, z - 1, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z + 2, Block.torchWood.blockID);
			
			generator.placeBlock(world, x + 2, y, z - 1, Block.grass.blockID);
			generator.placeBlock(world, x + 2, y, z + 2, Block.grass.blockID);
			generator.placeBlock(world, x + 2, y + 1, z - 1, flowerID);
			generator.placeBlock(world, x + 2, y + 1, z + 2, flowerID);
			

		}
		if (direction == 2)
		{
			x--;
			generator.generateCuboid(world, x - 2, y - 1, z, x + 3, y + 4, z - 3, 0);

			generator.generatePillar(world, x + 3, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z - 3, pillarID, 0, 3);
			generator.generatePillar(world, x + 3, y, z - 3, pillarID, 0, 3);

			generator.generateCuboid(world, x - 2, y, z - 1, x - 2, y + 2, z - 2, blockID);
			generator.generateCuboid(world, x + 3, y, z - 1, x + 3, y + 2, z - 2, blockID);

			generator.generateCuboid(world, x - 1, y, z - 3, x + 2, y + 2, z - 3, blockID, 0);

			generator.generateFloor(world, y - 1, x - 2, z, x + 4, z - 3, blockID);

			generator.generateFloor(world, y, x - 1, z, x + 2, z, Block.leaves.blockID);
			generator.generateFloor(world, y + 2, x - 1, z, x + 2, z, Block.thinGlass.blockID);
			generator.generateHollowFloor(world, y + 3, x + 3, z, x - 2, z - 3, Block.leaves.blockID, 4);
			generator.generateFloor(world, y + 4, x + 2, z, x - 1, z - 3, Block.leaves.blockID, 4);

			generator.placeBlock(world, x - 3, y + 2, z, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 4, y + 2, z, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 2, y + 2, z + 1, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 3, y + 2, z + 1, Block.leaves.blockID, 4);
			
			generator.placeBlock(world, x - 2, y + 2, z - 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 3, y + 2, z - 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 3, y + 2, z - 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 4, y + 2, z - 3, Block.leaves.blockID, 4);
			
			world.setBlockAndMetadataWithNotify(x, y, z - 3, Block.doorWood.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 1, y, z - 3, Block.doorWood.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y + 1, z - 3, Block.doorWood.blockID, 9);
			world.setBlockAndMetadataWithNotify(x + 1, y + 1, z - 3, Block.doorWood.blockID, 8);

			world.setBlockWithNotify(x - 1, y + 2, z - 2, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z - 2, Block.torchWood.blockID);
			
			generator.placeBlock(world, x - 1, y, z - 2, Block.grass.blockID);
			generator.placeBlock(world, x + 2, y, z - 2, Block.grass.blockID);
			generator.placeBlock(world, x - 1, y + 1, z - 2, flowerID);
			generator.placeBlock(world, x + 2, y + 1, z - 2, flowerID);

		}
		if (direction == 4)
		{
			generator.generateCuboid(world, x, y - 1, z - 2, x - 3, y + 4, z + 3, 0);

			generator.generatePillar(world, x, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x - 3, y, z - 2, pillarID, 3);
			generator.generatePillar(world, x, y, z + 3, pillarID, 3);
			generator.generatePillar(world, x - 3, y, z + 3, pillarID, 3);

			generator.generateCuboid(world, x - 1, y, z - 2, x - 2, y + 2, z - 2, blockID);
			generator.generateCuboid(world, x - 1, y, z + 3, x - 2, y + 2, z + 3, blockID);

			generator.generateCuboid(world, x - 3, y, z - 1, x - 3, y + 2, z + 2, blockID, 0);

			generator.generateFloor(world, y - 1, x, z - 2, x - 3, z + 3, blockID);

			generator.generateFloor(world, y, x, z - 1, x, z + 2, Block.leaves.blockID, 4);
			generator.generateFloor(world, y + 2, x, z - 1, x, z + 2, Block.thinGlass.blockID);
			generator.generateHollowFloor(world, y + 3, x, z - 2, x - 3, z + 3, Block.leaves.blockID, 4);
			generator.generateFloor(world, y + 4, x, z - 1, x - 3, z + 2, Block.leaves.blockID, 4);

			generator.placeBlock(world, x, y + 2, z + 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 1, y + 2, z + 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x, y + 2, z - 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 1, y + 2, z - 2, Block.leaves.blockID, 4);
			
			generator.placeBlock(world, x - 3, y + 2, z + 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 4, y + 2, z + 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 3, y + 2, z - 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 4, y + 2, z - 2, Block.leaves.blockID, 4);

			world.setBlockAndMetadataWithNotify(x - 3, y, z + 1, Block.doorWood.blockID, 0);
			world.setBlockAndMetadataWithNotify(x - 3, y, z, Block.doorWood.blockID, 0);
			world.setBlockAndMetadataWithNotify(x - 3, y + 1, z + 1, Block.doorWood.blockID, 9);
			world.setBlockAndMetadataWithNotify(x - 3, y + 1, z, Block.doorWood.blockID, 8);

			world.setBlockWithNotify(x - 2, y + 2, z - 1, Block.torchWood.blockID);
			world.setBlockWithNotify(x - 2, y + 2, z + 2, Block.torchWood.blockID);
			
			generator.placeBlock(world, x - 2, y, z - 1, Block.grass.blockID);
			generator.placeBlock(world, x - 2, y, z + 2, Block.grass.blockID);
			generator.placeBlock(world, x - 2, y + 1, z - 1, flowerID);
			generator.placeBlock(world, x - 2, y + 1, z + 2, flowerID);
		}
		if (direction == 3)
		{
			generator.generateCuboid(world, x - 2, y - 1, z, x + 3, y + 4, z + 3, 0);

			generator.generatePillar(world, x + 3, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z, pillarID, 0, 3);
			generator.generatePillar(world, x - 2, y, z + 3, pillarID, 0, 3);
			generator.generatePillar(world, x + 3, y, z + 3, pillarID, 0, 3);

			generator.generateCuboid(world, x - 2, y, z + 1, x - 2, y + 2, z + 2, blockID);
			generator.generateCuboid(world, x + 3, y, z + 1, x + 3, y + 2, z + 2, blockID);

			generator.generateCuboid(world, x - 1, y, z + 3, x + 2, y + 2, z + 3, blockID, 0);

			generator.generateFloor(world, y - 1, x - 2, z, x + 3, z + 3, blockID);

			generator.generateFloor(world, y, x - 1, z, x + 2, z, Block.leaves.blockID);
			generator.generateFloor(world, y + 2, x - 1, z, x + 2, z, Block.thinGlass.blockID);
			generator.generateHollowFloor(world, y + 3, x + 3, z, x - 2, z + 3, Block.leaves.blockID, 4);
			generator.generateFloor(world, y + 4, x + 2, z, x - 1, z + 3, Block.leaves.blockID, 4);

			generator.placeBlock(world, x - 3, y + 2, z, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 4, y + 2, z, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 2, y + 2, z - 1, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 3, y + 2, z - 1, Block.leaves.blockID, 4);
			
			generator.placeBlock(world, x - 2, y + 2, z + 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 3, y + 2, z + 4, Block.leaves.blockID, 4);
			generator.placeBlock(world, x - 3, y + 2, z + 3, Block.leaves.blockID, 4);
			generator.placeBlock(world, x + 4, y + 2, z + 3, Block.leaves.blockID, 4);
			

			world.setBlockAndMetadataWithNotify(x, y, z + 3, Block.doorWood.blockID, 3);
			world.setBlockAndMetadataWithNotify(x + 1, y, z + 3, Block.doorWood.blockID, 3);
			world.setBlockAndMetadataWithNotify(x, y + 1, z + 3, Block.doorWood.blockID, 8);
			world.setBlockAndMetadataWithNotify(x + 1, y + 1, z + 3, Block.doorWood.blockID, 9);

			world.setBlockWithNotify(x - 1, y + 2, z + 2, Block.torchWood.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z + 2, Block.torchWood.blockID);
			
			generator.placeBlock(world, x - 1, y, z + 2, Block.grass.blockID);
			generator.placeBlock(world, x + 2, y, z + 2, Block.grass.blockID);
			generator.placeBlock(world, x - 1, y + 1, z + 2, flowerID);
			generator.placeBlock(world, x + 2, y + 1, z + 2, flowerID);

		}
		world.editingBlocks = false;
	}

	public void foodShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 5)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z - 2, Block.planks.blockID);

			world.setBlockWithNotify(x, y + 1, z - 2, Block.cake.blockID);
			world.setBlockWithNotify(x, y + 1, z + 1, Block.cake.blockID);
		}
		if (direction == 2)
		{
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x - 2, y, z, Block.planks.blockID);

			world.setBlockWithNotify(x + 1, y + 1, z, Block.cake.blockID);
			world.setBlockWithNotify(x - 2, y + 1, z, Block.cake.blockID);
		}
		if (direction == 4)
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
		if (direction == 5)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z - 2, Block.grass.blockID);
		}
		if (direction == 2)
		{
			world.setBlockWithNotify(x - 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x - 2, y, z, Block.grass.blockID);
		}
		if (direction == 4)
		{
			world.setBlockWithNotify(x, y, z + 2, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.grass.blockID);
		}
		if (direction == 3)
		{
			world.setBlockWithNotify(x + 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.grass.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.grass.blockID);
		}
	}

	public void specialShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 5)
		{
			z--;
			world.setBlockWithNotify(x, y, z - 1, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x, y + 1, z - 1, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y + 1, z + 2, Block.blockDiamond.blockID);
		}
		if (direction == 2)
		{
			x--;
			world.setBlockWithNotify(x - 1, y, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x - 1, y + 1, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x + 2, y + 1, z, Block.blockDiamond.blockID);
		}
		if (direction == 4)
		{
			world.setBlockWithNotify(x, y, z + 2, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x, y + 1, z + 2, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x, y + 1, z - 1, Block.blockDiamond.blockID);
		}
		if (direction == 3)
		{
			world.setBlockWithNotify(x + 1, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x, y, z, Block.blockGold.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.blockDiamond.blockID);

			world.setBlockWithNotify(x + 2, y + 1, z, Block.blockDiamond.blockID);
			world.setBlockWithNotify(x - 1, y + 1, z, Block.blockDiamond.blockID);
		}
	}

	public void technicShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 5)
		{
			z--;
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z + 1, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x + 1, y + 2, z - 1, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x + 1, y + 2, z + 2, Block.torchRedstoneActive.blockID);
		}
		if (direction == 2)
		{
			x--;
			world.setBlockAndMetadataWithNotify(x - 1, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 1, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x - 1, y + 2, z - 1, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x + 2, y + 2, z - 1, Block.torchRedstoneActive.blockID);
		}
		if (direction == 4)
		{
			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z + 1, Block.pistonBase.blockID, 1);
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.pistonBase.blockID, 1);

			world.setBlockWithNotify(x - 1, y + 2, z + 2, Block.torchRedstoneActive.blockID);
			world.setBlockWithNotify(x - 1, y + 2, z - 1, Block.torchRedstoneActive.blockID);
		}
		if (direction == 3)
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
		if (direction == 5)
		{
			z--;
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);

			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.cauldron.blockID, 3);
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.cauldron.blockID, 3);

			world.setBlockWithNotify(x + 2, y, z + 2, Block.brewingStand.blockID);
			world.setBlockWithNotify(x + 2, y, z - 1, Block.brewingStand.blockID);
		}
		if (direction == 4)
		{
			world.setBlockAndMetadataWithNotify(x, y, z - 1, Block.cauldron.blockID, 3);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.planks.blockID);
			world.setBlockAndMetadataWithNotify(x, y, z + 2, Block.cauldron.blockID, 3);

			world.setBlockWithNotify(x - 2, y, z - 1, Block.brewingStand.blockID);
			world.setBlockWithNotify(x - 2, y, z + 2, Block.brewingStand.blockID);
		}
		if (direction == 2)
		{
			x--;
			world.setBlockAndMetadataWithNotify(x - 1, y, z, Block.cauldron.blockID, 3);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
			world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.cauldron.blockID, 3);

			world.setBlockWithNotify(x - 1, y, z - 2, Block.brewingStand.blockID);
			world.setBlockWithNotify(x + 2, y, z - 2, Block.brewingStand.blockID);
		}
		if (direction == 3)
		{
			world.setBlockAndMetadataWithNotify(x + 2, y, z, Block.cauldron.blockID, 3);
			world.setBlockWithNotify(x, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.planks.blockID);
			world.setBlockAndMetadataWithNotify(x - 1, y, z, Block.cauldron.blockID, 3);

			world.setBlockWithNotify(x - 1, y, z + 2, Block.brewingStand.blockID);
			world.setBlockWithNotify(x + 2, y, z + 2, Block.brewingStand.blockID);
		}
	}

	public void armorAndToolsShop(World world, int x, int y, int z, int direction)
	{
		if (direction == 5)
		{
			z--;
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.workbench.blockID);

			world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);

			world.setBlockAndMetadataWithNotify(x + 2, y, z + 2, Block.chest.blockID, 4);
			world.setBlockAndMetadataWithNotify(x + 2, y, z - 1, Block.chest.blockID, 4);
		}
		if (direction == 4)
		{
			world.setBlockWithNotify(x, y, z - 1, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.workbench.blockID);
			world.setBlockWithNotify(x, y, z + 2, Block.planks.blockID);

			world.setBlockAndMetadataWithNotify(x - 2, y, z - 1, Block.chest.blockID, 5);
			world.setBlockAndMetadataWithNotify(x - 2, y, z + 2, Block.chest.blockID, 5);
		}
		if (direction == 2)
		{
			x--;
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);

			world.setBlockAndMetadataWithNotify(x - 1, y, z - 2, Block.chest.blockID, 3);
			world.setBlockAndMetadataWithNotify(x + 2, y, z - 2, Block.chest.blockID, 3);
		}
		if (direction == 3)
		{
			world.setBlockWithNotify(x + 2, y, z, Block.planks.blockID);
			world.setBlockWithNotify(x, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.workbench.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.planks.blockID);

			world.setBlockAndMetadataWithNotify(x - 1, y, z + 2, Block.chest.blockID, 2);
			world.setBlockAndMetadataWithNotify(x + 2, y, z + 2, Block.chest.blockID, 2);
		}

	}

	public void decorationShop(World world, int x, int y, int z, int direction)
	{
		StructureGenerator generator = new StructureGenerator();
		if (direction == 4)
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

			generator.generatePillar(world, x + 2, y, z + 2, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x - 1, y, z + 2, Block.bookShelf.blockID, 2);
		}
		if (direction == 5)
		{
			world.setBlockWithNotify(x, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z + 1, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z - 1, Block.cloth.blockID);
			world.setBlockWithNotify(x, y, z - 2, Block.cloth.blockID);

			generator.generatePillar(world, x + 2, y, z + 1, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x + 2, y, z - 2, Block.bookShelf.blockID, 2);
		}
		if (direction == 2)
		{
			x--;
			world.setBlockWithNotify(x, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x + 2, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x + 1, y, z, Block.cloth.blockID);
			world.setBlockWithNotify(x - 1, y, z, Block.cloth.blockID);

			generator.generatePillar(world, x - 1, y, z - 2, Block.bookShelf.blockID, 2);
			generator.generatePillar(world, x + 2, y, z - 2, Block.bookShelf.blockID, 2);
		}

	}

	public void houseBase(World world, int x, int y, int z, int blockID, int blockMD, int pillarID, int direction)
	{
		StructureGenerator generator = new StructureGenerator();

		world.editingBlocks = true;
		if (direction == 5)
		{
			z--;
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
			x--;
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
