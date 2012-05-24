package net.minecraft.src.zoo.core.render;

import net.minecraft.src.*;
import net.minecraft.src.zoo.core.modells.visitors.FemaleBase;

public class RenderFemale extends RenderLiving{
	
	
    public RenderFemale(net.minecraft.src.zoo.core.models.FemaleBase femaleBase, float f)
    {
        super(femaleBase, f);
    }

    public void renderNew(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entityliving, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderNew(entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderNew((EntityLiving)entity, d, d1, d2, f, f1);
    }

}
