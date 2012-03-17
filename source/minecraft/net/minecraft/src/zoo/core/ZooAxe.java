package net.minecraft.src.zoo.core;
import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ZooAxe extends ZooTool
{

    public ZooAxe(int i, ZooEnumTool enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.planks, Block.bookShelf, Block.wood, Block.chest
        });
    }
}
