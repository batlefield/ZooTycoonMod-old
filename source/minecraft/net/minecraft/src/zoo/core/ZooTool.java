package net.minecraft.src.zoo.core;

import net.minecraft.src.*;

import java.util.Arrays;
import net.minecraft.src.forge.ForgeHooks;

// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, ItemStack, Block, 
//            EntityLiving, Entity

public class ZooTool extends ZooItem
{

    protected ZooTool(int i, int j, ZooEnumTool zooenumtool, Block ablock[])
    {
        super(i);
        efficiencyOnProperMaterial = 4F;
        toolMaterial = zooenumtool;
        blocksEffectiveAgainst = ablock;
        maxStackSize = 1;
        setMaxDamage(zooenumtool.getMaxUses());
        efficiencyOnProperMaterial = zooenumtool.getEfficiencyOnProperMaterial();
        damageVsEntity = j + zooenumtool.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    /* FORGE: Overridden to allow custom tool effectiveness
     */
    public float getStrVsBlock(ItemStack itemstack, Block block, int md) {
	    if(ForgeHooks.isToolEffective(itemstack,block,md))
                return efficiencyOnProperMaterial;
	    return getStrVsBlock(itemstack,block);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private Block blocksEffectiveAgainst[];
    public float efficiencyOnProperMaterial;
    public int damageVsEntity;
    protected ZooEnumTool toolMaterial;
}
