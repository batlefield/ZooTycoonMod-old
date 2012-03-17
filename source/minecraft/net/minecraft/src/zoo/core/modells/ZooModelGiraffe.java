package net.minecraft.src.zoo.core.modells;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelGiraffe extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg1;
    ModelRenderer NeckD;
    ModelRenderer NeckU;
    ModelRenderer Head;
    ModelRenderer NeckDi;
    ModelRenderer Tail;
  
  public ZooModelGiraffe()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 9, 7, 20);
      Body.setRotationPoint(-4F, 4F, -8F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      
      Leg3 = new ModelRenderer(this, 0, 28);
      Leg3.addBox(0F, 0F, 0F, 2, 13, 2);
      Leg3.setRotationPoint(-4F, 11F, -8F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      
      Leg4 = new ModelRenderer(this, 0, 28);
      Leg4.addBox(0F, 0F, 0F, 2, 13, 2);
      Leg4.setRotationPoint(3F, 11F, -8F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      
      Leg2 = new ModelRenderer(this, 0, 28);
      Leg2.addBox(0F, 0F, 0F, 2, 13, 2);
      Leg2.setRotationPoint(3F, 11F, 10F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      
      Leg1 = new ModelRenderer(this, 0, 28);
      Leg1.addBox(0F, 0F, 0F, 2, 13, 2);
      Leg1.setRotationPoint(-4F, 11F, 10F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      
      NeckD = new ModelRenderer(this, 60, 0);
      NeckD.addBox(0F, 0F, 0F, 3, 10, 5);
      NeckD.setRotationPoint(-1F, -6F, -8F);
      NeckD.setTextureSize(64, 32);
      NeckD.mirror = true;
      setRotation(NeckD, 0F, 0F, 0F);
      
      NeckU = new ModelRenderer(this, 15, 29);
      NeckU.addBox(0F, 0F, 0F, 3, 10, 5);
      NeckU.setRotationPoint(-1F, -16F, -8F);
      NeckU.setTextureSize(64, 32);
      NeckU.mirror = true;
      setRotation(NeckU, 0F, 0F, 0F);
      
      Head = new ModelRenderer(this, 15, 46);
      Head.addBox(-2F, 0F, -7F, 4, 3, 7);
      Head.setRotationPoint(0.5F, -21F, -9F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      
      ModelRenderer Head1 = new ModelRenderer(this, 0, 59);
      Head1.addBox(0F, 0F, 0F, 4, 2, 4);
      Head1.setRotationPoint(-2F, -2F, -4F);
      Head1.setTextureSize(64, 32);
      Head1.mirror = true;
      setRotation(Head1, 0F, 0F, 0F);
      Head.addChild(Head1);

      
      NeckDi = new ModelRenderer(this, 36, 30);
      NeckDi.addBox(0F, 0F, 0F, 3, 8, 5);
      NeckDi.setRotationPoint(-1F, -19F, -12F);
      NeckDi.setTextureSize(64, 32);
      NeckDi.mirror = true;
      setRotation(NeckDi, 0.669215F, 0F, 0F);
      
      ModelRenderer Horn1 = new ModelRenderer(this, 0, 67);
      Horn1.addBox(0F, 0F, 0F, 1, 2, 1);
      Horn1.setRotationPoint(-1.5F, -4F, -1F);
      Horn1.setTextureSize(64, 32);
      Horn1.mirror = true;
      setRotation(Horn1, 0F, 0F, 0F);
      Head.addChild(Horn1);

      
      ModelRenderer Horn2 = new ModelRenderer(this, 0, 67);
      Horn2.addBox(0F, 0F, 0F, 1, 2, 1);
      Horn2.setRotationPoint(0.5F, -4F, -1F);
      Horn2.setTextureSize(64, 32);
      Horn2.mirror = true;
      setRotation(Horn2, 0F, 0F, 0F);
      Head.addChild(Horn2);
      
      Tail = new ModelRenderer(this, 0, 45);
      Tail.addBox(0F, 0F, 0F, 1, 10, 1);
      Tail.setRotationPoint(0F, 4F, 11F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0.2230717F, 0F, 0F);
      
      ModelRenderer Ear2 = new ModelRenderer(this, 0, 8);
      Ear2.addBox(0F, 0F, 0F, 1, 2, 1);
      Ear2.setRotationPoint(3F, -2F, -1F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, 0F, 0F, 0.8922867F);
      Head.addChild(Ear2);
      
      ModelRenderer Ear1 = new ModelRenderer(this, 0, 0);
      Ear1.addBox(0F, 0F, 0F, 1, 2, 1);
      Ear1.setRotationPoint(-3.7F, -1F, -1F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, 0F, 0F, -0.8922867F);
      Head.addChild(Ear1);
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
	    Body.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Leg2.render(f5);
	    Leg1.render(f5);
	    NeckD.render(f5);
	    NeckU.render(f5);
	    Head.render(f5);
	    NeckDi.render(f5);
	    Tail.render(f5);
	    GL11.glPopMatrix();
	  }else{

	    Body.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Leg2.render(f5);
	    Leg1.render(f5);
	    NeckD.render(f5);
	    NeckU.render(f5);
	    Head.render(f5);
	    NeckDi.render(f5);
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
	  Head.rotateAngleX = f4 / 57.29578F;
      Head.rotateAngleY = f3 / 57.29578F;
      Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
