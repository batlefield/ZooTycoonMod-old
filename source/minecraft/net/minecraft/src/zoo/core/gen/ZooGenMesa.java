package net.minecraft.src.zoo.core.gen;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDirts;

public class ZooGenMesa extends WorldGenerator
{

	public boolean generate(World world, Random random, int i, int j, int k)
	{
		int l = random.nextInt(6) + 4;
		boolean flag = true;
		if (j < 1 || j + l + 4 > 256)
		{
			return false;
		}

		if (!flag)
		{
			return false;
		}
		int j1 = world.getBlockId(i, j - 1, k);
		if (j1 != ZooDirts.mesa.blockID || j >= 82)
		{
			return false;
		}

		for(int i1 = j + 20; i1 >= 4; i1--)
        {
            for(int j2 = -20; j2 <= 20; j2++)
            {
                for(int k1 = -20; k1 <= 20; k1++)
                {
                    float f = j2;
                    float f1 = k1;
                    float f2 = (float)Math.sqrt(f * f + f1 * f1);
                    if(f2 > 20F && (f2 > 20F || i1 != j || j2 == 0 && k1 == 0))
                    {
                        continue;
                    }
                    if(world.getBlockId(i + j2, i1, k + k1) == 0 || world.getBlockId(i + j2, i1, k + k1) == Zoo.saltwaterStill.blockID)
                    {
                		setBlock(world, i + j2, i1, k + k1, ZooDirts.mesa.blockID);
                    }
                }

            }
        }

		return true;
	}

}
