package net.minecraft.src.zoo.core.modells;

import net.minecraft.src.*;

public class ZooModelTiger extends ModelBase
{
  //fields
    ModelRenderer tail;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
  
  public ZooModelTiger()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      tail = new ModelRenderer(this, 28, 18);
      tail.addBox(-1F, -1F, 0F, 2, 2, 16);
      tail.setRotationPoint(0F, 3F, 12F);
      tail.setTextureSize(128, 128);
      tail.mirror = true;
      setRotation(tail, -0.7853982F, 0F, 0F);
      
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 4F, -8F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      
      ModelRenderer mouth = new ModelRenderer(this, 0, 58);
      mouth.addBox(0F, 0F, 0F, 4, 4, 5);
      mouth.setRotationPoint(-2F, 0F, -8F);
      mouth.setTextureSize(128, 128);
      mouth.mirror = true;
      setRotation(mouth, 0F, 0F, 0F);
      head.addChild(mouth);
      
      body = new ModelRenderer(this, 20, 36);
      body.addBox(-6F, -10F, -7F, 12, 21, 10);
      body.setRotationPoint(0F, 5F, 2F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
      leg1.setRotationPoint(-3F, 12F, 11F);
      leg1.setTextureSize(128, 128);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
      leg2.setRotationPoint(3F, 12F, 11F);
      leg2.setTextureSize(128, 128);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-3F, 0F, -3F, 4, 12, 4);
      leg3.setRotationPoint(-3F, 12F, -5F);
      leg3.setTextureSize(128, 128);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
      leg4.setRotationPoint(3F, 12F, -5F);
      leg4.setTextureSize(128, 128);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      
      ModelRenderer horn1 = new ModelRenderer(this, 33, 0);
      horn1.addBox(0F, 0F, 0F, 3, 3, 1);
      horn1.setRotationPoint(-4F, -5F, -4F);
      horn1.setTextureSize(128, 128);
      horn1.mirror = true;
      setRotation(horn1, 0F, 0F, 0F);
      head.addChild(horn1);
      
      ModelRenderer horn2 = new ModelRenderer(this, 33, 0);
      horn2.addBox(0F, 0F, 0F, 3, 3, 1);
      horn2.setRotationPoint(1F, -5F, -4F);
      horn2.setTextureSize(128, 128);
      horn2.mirror = true;
      setRotation(horn2, 0F, 0F, 0F);
      head.addChild(horn2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    tail.render(f5);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
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
