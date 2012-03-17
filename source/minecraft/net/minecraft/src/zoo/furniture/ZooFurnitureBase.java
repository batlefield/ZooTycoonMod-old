package net.minecraft.src.zoo.furniture;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public abstract class ZooFurnitureBase extends BlockContainer
{
    public ZooFurnitureBase(int i, int j, Class class1, Material mat)
    {
        super(i, j, mat);
        setup();
        anEntityClass = class1;
    }      
    
    public int quantityDropped(Random random)
    {
        return 1;
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
        return -1;
    }
    
    public TileEntity getBlockEntity()
    {
        try
        {
            return (TileEntity)anEntityClass.newInstance();
        }
        catch(Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }
    
    public void playBlock(World world, int i, int j, int k, int l, int i1) {}
    
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
    	if(isSingleBlock) return;
    	
    	int m = world.getBlockMetadata(i, j, k);
    	if(world.getBlockId(i + parts[m][0], j + parts[m][1], k + parts[m][2]) != this.blockID)
    	{
    		world.setBlockWithNotify(i,j,k,0);
    	}
    }
    public void onItemUse(World world, int x, int y, int z, int m, EntityPlayer player)
    {
    	if(isSingleBlock)
    	{
    		world.setBlockAndMetadataWithNotify(x,y,z,this.blockID,m);
    		return;
    	}
    	
    	int x2 = x;
    	int y2 = y;
    	int z2 = z;
    	
    	for(int i=m; i<parts.length; i+=4)
    	{
        	world.setBlockAndMetadataWithNotify(x2,y2,z2,this.blockID,i);
    		x2 += parts[i][0];
    		y2 += parts[i][1];
    		z2 += parts[i][2];
    	}
    }
    public boolean canPlaceBlockWithMetaAt(World world, int x, int y, int z, int m)
    {
    	if(isSingleBlock)
    	{
    		if(canPlaceBlockAt(world,x,y,z)) return true;
    		else return false;
    	}
    	
    	int x2 = x;
    	int y2 = y;
    	int z2 = z;
    	for(int i=m; i<parts.length; i+=4)
    	{
    		if(parts[i][1]==0 || i<4)
    		{
    			if(!canPlaceBlockAt(world,x2,y2,z2)) return false;
    		}
    		x2 +=  parts[i][0];
    		y2 +=  parts[i][1];
    		z2 +=  parts[i][2];
    	}
    	return true;
    }
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j, k);
        if(l==Block.leaves.blockID) return false;
        if(l!=0 && !(Block.blocksList[l].blockMaterial.isGroundCover())) return false;
        
        return world.isBlockNormalCube(i,j-1,k);
    }
    
    public void setRotatedCollision(float[][] coords, World world, int i, int j, int k,
    		AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
    	setRotatedCollision(coords,1F,world,i,j,k,axisalignedbb,arraylist);
    }
    public void setRotatedCollision(float[][] coords, float max, World world, int i, int j, int k,
    		AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
    	int m = world.getBlockMetadata(i, j, k) % 4;
    	
    	for(int index=0; index<coords.length; index++)
    	{
	    	if(m == 0)
	    	{
	            setBlockBounds(0F+coords[index][0],
		        			   0F+coords[index][1],
		        			   0F+coords[index][2],
		        			   0F+coords[index][3],
		        			   0F+coords[index][4],
		        			   0F+coords[index][5]);
	    	}
	    	else if(m == 1)
	    	{
	            setBlockBounds(max-coords[index][3],
		         			   0F+coords[index][1],
		         			   max-coords[index][5],
		         			   max-coords[index][0],
		         			   0F+coords[index][4],
		         			   max-coords[index][2]);
	    	}
	    	else if(m == 2)
	    	{
	            setBlockBounds(0F+coords[index][2],
		         			   0F+coords[index][1],
		         			   0F+coords[index][0],
		         			   0F+coords[index][5],
		         			   0F+coords[index][4],
		         			   0F+coords[index][3]);
	    	}
	    	else if(m == 3)
	    	{
	            setBlockBounds(max-coords[index][5],
		         			   0F+coords[index][1],
		         			   max-coords[index][3],
		         			   max-coords[index][2],
		         			   0F+coords[index][4],
		         			   max-coords[index][0]);
	    	}
	    	
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    	}
    }
    
    protected void setup()
    {
    	isSingleBlock = true;
    }
    
    public int[][] parts;
    public Class anEntityClass;
    public boolean isSingleBlock;
}