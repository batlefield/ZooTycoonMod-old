package net.minecraft.src.zoo.core.modells;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelAnteater extends ModelBase
{
  //fields
    ModelRenderer leg2;
    ModelRenderer leg1;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer body;
    ModelRenderer back;
    ModelRenderer Shape4;
    ModelRenderer head;
  
  public ZooModelAnteater()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      leg2 = new ModelRenderer(this, 0, 0);
      leg2.addBox(0F, 0F, 0F, 4, 6, 4);
      leg2.setRotationPoint(8F, 18F, 8F);
      leg2.setTextureSize(128, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, -3.141593F, 0F);
      
      leg1 = new ModelRenderer(this, 0, 0);
      leg1.addBox(0F, 0F, 0F, 4, 6, 4);
      leg1.setRotationPoint(1F, 18F, 8F);
      leg1.setTextureSize(128, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, -3.141593F, 0F);
      
      leg3 = new ModelRenderer(this, 0, 0);
      leg3.addBox(0F, 0F, 0F, 4, 6, 4);
      leg3.setRotationPoint(0.7F, 18F, -7F);
      leg3.setTextureSize(128, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, -3.141593F, 0F);
      
      leg4 = new ModelRenderer(this, 0, 0);
      leg4.addBox(0F, 0F, 0F, 4, 6, 4);
      leg4.setRotationPoint(7.5F, 18F, -7F);
      leg4.setTextureSize(128, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, -3.141593F, 0F);
      
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 11, 6, 19);
      body.setRotationPoint(8F, 12F, 8F);
      body.setTextureSize(128, 32);
      body.mirror = true;
      setRotation(body, 0F, -3.141593F, 0F);
      
      back = new ModelRenderer(this, 41, 0);
      back.addBox(0F, 0F, 0F, 11, 5, 8);
      back.setRotationPoint(8.2F, 15F, 15F);
      back.setTextureSize(128, 32);
      back.mirror = true;
      setRotation(back, 0.4089647F, -3.141593F, 0F);
      
      Shape4 = new ModelRenderer(this, 1, 10);
      Shape4.addBox(0F, 0F, 8F, 5, 5, 3);
      Shape4.setRotationPoint(5F, 12F, -3F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, -3.141593F, 0F);
      
      head = new ModelRenderer(this, 61, 24);
      head.addBox(-1.5F, -2F, 0F, 3, 4, 4);
      head.setRotationPoint(2F, 14F, -14F);
      head.setTextureSize(128, 32);
      setRotation(head, 0F, 0F, 3.14159265F);
      
      
      ModelRenderer nose1 = new ModelRenderer(this, 61, 15);
      nose1.addBox(0F, 0F, 0F, 1, 3, 4);
      nose1.setRotationPoint(0F, 1F, 7F);
      nose1.setTextureSize(128, 32);
      nose1.mirror = true;
      setRotation(nose1, 0.5576792F, -3.141593F, 0F);
      head.addChild(nose1);
      
      ModelRenderer nose2 = new ModelRenderer(this, 32, 26);
      nose2.addBox(0F, 0F, 0F, 1, 1, 4);
      nose2.setRotationPoint(1F, 1F, 0F);
      nose2.setTextureSize(128, 32);
      nose2.mirror = true;
      setRotation(nose2, -0.5F, -3.141593F, 0F);
      nose1.addChild(nose2);
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
          back.render(f5);
          Shape4.render(f5);
          GL11.glPopMatrix();
      } else
      {
          head.render(f5);
          body.render(f5);
          leg1.render(f5);
          leg2.render(f5);
          leg3.render(f5);
          leg4.render(f5);
          back.render(f5);
          Shape4.render(f5);
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
	head.rotateAngleX = f4 / 57.29578F + 3.14159265F;
    head.rotateAngleY = f3 / 57.29578F;
    body.rotateAngleX = 0F;
    leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
    leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
    leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
