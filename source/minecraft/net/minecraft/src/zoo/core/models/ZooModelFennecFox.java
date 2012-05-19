package net.minecraft.src.zoo.core.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelFennecFox extends ModelBase
{
  //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
  
  public ZooModelFennecFox()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      
      WolfHead = new ModelRenderer(this, 0, 0);
      WolfHead.addBox(-3F, -3F, -2F, 4, 4, 4);
      WolfHead.setRotationPoint(0F, 17.5F, -7F);
      WolfHead.setTextureSize(64, 32);
      WolfHead.mirror = true;
      setRotation(WolfHead, 0F, 0F, 0F);
      
      Body = new ModelRenderer(this, 18, 14);
      Body.addBox(-4F, -2F, -3F, 6, 9, 4);
      Body.setRotationPoint(0F, 17F, -3F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 1.570796F, 0F, 0F);
      
      Leg1 = new ModelRenderer(this, 0, 18);
      Leg1.addBox(-1F, 0F, -1F, 2, 4, 2);
      Leg1.setRotationPoint(-2.5F, 20F, 3F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      
      Leg2 = new ModelRenderer(this, 0, 18);
      Leg2.addBox(-1F, 0F, -1F, 2, 4, 2);
      Leg2.setRotationPoint(0.5F, 20F, 3F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      
      Leg3 = new ModelRenderer(this, 0, 18);
      Leg3.addBox(-1F, 0F, -1F, 2, 4, 2);
      Leg3.setRotationPoint(-2.5F, 20F, -4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      
      Leg4 = new ModelRenderer(this, 0, 18);
      Leg4.addBox(-1F, 0F, -1F, 2, 4, 2);
      Leg4.setRotationPoint(0.5F, 20F, -4F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      
      Tail = new ModelRenderer(this, 9, 18);
      Tail.addBox(-1F, 0F, 1F, 1, 5, 1);
      Tail.setRotationPoint(-0.5F, 18F, 3F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 1.130069F, 0F, 0F);
      
      ModelRenderer Ear1 = new ModelRenderer(this, 17, 0);
      Ear1.addBox(0F, 0F, 0F, 3, 4, 1);
      Ear1.setRotationPoint(-6F, -4F, 0F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, -0.1487144F, -0.2974289F, -0.7435722F);
      WolfHead.addChild(Ear1);
      
      
      ModelRenderer Ear2 = new ModelRenderer(this, 26, 1);
      Ear2.addBox(0F, 0F, 0F, 4, 3, 1);
      Ear2.setRotationPoint(-1.2F, -3F, 0F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, -0.1487144F, 0.0371786F, -0.8551081F);
      WolfHead.addChild(Ear2);
      
      ModelRenderer Shape1 = new ModelRenderer(this, 0, 10);
      Shape1.addBox(0F, 0F, 0F, 2, 2, 3);
      Shape1.setRotationPoint(-2F, -1F, -5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      WolfHead.addChild(Shape1);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5);
    if(isChild)
    {
    	float f6 = 2.0F;
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
	    WolfHead.render(f5);
	    Body.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Tail.render(f5);
	    GL11.glPopMatrix();
    }else{
    	WolfHead.render(f5);
	    Body.render(f5);
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
