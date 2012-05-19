package net.minecraft.src.zoo.core.models;

import net.minecraft.src.*;

public class ZooModelFlamingo extends ModelBase
{
  //fields
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer body;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer nose2;
    ModelRenderer nose1;
    ModelRenderer leftWing;
    ModelRenderer rightWing;
  
  public ZooModelFlamingo()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      foot1 = new ModelRenderer(this, 0, 14);
      foot1.addBox(0F, 0F, 0F, 2, 1, 1);
      foot1.setRotationPoint(0F, 23F, -2F);
      foot1.setTextureSize(64, 32);
      foot1.mirror = true;
      setRotation(foot1, 0F, -1.570796F, 0F);
      
      foot2 = new ModelRenderer(this, 0, 14);
      foot2.addBox(0F, 0F, 0F, 2, 1, 1);
      foot2.setRotationPoint(2F, 23F, -2F);
      foot2.setTextureSize(64, 32);
      foot2.mirror = true;
      setRotation(foot2, 0F, -1.570796F, 0F);
      
      leg1 = new ModelRenderer(this, 0, 7);
      leg1.addBox(0F, 0F, 0F, 1, 5, 1);
      leg1.setRotationPoint(-1F, 18F, -1F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      
      leg2 = new ModelRenderer(this, 0, 7);
      leg2.addBox(0F, 0F, 0F, 1, 5, 1);
      leg2.setRotationPoint(1F, 18F, -1F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      
      body = new ModelRenderer(this, 6, 6);
      body.addBox(0F, 0F, 0F, 4, 3, 3);
      body.setRotationPoint(2F, 15F, -3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, -1.570796F, 0F);
      
      neck = new ModelRenderer(this, 0, 0);
      neck.addBox(0F, 0F, 0F, 1, 5, 1);
      neck.setRotationPoint(0F, 10F, -3F);
      neck.setTextureSize(64, 32);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      
      head = new ModelRenderer(this, 7, 0);
      head.addBox(-4F, 0F, -1F, 4, 2, 2);
      head.setRotationPoint(0.5F, 8F, -1.5F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, -1.570796F, 0F);
      
      nose2 = new ModelRenderer(this, 0, 17);
      nose2.addBox(0F, 0F, 0F, 1, 1, 2);
      nose2.setRotationPoint(1.5F, 9.4F, -7F);
      nose2.setTextureSize(64, 32);
      nose2.mirror = true;
      setRotation(nose2, 0F, -1.570796F, 0F);
      
      nose1 = new ModelRenderer(this, 0, 16);
      nose1.addBox(0F, 0F, 0F, 1, 2, 2);
      nose1.setRotationPoint(1.5F, 8F, -5.5F);
      nose1.setTextureSize(64, 32);
      nose1.mirror = true;
      setRotation(nose1, 0F, -1.570796F, 0.7853982F);
      
      leftWing = new ModelRenderer(this, 0, 21);
      leftWing.addBox(0F, 0F, 0F, 3, 2, 1);
      leftWing.setRotationPoint(-1F, 15F, -3F);
      leftWing.setTextureSize(64, 32);
      leftWing.mirror = true;
      setRotation(leftWing, 0F, -1.570796F, 0F);
      
      rightWing = new ModelRenderer(this, 0, 21);
      rightWing.addBox(0F, 0F, 0F, 3, 2, 1);
      rightWing.setRotationPoint(3F, 15F, -3F);
      rightWing.setTextureSize(64, 32);
      rightWing.mirror = true;
      setRotation(rightWing, 0F, -1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    foot1.render(f5);
    foot2.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    body.render(f5);
    neck.render(f5);
    head.render(f5);
    nose2.render(f5);
    nose1.render(f5);
    leftWing.render(f5);
    rightWing.render(f5);
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
