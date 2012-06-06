    package net.minecraft.src.zoo.core;
    import net.minecraft.src.*;

import net.minecraft.src.forge.*;
    
    public class ZooItemFenceDestroyer extends ZooTool
    {

        public ZooItemFenceDestroyer(int i, ZooEnumTool zooenumtool)
        {
         super(i, 2, zooenumtool, blocksEffectiveAgainst);
         maxStackSize = 1;
         setMaxDamage(zooenumtool.getMaxUses());
        }

        public boolean canHarvestBlock(Block block)
        {
        	if(block == Zoo.fence)
            {
                return toolMaterial.getHarvestLevel() == 7;
            }
        	return block.blockMaterial == Material.iron;
        }

        private static Block blocksEffectiveAgainst[];

        static
        {
            blocksEffectiveAgainst = (new Block[] {
                Zoo.fence, Zoo.Gfence, Zoo.Bfence, Zoo.Ofence, Zoo.plexiglass, Zoo.plexiglassBlock, Block.fence, Block.netherFence
            });
        }
    } 