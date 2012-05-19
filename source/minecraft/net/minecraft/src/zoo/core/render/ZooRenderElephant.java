package net.minecraft.src.zoo.core.render;
import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;
import net.minecraft.src.zoo.core.entities.ZooEntityAnimal;
import net.minecraft.src.zoo.core.entities.ZooEntityElephant;
import net.minecraft.src.zoo.core.models.ZooModelElephant;

public class ZooRenderElephant extends RenderLiving
{

    public ZooRenderElephant(float f)
    {
        super(new ZooModelElephant(), f);
    }

    public void renderGazelle(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRender(entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        doRenderGazelle((ZooEntityElephant)entity, d, d1, d2, f, f1);
    }
    
    public void doRenderGazelle(ZooEntityAnimal gazelle, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRender(gazelle, d, d1, d2, f, f1);
        if(gazelle.roped != null)
        {
        	d1 = -0.94D / (double)0.5F;
            Tessellator tessellator = Tessellator.instance;
            float f4 = ((gazelle.roped.prevRotationYaw + (gazelle.roped.rotationYaw - gazelle.roped.prevRotationYaw) * f1 * 0.5F) * 3.141593F) / 180F;
            float f6 = ((gazelle.roped.prevRotationPitch + (gazelle.roped.rotationPitch - gazelle.roped.prevRotationPitch) * f1 * 0.5F) * 3.141593F) / 180F;
            double d3 = MathHelper.sin(f4);
            double d4 = MathHelper.cos(f4);
            double d5 = MathHelper.sin(f6);
            double d6 = MathHelper.cos(f6);
            double d7 = (gazelle.roped.prevPosX + (gazelle.roped.posX - gazelle.roped.prevPosX) * (double)f1) - d4 * 0.69999999999999996D - d3 * 0.5D * d6;
            double d8 = (gazelle.roped.prevPosY + (gazelle.roped.posY - gazelle.roped.prevPosY) * (double)f1) - d5 * 0.5D;
            double d9 = ((gazelle.roped.prevPosZ + (gazelle.roped.posZ - gazelle.roped.prevPosZ) * (double)f1) - d3 * 0.69999999999999996D) + d4 * 0.5D * d6;
            double d10 = gazelle.prevPosX + (gazelle.posX - gazelle.prevPosX) * (double)f1;
            double d11 = gazelle.prevPosY + (gazelle.posY - gazelle.prevPosY) * (double)f1 + 0.25D;
            double d12 = gazelle.prevPosZ + (gazelle.posZ - gazelle.prevPosZ) * (double)f1;
            double d13 = (float)(d7 - d10);
            double d14 = (float)(d8 - d11);
            double d15 = (float)(d9 - d12);
            GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            for(double d16 = 0.0D; d16 < 0.029999999999999999D; d16 += 0.01D)
            {
                tessellator.startDrawing(3);
                tessellator.setColorRGBA_F(0.5F, 0.4F, 0.3F, 1.0F);
                int j = 16;
                for(int k = 0; k <= j; k++)
                {
                    float f12 = (float)k / (float)j;
                    tessellator.addVertex(d + d13 * (double)f12 + d16, d1 + d14 * (double)(f12 * f12 + f12) * 0.5D + (double)(((float)j - (float)k) / ((float)j * 0.75F) + 0.125F), d2 + d15 * (double)f12);
                }

                tessellator.draw();
            }

            GL11.glEnable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        }
    }
}
