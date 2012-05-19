package net.minecraft.src.zoo.core.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelAfricanWDog extends ModelBase
{
  //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
  
  public ZooModelAfricanWDog()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      WolfHead = new ModelRenderer(this, 0, 0);
      WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
      WolfHead.setRotationPoint(-1F, 13.5F, -7F);
      WolfHead.setTextureSize(64, 32);
      WolfHead.mirror = true;
      setRotation(WolfHead, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 18, 14);
      Body.addBox(-4F, -2F, -3F, 6, 9, 6);
      Body.setRotationPoint(0F, 14F, 2F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 1.570796F, 0F, 0F);
      Mane = new ModelRenderer(this, 21, 0);
      Mane.addBox(-4F, -3F, -3F, 8, 6, 7);
      Mane.setRotationPoint(-1F, 14F, -3F);
      Mane.setTextureSize(64, 32);
      Mane.mirror = true;
      setRotation(Mane, 1.570796F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 43, 13);
      Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg1.setRotationPoint(-2.5F, 16F, 7F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 18);
      Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg2.setRotationPoint(0.5F, 16F, 7F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 43, 13);
      Leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg3.setRotationPoint(-2.5F, 16F, -4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 0, 18);
      Leg4.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg4.setRotationPoint(0.5F, 16F, -4F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 9, 18);
      Tail.addBox(-1F, 0F, -1F, 2, 10, 2);
      Tail.setRotationPoint(-1F, 12F, 8F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0.7211046F, 0F, 0F);
      
      ModelRenderer Ear1 = new ModelRenderer(this, 43, 24);
      Ear1.addBox(0F, 0F, 0F, 3, 3, 1);
      Ear1.setRotationPoint(-4F, -4F, 0F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, 0F, 0F, -0.4363323F);
      WolfHead.addChild(Ear1);
      
      ModelRenderer Ear2 = new ModelRenderer(this, 43, 24);
      Ear2.addBox(0F, 0F, 0F, 3, 3, 1);
      Ear2.setRotationPoint(1F, -5F, 0F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, 0F, 0F, 0.4363323F);
      WolfHead.addChild(Ear2);
      
      ModelRenderer Nose = new ModelRenderer(this, 2, 12);
      Nose.addBox(0F, 0F, 0F, 3, 3, 2);
      Nose.setRotationPoint(-1.5F, 0F, -4F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      WolfHead.addChild(Nose);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5);
    if(isChild)
    {
        float f6 = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 8F * f5, 4F * f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
	    WolfHead.render(f5);
	    Body.render(f5);
	    Mane.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Tail.render(f5);
	    GL11.glPopMatrix();
    } else
    {
    	WolfHead.render(f5);
	    Body.render(f5);
	    Mane.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Tail.render(f5);
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
	  WolfHead.rotateAngleX = f4 / 57.29578F;
	  WolfHead.rotateAngleY = f3 / 57.29578F;
      Body.rotateAngleX = 1.570796F;
      Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
