package net.minecraft.src.zoo.core.render;
import net.minecraft.src.*;
import net.minecraft.src.zoo.core.modells.ZooModelTiger;

public class ZooRenderTiger extends RenderLiving
{

    public ZooRenderTiger(float f)
    {
        super(new ZooModelTiger(), f);
    }

    public void renderGazelle(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entityliving, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderGazelle(entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderGazelle((EntityLiving)entity, d, d1, d2, f, f1);
    }
}
