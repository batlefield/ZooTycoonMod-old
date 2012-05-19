package net.minecraft.src.zoo.core.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;

public class ZooModelWolf extends ModelBase
{
  //fields
	/** main box for the wolf head */
    public ModelRenderer wolfHeadMain;

    /** The wolf's body */
    public ModelRenderer wolfBody;

    /** Wolf'se first leg */
    public ModelRenderer wolfLeg1;

    /** Wolf's second leg */
    public ModelRenderer wolfLeg2;

    /** Wolf's third leg */
    public ModelRenderer wolfLeg3;

    /** Wolf's fourth leg */
    public ModelRenderer wolfLeg4;

    /** The wolf's tail */
    ModelRenderer wolfTail;

    /** The wolf's mane */
    ModelRenderer wolfMane;
  
  public ZooModelWolf()
  {
	  float var1 = 0.0F;
      float var2 = 13.5F;
      this.wolfHeadMain = new ModelRenderer(this, 0, 0);
      this.wolfHeadMain.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, var1);
      this.wolfHeadMain.setRotationPoint(-1.0F, var2, -7.0F);
      this.wolfBody = new ModelRenderer(this, 18, 14);
      this.wolfBody.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6, var1);
      this.wolfBody.setRotationPoint(0.0F, 14.0F, 2.0F);
      this.wolfMane = new ModelRenderer(this, 21, 0);
      this.wolfMane.addBox(-4.0F, -3.0F, -3.0F, 8, 6, 7, var1);
      this.wolfMane.setRotationPoint(-1.0F, 14.0F, 2.0F);
      this.wolfLeg1 = new ModelRenderer(this, 0, 18);
      this.wolfLeg1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.wolfLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
      this.wolfLeg2 = new ModelRenderer(this, 0, 18);
      this.wolfLeg2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.wolfLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
      this.wolfLeg3 = new ModelRenderer(this, 0, 18);
      this.wolfLeg3.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.wolfLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
      this.wolfLeg4 = new ModelRenderer(this, 0, 18);
      this.wolfLeg4.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.wolfLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
      this.wolfTail = new ModelRenderer(this, 9, 18);
      this.wolfTail.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.wolfTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
      this.wolfHeadMain.setTextureOffset(16, 14).addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1, var1);
      this.wolfHeadMain.setTextureOffset(16, 14).addBox(1.0F, -5.0F, 0.0F, 2, 2, 1, var1);
      this.wolfHeadMain.setTextureOffset(0, 10).addBox(-1.5F, 0.0F, -5.0F, 3, 3, 4, var1);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5);
    wolfHeadMain.render(f5);
    wolfBody.render(f5);
	wolfLeg1.render(f5);
	wolfLeg2.render(f5);
	wolfLeg3.render(f5);
	wolfLeg4.render(f5);
	wolfTail.render(f5);
    
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
	  wolfHeadMain.rotateAngleX = f4 / 57.29578F;
      wolfHeadMain.rotateAngleY = f3 / 57.29578F;
      wolfBody.rotateAngleX = 1.570796F;
      wolfLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      wolfLeg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      wolfLeg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      wolfLeg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
