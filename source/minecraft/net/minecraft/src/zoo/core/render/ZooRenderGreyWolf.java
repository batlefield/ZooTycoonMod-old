package net.minecraft.src.zoo.core.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.ModelWolf;
import net.minecraft.src.zoo.core.entities.ZooEntityGreyWolf;

public class ZooRenderGreyWolf extends RenderLiving
{
    public ZooRenderGreyWolf(float f)
    {
        super(new ModelWolf(), f);
    }

    public void renderWolf(ZooEntityGreyWolf entitywolf, double d, double d1, double d2,
            float f, float f1)
    {
        super.doRenderLiving(entitywolf, d, d1, d2, f, f1);
    }

    protected float func_25004_a(ZooEntityGreyWolf  entitywolf, float f)
    {
        return entitywolf.setTailRotation();
    }

    protected void func_25006_b(ZooEntityGreyWolf  entitywolf, float f)
    {
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        func_25006_b((ZooEntityGreyWolf )entityliving, f);
    }

    protected float handleRotationFloat(EntityLiving entityliving, float f)
    {
        return func_25004_a((ZooEntityGreyWolf )entityliving, f);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2,
            float f, float f1)
    {
        renderWolf((ZooEntityGreyWolf )entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2,
            float f, float f1)
    {
        renderWolf((ZooEntityGreyWolf )entity, d, d1, d2, f, f1);
    }
}
