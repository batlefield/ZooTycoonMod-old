package net.minecraft.src.zoo.core.models;

import net.minecraft.src.ModelRenderer;
import net.minecraft.src.zoo.core.models.visitors.FemaleBase;

public class ZooModelFemaleMarine extends FemaleBase
{

	public ZooModelFemaleMarine()
	{
		textureWidth = 128;
		textureHeight = 128;
		
		tail = new ModelRenderer(this, 53, 0);
	      tail.addBox(0F, 0F, 0F, 2, 8, 2);
	      tail.setRotationPoint(-1F, -5F, 4F);
	      tail.setTextureSize(128, 128);
	      tail.mirror = true;
	      setRotation(tail, 0F, 0F, 0F);
		
		ModelRenderer rightFlipper = new ModelRenderer(this, 32, 0);
		rightFlipper.addBox(0F, 0F, 0F, 4, 2, 6);
		rightFlipper.setRotationPoint(-4F, 22F, -8F);
		rightFlipper.setTextureSize(128, 128);
		rightFlipper.mirror = true;
		setRotation(rightFlipper, 0F, 0F, 0F);

		ModelRenderer leftFlipper = new ModelRenderer(this, 32, 0);
		leftFlipper.addBox(0F, 0F, 0F, 4, 2, 6);
		leftFlipper.setRotationPoint(0F, 22F, -8F);
		leftFlipper.setTextureSize(128, 128);
		leftFlipper.mirror = true;
		setRotation(leftFlipper, 0F, 0F, 0F);

		ModelRenderer snorkelHead = new ModelRenderer(this, 33, 10);
		snorkelHead.addBox(0F, 0F, 0F, 2, 1, 1);
		snorkelHead.setRotationPoint(-2F, -2F, -5F);
		snorkelHead.setTextureSize(128, 128);
		snorkelHead.mirror = true;
		setRotation(snorkelHead, 0F, 0F, 0F);

		ModelRenderer snorkelTop = new ModelRenderer(this, 0, 32);
		snorkelTop.addBox(0F, 0F, 0F, 1, 8, 1);
		snorkelTop.setRotationPoint(-3F, -9F, -5F);
		snorkelTop.setTextureSize(128, 128);
		snorkelTop.mirror = true;
		setRotation(snorkelTop, 0F, 0F, 0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
