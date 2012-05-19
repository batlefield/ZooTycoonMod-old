package net.minecraft.src.zoo.core.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelGazelle extends ModelBase
{
  //fields
    ModelRenderer Shape3;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Shape2;
  
  public ZooModelGazelle()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape3 = new ModelRenderer(this, 54, 14);
      Shape3.addBox(-1F, -0.4666667F, 0.7333333F, 2, 1, 3);
      Shape3.setRotationPoint(0F, 5F, 7F);
      Shape3.setTextureSize(64, 32);
      setRotation(Shape3, -0.5948578F, 0F, 0F);
      
      head = new ModelRenderer(this, 48, 0);
      head.addBox(-2F, 0F, -4F, 4, 4, 4);
      head.setRotationPoint(0F, -3F, -11F);
      head.setTextureSize(64, 32);
      setRotation(head, 0F, 0F, 0F);
      
      ModelRenderer Shape4 = new ModelRenderer(this, 54, 12);
      Shape4.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape4.setRotationPoint(-5F, 0F, -1F);
      Shape4.setTextureSize(64, 32);
      setRotation(Shape4, 0F, 0F, 0.1745329F);
      head.addChild(Shape4);
      
      ModelRenderer Shape5 = new ModelRenderer(this, 54, 12);
      Shape5.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape5.setRotationPoint(1F, 0F, -1F);
      Shape5.setTextureSize(64, 32);
      setRotation(Shape5, 0F, 0F, -0.1745329F);
      head.addChild(Shape5);
      
      body = new ModelRenderer(this, 12, 0);
      body.addBox(-3F, -15F, -7F, 6, 16, 7);
      body.setRotationPoint(0F, 5F, 7F);
      body.setTextureSize(64, 32);
      setRotation(body, 1.570796F, 0F, 0F);
      
      leg1 = new ModelRenderer(this, 0, 18);
      leg1.addBox(-3F, 0F, -2F, 2, 12, 2);
      leg1.setRotationPoint(0F, 12F, 8F);
      leg1.setTextureSize(64, 32);
      setRotation(leg1, 0F, 0F, 0F);
      
      leg2 = new ModelRenderer(this, 0, 18);
      leg2.addBox(-1F, 0F, 0F, 2, 12, 2);
      leg2.setRotationPoint(2F, 12F, 6F);
      leg2.setTextureSize(64, 32);
      setRotation(leg2, 0F, 0F, 0F);
      
      leg3 = new ModelRenderer(this, 0, 18);
      leg3.addBox(-3F, 0F, -3F, 2, 12, 2);
      leg3.setRotationPoint(0F, 12F, -5F);
      leg3.setTextureSize(64, 32);
      setRotation(leg3, 0F, 0F, 0F);
      
      leg4 = new ModelRenderer(this, 0, 18);
      leg4.addBox(-1F, 0F, -3F, 2, 12, 2);
      leg4.setRotationPoint(2F, 12F, -5F);
      leg4.setTextureSize(64, 32);
      setRotation(leg4, 0F, 0F, 0F);
      
      ModelRenderer horn1 = new ModelRenderer(this, 0, 0);
      horn1.addBox(0F, 0F, 0F, 1, 8, 1);
      horn1.setRotationPoint(-1.5F, -7F, 1F);
      horn1.setTextureSize(64, 32);
      setRotation(horn1, -0.3490659F, 0F, 0F);
      head.addChild(horn1);
      
      ModelRenderer horn2 = new ModelRenderer(this, 0, 0);
      horn2.addBox(0F, 0F, 0F, 1, 8, 1);
      horn2.setRotationPoint(0.4666667F, -7F, 1F);
      horn2.setTextureSize(64, 32);
      setRotation(horn2, -0.3490659F, 0F, 0F);
      head.addChild(horn2);
      
      ModelRenderer Shape1 = new ModelRenderer(this, 24, 23);
      Shape1.addBox(0F, 0F, 0F, 4, 2, 3);
      Shape1.setRotationPoint(-2F, 2F, -7F);
      setRotation(Shape1, 0F, 0F, 0F);
      head.addChild(Shape1);
      
      Shape2 = new ModelRenderer(this, 38, 18);
      Shape2.addBox(-1F, 1F, 0F, 2, 3, 11);
      Shape2.setRotationPoint(0F, -3F, -11F);
      Shape2.setTextureSize(64, 32);
      setRotation(Shape2, -0.8202015F, 0F, 0F);
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
          head.render(f5);
          body.render(f5);
          leg1.render(f5);
          leg2.render(f5);
          leg3.render(f5);
          leg4.render(f5);
          Shape2.render(f5);
          Shape3.render(f5);
          GL11.glPopMatrix();
      } else
      {
          head.render(f5);
          body.render(f5);
          leg1.render(f5);
          leg2.render(f5);
          leg3.render(f5);
          leg4.render(f5);
          Shape2.render(f5);
          Shape3.render(f5);
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
