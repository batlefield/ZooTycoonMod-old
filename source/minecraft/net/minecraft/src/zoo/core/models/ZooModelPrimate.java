package net.minecraft.src.zoo.core.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelPrimate extends ModelBase
{
  //fields
    ModelRenderer rightarmtop;
    ModelRenderer rightarm;
    ModelRenderer leftarmtop;
    ModelRenderer leftarm;
    ModelRenderer Shape1;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public ZooModelPrimate()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      rightarmtop = new ModelRenderer(this, 0, 0);
      rightarmtop.addBox(0F, 0F, 0F, 4, 9, 4);
      rightarmtop.setRotationPoint(-8F, 5F, -5F);
      rightarmtop.setTextureSize(128, 128);
      rightarmtop.mirror = true;
      setRotation(rightarmtop, -0.3490659F, 0F, 0F);
      
      rightarm = new ModelRenderer(this, 0, 69);
      rightarm.addBox(0F, 0F, 1F, 4, 10, 4);
      rightarm.setRotationPoint(-8F, 14F, -9F);
      rightarm.setTextureSize(128, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      
      leftarmtop = new ModelRenderer(this, 0, 0);
      leftarmtop.addBox(0F, 0F, 0F, 4, 9, 4);
      leftarmtop.setRotationPoint(4F, 5F, -5F);
      leftarmtop.setTextureSize(128, 128);
      leftarmtop.mirror = true;
      setRotation(leftarmtop, -0.3490659F, 0F, 0F);
      
      leftarm = new ModelRenderer(this, 0, 69);
      leftarm.addBox(0F, 0F, 0F, 4, 10, 4);
      leftarm.setRotationPoint(4F, 14F, -8F);
      leftarm.setTextureSize(128, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      
      Shape1 = new ModelRenderer(this, 0, 50);
      Shape1.addBox(0F, 0F, 0F, 2, 2, 12);
      Shape1.setRotationPoint(-1F, 9F, 5F);
      Shape1.setTextureSize(128, 128);
      Shape1.mirror = true;
      setRotation(Shape1, -0.1858931F, 0F, 0F);
      
      head = new ModelRenderer(this, 30, 20);
      head.addBox(-4F, -3F, -9F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      
      body = new ModelRenderer(this, 40, 0);
      body.addBox(-4F, -2F, -4F, 8, 12, 4);
      body.setRotationPoint(0F, 5F, -2F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 1.07818F, 0F, 0F);
      
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(0F, 0F, 0F, 4, 12, 4);
      rightleg.setRotationPoint(-4F, 12F, 3F);
      rightleg.setTextureSize(128, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(0F, 0F, 0F, 4, 12, 4);
      leftleg.setRotationPoint(0F, 12F, 3F);
      leftleg.setTextureSize(128, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
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
          rightleg.render(f5);
          leftleg.render(f5);
          leftarmtop.render(f5);
          leftarm.render(f5);
          rightarmtop.render(f5);
          rightarm.render(f5);
          Shape1.render(f5);
          GL11.glPopMatrix();
      } else
      {
          head.render(f5);
          body.render(f5);
          rightleg.render(f5);
          leftleg.render(f5);
          leftarmtop.render(f5);
          leftarm.render(f5);
          rightarmtop.render(f5);
          rightarm.render(f5);
          Shape1.render(f5);
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
      rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
