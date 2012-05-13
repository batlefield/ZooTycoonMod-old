package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.BAPI.ItemKey;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

public class BlockFencer extends Block implements ITextureProvider{

	private StructureGenerator generator = new StructureGenerator();
	
	public BlockFencer(int i) {
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
		if((j == 0 || j == 4) && (i == 3 || i == 5))
		{
			return 41;
		}
		else if((j == 1 || j == 5) && (i == 2 || i == 5))
		{
			return 41;
		}
		else if((j == 2 || j == 6) && (i == 2 || i == 4))
		{
			return 41;
		}
		else if((j == 3 || j == 7) && (i == 3 || i == 4))
		{
			return 41;
		}
		return 42;
	}
	
	private static Minecraft mc = ModLoader.getMinecraftInstance();
	public static int blockid;
	public static int blockmd;
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		
		int md = world.getBlockMetadata(i, j, k);
		
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getFence().contains(new ItemKey(entityplayer.getCurrentEquippedItem().itemID, entityplayer.getCurrentEquippedItem().getItemDamage())))
        {
            blockid = entityplayer.getCurrentEquippedItem().itemID;
            blockmd = entityplayer.getCurrentEquippedItem().getItemDamage();
            if(md == 0)
            {
            	generate(world, i, j, k, 16);
            }
            if(md == 1)
            {
            	generateFrontLeft(world, i, j, k, 16);
            }
            if(md == 3)
            {
            	generateBackRight(world, i, j, k, 16);
            }
            if(md == 2)
            {
            	generateBackLeft(world, i, j, k, 16);
            }
            if(md == 4)
            {
            	generate(world, i, j, k, 32);
            }
            if(md == 5)
            {
            	generateFrontLeft(world, i, j, k, 32);
            }
            if(md == 7)
            {
            	generateBackRight(world, i, j, k, 32);
            }
            if(md == 6)
            {
            	generateBackLeft(world, i, j, k, 32);
            }
        }
		
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getGlass().contains(new ItemKey(entityplayer.getCurrentEquippedItem().itemID, entityplayer.getCurrentEquippedItem().getItemDamage())))
        {
            blockid = entityplayer.getCurrentEquippedItem().itemID;
            blockmd = entityplayer.getCurrentEquippedItem().getItemDamage();
            if(md == 0)
            {
            	generateOnGlass(world, i, j, k, 16);
            }
            if(md == 1)
            {
            	generateOnGlassFL(world, i, j, k, 16);
            }
            if(md == 3)
            {
            	generateOnGlassBR(world, i, j, k, 16);
            }
            if(md == 2)
            {
            	generateOnGlassBL(world, i, j, k, 16);
            }
            if(md == 4)
            {
            	generateOnGlass(world, i, j, k, 32);
            }
            if(md == 5)
            {
            	generateOnGlassFL(world, i, j, k, 32);
            }
            if(md == 7)
            {
            	generateOnGlassBR(world, i, j, k, 32);
            }
            if(md == 6)
            {
            	generateOnGlassBL(world, i, j, k, 32);
            }
        }
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 0)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 1);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 1)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 2);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 2)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 3);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 3)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 0);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		
		
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 4)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 5);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 5)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 6);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 6)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 7);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID) && md == 7)
		{
			world.setBlockAndMetadataWithNotify(i, j, k, Zoo.fencer.blockID, 4);
			entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
		}
		else
        {
        	super.blockActivated(world, i, j, k, entityplayer);
        }
		return true;
	}
	
	public void generate(World world, int x, int y, int z, int size)
	{
		world.editingBlocks = true;
		//clear area
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 2, z + size, 0);
		//generate floor
        generator.generateFloor(world, y - 1, x, z, x + size, z + size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x + size, y, z + size, x, y + 1, z + size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, blockid, blockmd);
        generator.generateWall(world, x + size, y, z + size, x + size, y + 1 , z, blockid, blockmd);
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
        generator.generateFloor(world, y - 1, x, z, x - size, z + size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x - size, y, z + size, x, y + 1, z + size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, blockid, blockmd);
        generator.generateWall(world, x - size, y, z + size, x - size, y + 1 , z, blockid, blockmd);
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
        generator.generateFloor(world, y - 1, x, z, x + size, z - size, Block.grass.blockID);
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

        generator.generateFloor(world, y - 1,x + size , z, x + size + 1, z - size, Block.grass.blockID);
        if(size == 16)
        {
        	world.setBlockWithNotify(x + (size / 2) + 1, y + 2, z - (size / 2), Block.planks.blockID);
        	world.setBlockWithNotify(x + (size / 2) + 1, y + 2, z - (size / 2) - 1, Block.planks.blockID);
        }
        //generate fence
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x + size, y, z - size, x, y + 1, z - size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, blockid, blockmd);
        generator.generateWall(world, x + size, y, z - size, x + size, y + 1 , z, blockid, blockmd);
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
        generator.generateFloor(world, y - 1, x, z, x - size, z - size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x - size, y, z - size, x, y + 1, z - size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, blockid, blockmd);
        generator.generateWall(world, x - size, y, z - size, x - size, y + 1 , z, blockid, blockmd);
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
        generator.generateFloor(world, y - 1, x, z, x + size, z + size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x + size, y, z + size, x, y + 1, z + size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, blockid, blockmd);
        generator.generateWall(world, x + size, y, z + size, x + size, y + 1 , z, blockid, blockmd);
        
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
        generator.generateFloor(world, y - 1, x, z, x + size + 1, z - size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x + size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x + size, y, z - size, x, y + 1, z - size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, blockid, blockmd);
        generator.generateWall(world, x + size, y, z - size, x + size, y + 1 , z, blockid, blockmd);
        
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
        generator.generateFloor(world, y - 1, x, z, x - size, z - size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x - size, y, z - size, x, y + 1, z - size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z - size, blockid, blockmd);
        generator.generateWall(world, x - size, y, z - size, x - size, y + 1 , z, blockid, blockmd);
        
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
        generator.generateFloor(world, y - 1, x, z, x - size, z + size, Block.grass.blockID);
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
        generator.generateWall(world, x, y, z, x - size, y + 1 , z, blockid, blockmd);
        generator.generateWall(world, x - size, y, z + size, x, y + 1, z + size, blockid, blockmd);
        generator.generateWall(world, x, y, z, x, y + 1 , z + size, blockid, blockmd);
        generator.generateWall(world, x - size, y, z + size, x - size, y + 1 , z, blockid, blockmd);
        
        if(!mc.thePlayer.capabilities.isCreativeMode)
        {
    		mc.thePlayer.getCurrentEquippedItem().stackSize--;
        }
        world.editingBlocks = false;
	}
	
	public int damageDropped(int i)
	{
		if(i >= 4 && i <= 7)
		{
			return 4;
		}else{
			return 0;
		}
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
