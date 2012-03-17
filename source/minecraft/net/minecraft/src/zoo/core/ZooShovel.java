package net.minecraft.src.zoo.core;

import net.minecraft.src.*;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ZooShovel extends ZooTool
{

    public ZooShovel(int i, ZooEnumTool enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block)
    {
        if(block == Block.snow)
        {
            return true;
        }
        return block == Block.blockSnow;
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField
        });
    }
}
