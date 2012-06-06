package net.minecraft.src.zoo.core;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFence;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.mod_ZooCore;
import net.minecraft.src.BAPI.ItemKey;
import net.minecraft.src.BAPI.Main;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.gen.StructureGenerator;
import net.minecraft.src.zoo.trading.Trade;

public class TileEntityFencer extends TileEntityBase
{
	private Minecraft mc = ModLoader.getMinecraftInstance();
	private StructureGenerator generator = new StructureGenerator();
	public int sizeIndex = 0;
	public int currentBlockIndex;
	public int currentFenceIndex;
	public ItemStack currentFence = createStack((ItemKey) Fence.getFence().get(currentFenceIndex));
	public ItemStack currentBlock = createStack((ItemKey) Fence.getDirts().get(currentBlockIndex));
	public int[] availableSizes = {
		16, 32	
	};
	
	
	public void blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		if(entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID))
		{
			switch(world.getBlockMetadata(i, j, k)){
				case 2:
					world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 4);
					break;
				case 3:
					world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 5);
					break;
				case 4:
					world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 3);
					break;
				case 5:
					world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 2);
					break;
			}
		}else{
			entityplayer.openGui(mod_ZooCore.instance, GUIIDEnum.EXHIBIT_TOOL.ID, world, i, j, k);
		}
	}
	
	public void readFromNBT(NBTTagCompound nbt)
    {
		super.readFromNBT(nbt);
		currentFenceIndex = nbt.getInteger("CFI");
		currentBlockIndex = nbt.getInteger("CBI");
		sizeIndex = nbt.getInteger("Size");
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
    	super.writeToNBT(nbt);
    	nbt.setInteger("CFI", currentFenceIndex);
    	nbt.setInteger("CBI", currentBlockIndex);
    	nbt.setInteger("Size", sizeIndex);
    }
    
    public ItemStack createStack(ItemKey key)
    {
    	ItemStack stack;
    	if(key.itemID < Item.shovelSteel.shiftedIndex)
    	{
    		stack = new ItemStack(Block.blocksList[key.itemID], 1, key.itemDamage);
    	}else{
    		stack = new ItemStack(Item.itemsList[key.itemID], 1, key.itemDamage);
    	}
    	return stack;
    }
    
    public synchronized void incrementFenceIndex()
    {
    	if(currentFenceIndex != Fence.getFence().size() - 1)
    	{
    		currentFenceIndex++;
    		currentFence = createStack((ItemKey) Fence.getFence().get(currentFenceIndex));
    	}
    }
    
    public synchronized void decrementFenceIndex()
    {
    	if(currentFenceIndex > 0)
    	{
    		currentFenceIndex--;
    		currentFence = createStack((ItemKey) Fence.getFence().get(currentFenceIndex));
    	}
    }
    
    public synchronized void incrementBlockIndex()
    {
    	if(currentBlockIndex != Fence.getDirts().size() - 1)
    	{
    		currentBlockIndex++;
    		currentBlock = createStack((ItemKey) Fence.getDirts().get(currentBlockIndex));
    	}
    }
    
    public synchronized void decrementBlockIndex()
    {
    	if(currentBlockIndex > 0)
    	{
    		currentBlockIndex--;
    		currentBlock = createStack((ItemKey) Fence.getDirts().get(currentBlockIndex));
    	}
    }
    
    public void generate()
    {
    	int size = availableSizes[sizeIndex];
    	int price = size * size * Trade.getPrice(currentBlock) + 4 * size * 2 * Trade.getPrice(currentFence) + size * 4 * Trade.getPrice(new ItemStack(Block.torchWood));
    	int md = worldObj.getBlockMetadata(getX(), getY(), getZ());
    	
    	if(!Trade.decreaseMoney(price))
    	{
    		return;
    	}
    	
    	if(!Fence.getGlass().contains(new ItemKey(currentFence.itemID, currentFence.getItemDamage())))
    	{
	    	if(md == 3)
	        {
	        	generate(worldObj, getX(), getY(), getZ(), size);
	        }
	        if(md == 5)
	        {
	        	generateFrontLeft(worldObj, getX(), getY(), getZ(), size);
	        }
	        if(md == 4)
	        {
	        	generateBackRight(worldObj, getX(), getY(), getZ(), size);
	        }
	        if(md == 2)
	        {
	        	generateBackLeft(worldObj, getX(), getY(), getZ(), size);
	        }
    	}else{
    		if(md == 3)
            {
            	generateOnGlass(worldObj, getX(), getY(), getZ(), size);
            }
            if(md == 5)
            {
            	generateOnGlassFL(worldObj, getX(), getY(), getZ(), size);
            }
            if(md == 4)
            {
            	generateOnGlassBR(worldObj, getX(), getY(), getZ(), size);
            }
            if(md == 2)
            {
            	generateOnGlassBL(worldObj, getX(), getY(), getZ(), size);
            }
    	}
        
        
    	
    	
    }
    
    public void generate(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 2, z + size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x + size, z + size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x + (size / 2), z + (size / 2), x + (size / 2) + 1, z + (size / 2) + 1, Block.planks.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x + 8, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x + 8, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x + 16, y + 3, z + 16, Zoo.brownStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z + size, x, y + 1, z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z + size, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        //generate torches on top of the fence
        generator.generateHollowFloor(world, y + 2, x, z, x + size, z + size, Block.torchWood.blockID, 5);
        
        if(size == 16)
        {
	        //generate torches facing south/north
	        generator.generateWall(world, x + 7, y + 2, z + (size / 2), x + 7, y + 2 , z + (size / 2) + 1, Block.torchWood.blockID, 2);
	        generator.generateWall(world, x + 10, y + 2, z + (size / 2), x + 10, y + 2 , z + (size / 2) + 1, Block.torchWood.blockID, 1);
	        
	        //generate torches facing east/west
	        generator.generateWall(world, x + (size / 2), y + 2, z + 7, x + (size / 2) + 1, y + 2 , z + 7, Block.torchWood.blockID, 3);
	        generator.generateWall(world, x + (size / 2), y + 2, z + 10, x + (size / 2) + 1, y + 2 , z + 10, Block.torchWood.blockID, 4);
        }
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	public void generateBackRight(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x - size, y + 2, z + size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x - size, z + size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x - (size / 2), z + (size / 2), x - (size / 2) - 1, z + (size / 2) + 1, Block.planks.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x - 8, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x - 8, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x - 16, y + 3, z + 16, Zoo.brownStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z + size, x, y + 1, z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z + size, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        //generate torches on top of the fence
        generator.generateHollowFloor(world, y + 2, x, z, x - size, z + size, Block.torchWood.blockID, 5);
        
        if(size == 16)
        {
	        //generate torches facing south/north
	        generator.generateWall(world, x - 7, y + 2, z + (size / 2), x - 7, y + 2 , z + (size / 2) + 1, Block.torchWood.blockID, 2);
	        generator.generateWall(world, x - 10, y + 2, z + (size / 2), x - 10, y + 2 , z + (size / 2) + 1, Block.torchWood.blockID, 1);
	        
	        //generate torches facing east/west
	        generator.generateWall(world, x - (size / 2), y + 2, z + 7, x - (size / 2) - 1, y + 2 , z + 7, Block.torchWood.blockID, 3);
	        generator.generateWall(world, x - (size / 2), y + 2, z + 10, x - (size / 2) - 1, y + 2 , z + 10, Block.torchWood.blockID, 4);
        }
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	public void generateFrontLeft(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 2, z - size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x + size, z - size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x + (size / 2), z - (size / 2), x + (size / 2) + 1, z - (size / 2) - 1, Block.planks.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x + 8, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x + 8, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x + 16, y + 3, z - 16, Zoo.brownStone.blockID);
        }

        generator.generateFloor(world, y - 1,x + size , z, x + size + 1, z - size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size == 16)
        {
        	world.setBlockWithNotify(x + (size / 2) + 1, y + 2, z - (size / 2), Block.planks.blockID);
        	world.setBlockWithNotify(x + (size / 2) + 1, y + 2, z - (size / 2) - 1, Block.planks.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z - size, x, y + 1, z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z - size, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        //generate torches on top of the fence
        generator.generateHollowFloor(world, y + 2, x, z, x + size, z - size, Block.torchWood.blockID, 5);
        if(size == 16)
        {
	        //generate torches facing west/east
	        generator.generateWall(world, x + 7, y + 2, z - (size / 2), x + 7, y + 2 , z - (size / 2) - 1, Block.torchWood.blockID, 2);
	        generator.generateWall(world, x + 10, y + 2, z - (size / 2), x + 10, y + 2 , z - (size / 2) - 1, Block.torchWood.blockID, 1);
	        
	        //generate torches facing south/north
	        generator.generateWall(world, x + (size / 2), y + 2, z - 7, x + (size / 2) + 1, y + 2 , z - 7, Block.torchWood.blockID, 3);
	        generator.generateWall(world, x + (size / 2), y + 2, z - 10, x + (size / 2) + 1, y + 2 , z - 10, Block.torchWood.blockID, 4);
        }
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
    }
	public void generateBackLeft(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x - size, y + 2, z - size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x - size, z - size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x - (size / 2), z - (size / 2), x - (size / 2) - 1, z - (size / 2) - 1, Block.planks.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x - 8, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x - 8, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x - 16, y + 3, z - 16, Zoo.brownStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z - size, x, y + 1, z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z - size, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        //generate torches on top of the fence
        generator.generateHollowFloor(world, y + 2, x, z, x - size, z - size, Block.torchWood.blockID, 5);
        
        if(size == 16)
        {
	        //generate torches facing south/north
	        generator.generateWall(world, x - 7, y + 2, z - (size / 2), x - 7, y + 2 , z - (size / 2) - 1, Block.torchWood.blockID, 2);
	        generator.generateWall(world, x - 10, y + 2, z - (size / 2), x - 10, y + 2 , z - (size / 2) - 1, Block.torchWood.blockID, 1);
	        
	        //generate torches facing east/west
	        generator.generateWall(world, x - (size / 2), y + 2, z - 7, x - (size / 2) - 1, y + 2 , z - 7, Block.torchWood.blockID, 3);
	        generator.generateWall(world, x - (size / 2), y + 2, z - 10, x - (size / 2) - 1, y + 2 , z - 10, Block.torchWood.blockID, 4);
        }
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
    }
	public void generateOnGlass(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 2, z + size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x + size, z + size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x + (size / 2), z + (size / 2), x + (size / 2) + 1, z + (size / 2) + 1, Block.glowStone.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x + 8, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x + 8, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x + 16, y + 3, z + 16, Zoo.brownStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z + size, x, y + 1, z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z + size, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	public void generateOnGlassFL(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 2, z - size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x + size + 1, z - size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x + (size / 2), z - (size / 2), x + (size / 2) + 1, z - (size / 2) - 1, Block.glowStone.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x + 8, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x + 8, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x + 24, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x + 16, y + 3, z - 16, Zoo.brownStone.blockID);
        }
        if(size == 16)
        {
	        world.setBlockWithNotify(x + (size / 2) + 1, y + 2, z - (size / 2), Block.glowStone.blockID);
	        world.setBlockWithNotify(x + (size / 2) + 1, y + 2, z - (size / 2) - 1, Block.glowStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z - size, x, y + 1, z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x + size, y, z - size, x + size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	public void generateOnGlassBL(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x - size, y + 2, z - size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x - size, z - size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x - (size / 2), z - (size / 2), x - (size / 2) -1, z - (size / 2) - 1, Block.glowStone.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x - 8, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z - 8, Zoo.brownStone.blockID);
        	genCross(world, x - 8, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z - 24, Zoo.brownStone.blockID);
        	genCross(world, x - 16, y + 3, z - 16, Zoo.brownStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z - size, x, y + 1, z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z - size, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	public void generateOnGlassBR(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x - size, y + 2, z + size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x - size, z + size, currentBlock.itemID, currentBlock.getItemDamage());
        if(size==16)
        {
        	generator.generateFloor(world, y + 2, x - (size / 2), z + (size / 2), x - (size / 2) - 1, z + (size / 2) + 1, Block.glowStone.blockID);
        }
        if(size == 32)
        {
        	genCross(world, x - 8, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z + 8, Zoo.brownStone.blockID);
        	genCross(world, x - 8, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x - 24, y + 3, z + 24, Zoo.brownStone.blockID);
        	genCross(world, x - 16, y + 3, z + 16, Zoo.brownStone.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z + size, x, y + 1, z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, currentFence.itemID, currentFence.getItemDamage());
        generator.generateWall(world, x - size, y, z + size, x - size, y + 1 , z, currentFence.itemID, currentFence.getItemDamage());
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	
	
	public void genCross(World world, int x, int y, int z, int block)
	{
		world.setBlockWithNotify(x, y, z, block);
		world.setBlockWithNotify(x + 1, y, z, block);
		world.setBlockWithNotify(x - 1, y, z, block);
		world.setBlockWithNotify(x, y, z + 1, block);
		world.setBlockWithNotify(x, y, z - 1, block);
		
		world.setBlockWithNotify(x + 1, y, z + 1, Block.torchWood.blockID);
		world.setBlockWithNotify(x + 1, y, z - 1, Block.torchWood.blockID);
		world.setBlockWithNotify(x - 1, y, z + 1, Block.torchWood.blockID);
		world.setBlockWithNotify(x - 1, y, z - 1, Block.torchWood.blockID);
	}
    
}
