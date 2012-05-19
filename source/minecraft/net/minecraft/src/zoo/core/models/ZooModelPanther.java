package net.minecraft.src.zoo.core.models;

import net.minecraft.src.*;

public class ZooModelPanther extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Body;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Tail;
  
  public ZooModelPanther()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Leg1 = new ModelRenderer(this, 0, 20);
      Leg1.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg1.setRotationPoint(-5F, 12F, 10F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, -1.570796F, 0F);
      
      Leg2 = new ModelRenderer(this, 0, 20);
      Leg2.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg2.setRotationPoint(3F, 12F, 10F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, -1.570796F, 0F);
      
      Leg3 = new ModelRenderer(this, 0, 20);
      Leg3.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg3.setRotationPoint(-5F, 12F, -8F);
      Leg3.setTextureSize(128, 128);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, -1.570796F, 0F);
      
      Leg4 = new ModelRenderer(this, 0, 20);
      Leg4.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg4.setRotationPoint(3F, 12F, -8F);
      Leg4.setTextureSize(128, 128);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, -1.570796F, 0F);
      
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 22, 8, 12);
      Body.setRotationPoint(3F, 4F, -8F);
      Body.setTextureSize(128, 128);
      Body.mirror = true;
      setRotation(Body, 0F, -1.570796F, 0F);
      
      Neck = new ModelRenderer(this, 0, 44);
      Neck.addBox(0F, 0F, 0F, 5, 5, 6);
      Neck.setRotationPoint(0F, 2F, -11F);
      Neck.setTextureSize(128, 128);
      Neck.mirror = true;
      setRotation(Neck, 0F, -1.570796F, 0.3569147F);
      
      Head = new ModelRenderer(this, 17, 20);
      Head.addBox(0F, 0F, 0F, 4, 5, 6);
      Head.setRotationPoint(0F, 2F, -15F);
      Head.setTextureSize(128, 128);
      Head.mirror = true;
      setRotation(Head, 0F, -1.570796F, 0F);
      
      ModelRenderer Snout = new ModelRenderer(this, 38, 21);
      Snout.addBox(0F, 0F, 0F, 3, 3, 3);
      Snout.setRotationPoint(-1.5F, 4F, -17.5F);
      Snout.setTextureSize(128, 128);
      Snout.mirror = true;
      setRotation(Snout, 0F, -1.570796F, 0F);
      Head.addChild(Snout);
      
      Tail = new ModelRenderer(this, 0, 38);
      Tail.addBox(0F, 0F, 0F, 11, 2, 2);
      Tail.setRotationPoint(-2F, 4F, 14F);
      Tail.setTextureSize(128, 128);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      
      ModelRenderer Ear1 = new ModelRenderer(this, 0, 59);
      Ear1.addBox(0F, 0F, 0F, 1, 2, 2);
      Ear1.setRotationPoint(-4F, 0F, -12F);
      Ear1.setTextureSize(128, 128);
      Ear1.mirror = true;
      setRotation(Ear1, 0F, -1.570796F, 0F);
      Head.addChild(Ear1);
      
      
      ModelRenderer Ear2 = new ModelRenderer(this, 0, 59);
      Ear2.addBox(0F, 0F, 0F, 1, 2, 2);
      Ear2.setRotationPoint(0F, 0F, -12F);
      Ear2.setTextureSize(128, 128);
      Ear2.mirror = true;
      setRotation(Ear2, 0F, -1.570796F, 0F);
      Head.addChild(Ear2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Body.render(f5);
    Neck.render(f5);
    Head.render(f5);
    Tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
