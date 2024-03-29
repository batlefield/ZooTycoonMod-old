package net.minecraft.src.zoo.core;

import net.minecraft.src.*;

public class ZooHoe extends ZooItem
{

    public ZooHoe(int i, ZooEnumTool bs)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(bs.getMaxUses());
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(entityplayer!=null && !entityplayer.canPlayerEdit(i, j, k))
        {
            return false;
        }
        int i1 = world.getBlockId(i, j, k);
        int j1 = world.getBlockId(i, j + 1, k);
        if(l != 0 && j1 == 0 && i1 == Block.grass.blockID || i1 == Block.dirt.blockID)
        {
            Block block = Block.tilledField;
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            if(world.isRemote)
            {
                return true;
            } else
            {
                world.setBlockWithNotify(i, j, k, block.blockID);
                itemstack.damageItem(1, entityplayer);
                return true;
            }
        } else
        {
            return false;
        }
    }

    public boolean isFull3D()
    {
        return true;
    }
}
