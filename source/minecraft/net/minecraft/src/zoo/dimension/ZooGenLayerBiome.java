package net.minecraft.src.zoo.dimension;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;
import net.minecraft.src.zoo.api.Biome;

public class ZooGenLayerBiome extends GenLayer
{
    private BiomeGenBase allowedBiomes[];

    public ZooGenLayerBiome(long l, GenLayer genlayer)
    {
        super(l);
        allowedBiomes = (BiomeGenBase[]) Biome.getBiomes(1).toArray(new BiomeGenBase[Biome.getBiomes(1).size()]);
        parent = genlayer;
    }

    public int[] getInts(int i, int j, int k, int l)
    {
        int ai[] = parent.getInts(i, j, k, l);
        int ai1[] = IntCache.getIntCache(k * l);
        for (int i1 = 0; i1 < l; i1++)
        {
            for (int j1 = 0; j1 < k; j1++)
            {
            	initChunkSeed(j1 + i, i1 + j);
                ai1[(j1 + i1 * k)] = (ai[(j1 + i1 * k)] <= 0 ? 0 : allowedBiomes[nextInt(allowedBiomes.length)].biomeID);
            }
        }

        return ai1;
    }
}
