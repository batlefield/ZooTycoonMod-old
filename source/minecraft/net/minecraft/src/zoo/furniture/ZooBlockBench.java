package net.minecraft.src.zoo.furniture;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooFurniture;

public class ZooBlockBench extends ZooBlockSeat
{
	public ZooBlockBench(int i, int j, Class class1, Material mat)
    {
        super(i, j, class1, mat);
    }      

	public float getSeatHeight()
	{
		return 0.4375F;
	}
	
    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
    	int m = world.getBlockMetadata(i,j,k) / 4;
    	
        float[][] array1 = {
                {0.125F, 0.0F, 0.125F, 0.75F, 0.5F, 1.0F},
                {0.75F, 0.0F, 0.125F, 0.875F, 1.0625F, 1.0F}};
    	
        float[][] array2 = {
                {0.125F, 0.0F, 0.0F, 0.75F, 0.5F, 0.875F},
                {0.75F, 0.0F, 0.0F, 0.875F, 1.0625F, 0.875F}};
        
        if(m == 0) setRotatedCollision(array1, world, i, j, k, axisalignedbb, arraylist);
        if(m == 1) setRotatedCollision(array2, world, i, j, k, axisalignedbb, arraylist);
        
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
	
    public int idDropped(int i, Random random, int j)
    {
        return mod_ZooFurniture.itemBench.shiftedIndex;
    }

    protected void setup()
    { 
    	isSingleBlock = false;
	    int[][] array =
	    {
	    	{ 0, 0, 1},
	    	{ 0, 0,-1},
	    	{-1, 0, 0},
	    	{ 1, 0, 0},
	    	
	    	{ 0, 0,-1},
	    	{ 0, 0, 1},
	    	{ 1, 0, 0},
	    	{-1, 0, 0}
	    };
	    parts = array;
    }
}