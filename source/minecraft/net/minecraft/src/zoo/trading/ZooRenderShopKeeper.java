package net.minecraft.src.zoo.trading;
import net.minecraft.src.*;

public class ZooRenderShopKeeper extends RenderLiving
{

    public ZooRenderShopKeeper(float f)
    {
        super(new ModelBiped(), f);
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
