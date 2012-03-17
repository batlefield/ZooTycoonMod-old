package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.forge.ITextureProvider;

public class ZooAcorns extends BlockFlower implements ITextureProvider {

	public ZooAcorns(int i, int j) {
		super(i, j);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 23;
    }
    
    public boolean canThisPlantGrowOnThisBlockID(int i, int j)
    { 
		return i == ZooDirts.deciduous.blockID;
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
	public void addCreativeItems(ArrayList itemList)
    {
		itemList.add(new ItemStack(this));
    }

}
