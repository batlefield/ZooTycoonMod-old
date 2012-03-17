package net.minecraft.src.zoo.core.modells;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelElephant extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
  
  public ZooModelElephant()
  {
    textureWidth = 64;
    textureHeight = 64;
      
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 7F, -8F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      
      ModelRenderer trunk = new ModelRenderer(this, 28, 0);
      trunk.addBox(0F, 0F, 0F, 3, 12, 2);
      trunk.setRotationPoint(-1.5F, 0F, -7F);
      trunk.setTextureSize(64, 32);
      trunk.mirror = true;
      setRotation(trunk, -0.1115358F, 0F, 0F);
      head.addChild(trunk);
      
      ModelRenderer uppertusk1 = new ModelRenderer(this, 16, 16);
      uppertusk1.addBox(0F, 0F, 0F, 1, 8, 1);
      uppertusk1.setRotationPoint(2F, 0F, -6F);
      uppertusk1.setTextureSize(64, 32);
      uppertusk1.mirror = true;
      setRotation(uppertusk1, -0.2974289F, 1.524323F, -0.4461433F);
      head.addChild(uppertusk1);
      
      ModelRenderer uppertusk2 = new ModelRenderer(this, 16, 16);
      uppertusk2.addBox(0F, 0F, 0F, 1, 8, 1);
      uppertusk2.setRotationPoint(-2F, 0F, -7F);
      uppertusk2.setTextureSize(64, 32);
      uppertusk2.mirror = true;
      setRotation(uppertusk2, -0.2974216F, -1.524318F, 0.4112345F);
      head.addChild(uppertusk2);
      
      body = new ModelRenderer(this, 0, 34);
      body.addBox(-6F, -10F, -7F, 14, 20, 10);
      body.setRotationPoint(-1F, 5F, 2F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
      leg1.setRotationPoint(-3F, 12F, 8F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
      leg2.setRotationPoint(3F, 12F, 8F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-3F, 0F, -3F, 4, 12, 4);
      leg3.setRotationPoint(-3F, 12F, -4F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
      leg4.setRotationPoint(3F, 12F, -4F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      
      ModelRenderer horn1 = new ModelRenderer(this, 44, 0);
      horn1.addBox(0F, 0F, 0F, 8, 9, 1);
      horn1.setRotationPoint(-10F, -3F, -3F);
      horn1.setTextureSize(64, 32);
      horn1.mirror = true;
      setRotation(horn1, 0F, 0.2617994F, -0.3490659F);
      head.addChild(horn1);
      
      ModelRenderer horn2 = new ModelRenderer(this, 44, 0);
      horn2.addBox(0F, 0F, 0F, 8, 9, 1);
      horn2.setRotationPoint(3F, -6F, -4F);
      horn2.setTextureSize(64, 32);
      horn2.mirror = true;
      setRotation(horn2, 0F, -0.2617994F, 0.3490659F);
      head.addChild(horn2);
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
