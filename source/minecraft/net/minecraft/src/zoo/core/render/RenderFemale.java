package net.minecraft.src.zoo.core.render;

import net.minecraft.src.*;
import net.minecraft.src.zoo.core.models.visitors.FemaleBase;

public class RenderFemale extends RenderLiving
{
	String texture;

	public RenderFemale(FemaleBase femaleBase, String s, float f)
	{
		super(femaleBase, f);
		texture = s;
	}
	
	protected void renderModel(EntityLiving par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.loadDownloadableImageTexture(par1EntityLiving.skinUrl, texture);
        this.mainModel.render(par1EntityLiving, par2, par3, par4, par5, par6, par7);
    }

	public void renderNew(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(entityliving, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		renderNew(entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		renderNew((EntityLiving) entity, d, d1, d2, f, f1);
	}

}
