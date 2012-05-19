package net.minecraft.src.zoo.core.render;
import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;
import net.minecraft.src.zoo.core.entities.ZooEntityAfricanWDog;
import net.minecraft.src.zoo.core.entities.ZooEntityAnimal;
import net.minecraft.src.zoo.core.models.ZooModelAfricanWDog;
import net.minecraft.src.zoo.core.models.ZooModelFlamingo;

public class ZooRenderFlamingo extends RenderLiving
{

	private static byte height = -80;
	
    public ZooRenderFlamingo(float f)
    {
        super(new ZooModelFlamingo(), f);
    }

    public void renderAnimal(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        doRenderAnimal((ZooEntityAnimal)entity, d, d1, d2, f, f1);
    }
    
    public void doRenderAnimal(ZooEntityAnimal animal, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(animal, d, d1, d2, f, f1);
        
        if(animal.captured)
        {
	        float f2 = 1.6F;
	        float f3 = 0.01666667F * f2;
	        float f5 = animal.getDistanceToEntity(renderManager.livingPlayer);
	        if(f5 < 16F)
	        {
	            float f7 = 0.1F;
	            FontRenderer fontrenderer = getFontRendererFromRenderManager();
	            GL11.glPushMatrix();
	            GL11.glTranslatef((float)d + 0.0F, (float)d1 + f7, (float)d2);
	            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	            GL11.glScalef(-f3, -f3, f3);
	            GL11.glDisable(2896 /*GL_LIGHTING*/);
	            
		        //health
		        Tessellator tessellator1 = Tessellator.instance;
		        byte byte0 = height;
		        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
		        byte0 += 50;
		        tessellator1.startDrawingQuads();
		        float f8 = animal.getEntityHealth();
		        if(f8 <= 0)
		        {
		        	f8 = 0;
		        }
		        float f9 = animal.getMaxHealth();
		        float f10 = f8 / f9;
		        float f11 = 40F * f10;
		        tessellator1.setColorRGBA_F(0.7F, 0.0F, 0.0F, 1.0F);
		        tessellator1.addVertex(-20F + f11, -10 + byte0, 0.0D);
		        tessellator1.addVertex(-20F + f11, -6 + byte0, 0.0D);
		        tessellator1.addVertex(20D, -6 + byte0, 0.0D);
		        tessellator1.addVertex(20D, -10 + byte0, 0.0D);
		        tessellator1.setColorRGBA_F(0.0F, 0.7F, 0.0F, 1.0F);
		        tessellator1.addVertex(-20D, -10 + byte0, 0.0D);
		        tessellator1.addVertex(-20D, -6 + byte0, 0.0D);
		        tessellator1.addVertex(f11 - 20F, -6 + byte0, 0.0D);
		        tessellator1.addVertex(f11 - 20F, -10 + byte0, 0.0D);
		        tessellator1.draw();
		        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
		        
		        //hunger
		        Tessellator tessellator2 = Tessellator.instance;
		        byte0 -= 5;
		        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
		        tessellator2.startDrawingQuads();
		        float f12 = animal.getHunger();
		        float f13 = animal.getMaxHunger();
		        float f14 = f12 / f13;
		        float f15 = 40F * f14;
		        tessellator2.setColorRGBA_F(0.0F, 0.0F, 0.9F, 1.0F);
		        tessellator1.addVertex(-20F + f15, -10 + byte0, 0.0D);
		        tessellator1.addVertex(-20F + f15, -6 + byte0, 0.0D);
		        tessellator1.addVertex(20D, -6 + byte0, 0.0D);
		        tessellator1.addVertex(20D, -10 + byte0, 0.0D);
		        tessellator2.setColorRGBA_F(0.098F, 0.098F, 0.439F, 1.0F);
		        tessellator1.addVertex(-20D, -10 + byte0, 0.0D);
		        tessellator1.addVertex(-20D, -6 + byte0, 0.0D);
		        tessellator1.addVertex(f15 - 20F, -6 + byte0, 0.0D);
		        tessellator1.addVertex(f15 - 20F, -10 + byte0, 0.0D);
		        tessellator2.draw();
		        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
		        
		        GL11.glEnable(2896 /*GL_LIGHTING*/);
	            GL11.glPopMatrix();
	        }
    	}
        
        
        if(animal.roped != null)
        {
        	byte byte0 = height;
        	if(animal.isChild())
        	{
        		byte0 -= 10;
        	}
        	d1 = byte0 / 34.04255;
            Tessellator tessellator = Tessellator.instance;
            float f4 = ((animal.roped.prevRotationYaw + (animal.roped.rotationYaw - animal.roped.prevRotationYaw) * f1 * 0.5F) * 3.141593F) / 180F;
            float f6 = ((animal.roped.prevRotationPitch + (animal.roped.rotationPitch - animal.roped.prevRotationPitch) * f1 * 0.5F) * 3.141593F) / 180F;
            double d3 = MathHelper.sin(f4);
            double d4 = MathHelper.cos(f4);
            double d5 = MathHelper.sin(f6);
            double d6 = MathHelper.cos(f6);
            double d7 = (animal.roped.prevPosX + (animal.roped.posX - animal.roped.prevPosX) * (double)f1) - d4 * 0.69999999999999996D - d3 * 0.5D * d6;
            double d8 = (animal.roped.prevPosY + (animal.roped.posY - animal.roped.prevPosY) * (double)f1) - d5 * 0.5D;
            double d9 = ((animal.roped.prevPosZ + (animal.roped.posZ - animal.roped.prevPosZ) * (double)f1) - d3 * 0.69999999999999996D) + d4 * 0.5D * d6;
            double d10 = animal.prevPosX + (animal.posX - animal.prevPosX) * (double)f1;
            double d11 = animal.prevPosY + (animal.posY - animal.prevPosY) * (double)f1 + 0.25D;
            double d12 = animal.prevPosZ + (animal.posZ - animal.prevPosZ) * (double)f1;
            double d13 = (float)(d7 - d10);
            double d14 = (float)(d8 - d11);
            double d15 = (float)(d9 - d12);
            GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            for(double d16 = 0.0D; d16 < 0.029999999999999999D; d16 += 0.01D)
            {
                tessellator.startDrawing(3);
                tessellator.setColorRGBA_F(0F, 0F, 0F, 1.0F);
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
