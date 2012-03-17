package net.minecraft.src.zoo.dimension;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;
import net.minecraft.src.ZooBiomeBase;

public class ZooGenLayerOcean extends GenLayer
{
    private GenLayer field_35512_b;
    private GenLayer field_35513_c;

    public ZooGenLayerOcean(long l, GenLayer genlayer, GenLayer genlayer1)
    {
        super(l);
        field_35512_b = genlayer;
        field_35513_c = genlayer1;
    }

    public void initWorldGenSeed(long l)
    {
        field_35512_b.initWorldGenSeed(l);
        field_35513_c.initWorldGenSeed(l);
        super.initWorldGenSeed(l);
    }

    public int[] getInts(int i, int j, int k, int l)
    {
        int ai[] = field_35512_b.getInts(i, j, k, l);
        int ai1[] = field_35513_c.getInts(i, j, k, l);
        int ai2[] = IntCache.getIntCache(k * l);
        for (int i1 = 0; i1 < k * l; i1++)
        {
            if (ai[i1] == ZooBiomeBase.ocean.biomeID)
            {
                ai2[i1] = ai[i1];
                
            }else{
            	ai2[i1] = (ai1[i1] < 0 ? ai[i1] : ai1[i1]);
            }
        }

        return ai2;
    }
}
