package net.minecraft.src.zoo.core.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelRhino extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
  
  public ZooModelRhino()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 9F, -8F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      
      ModelRenderer nose = new ModelRenderer(this, 36, 24);
      nose.addBox(0F, 0F, 0F, 8, 6, 6);
      nose.setRotationPoint(-4F, -2F, -12F);
      nose.setTextureSize(128, 128);
      nose.mirror = true;
      setRotation(nose, 0F, 0F, 0F);
      head.addChild(nose);
      
      ModelRenderer horn = new ModelRenderer(this, 0, 44);
      horn.addBox(0F, 0F, 0F, 2, 2, 2);
      horn.setRotationPoint(3F, -2F, 1F);
      horn.setTextureSize(128, 128);
      setRotation(horn, 0F, 0F, 0F);
      nose.addChild(horn);
      
      body = new ModelRenderer(this, 20, 36);
      body.addBox(-6F, -10F, -8F, 12, 18, 10);
      body.setRotationPoint(0F, 8F, 2F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-3F, 0F, -2F, 4, 9, 4);
      leg1.setRotationPoint(-3F, 15F, 7F);
      leg1.setTextureSize(128, 128);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-1F, 0F, -2F, 4, 9, 4);
      leg2.setRotationPoint(3F, 15F, 7F);
      leg2.setTextureSize(128, 128);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-3F, 0F, -3F, 4, 9, 4);
      leg3.setRotationPoint(-3F, 15F, -5F);
      leg3.setTextureSize(128, 128);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-1F, 0F, -3F, 4, 9, 4);
      leg4.setRotationPoint(3F, 15F, -5F);
      leg4.setTextureSize(128, 128);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      
      ModelRenderer earright = new ModelRenderer(this, 28, 0);
      earright.addBox(0F, 0F, 0F, 2, 3, 1);
      earright.setRotationPoint(-4F, -6F, -4F);
      earright.setTextureSize(128, 128);
      earright.mirror = true;
      setRotation(earright, 0F, 0F, 0F);
      head.addChild(earright);
      
      ModelRenderer earleft = new ModelRenderer(this, 28, 0);
      earleft.addBox(0F, 0F, 0F, 2, 3, 1);
      earleft.setRotationPoint(3F, -6F, -4F);
      earleft.setTextureSize(128, 128);
      earleft.mirror = true;
      setRotation(earleft, 0F, 0F, 0F);
      head.addChild(earleft);
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
          head.render(f5);
          body.render(f5);
          leg1.render(f5);
          leg2.render(f5);
          leg3.render(f5);
          leg4.render(f5);
          GL11.glPopMatrix();
      } else
      {
          head.render(f5);
          body.render(f5);
          leg1.render(f5);
          leg2.render(f5);
          leg3.render(f5);
          leg4.render(f5);
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
	  head.rotateAngleX = f4 / 57.29578F;
      head.rotateAngleY = f3 / 57.29578F;
      body.rotateAngleX = 1.570796F;
      leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
