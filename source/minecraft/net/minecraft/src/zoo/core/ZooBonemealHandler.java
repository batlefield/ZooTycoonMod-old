package net.minecraft.src.zoo.core;

import net.minecraft.src.forge.*;
import net.minecraft.src.*;

public class ZooBonemealHandler implements IBonemealHandler
{
        
        public boolean onUseBonemeal(World world, int bid, int i, int j, int k)
        {
            if(!world.isRemote)
            {
                ((ZooSapling)Zoo.sapling).growTree(world, i, j, k, world.rand);
            }
            return true;
        }

}