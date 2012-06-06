package net.minecraft.src.zoo.trading;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.zoo.furniture.ZooModel;

public class TileEntitySafeRender extends TileEntitySpecialRenderer{

	private ModelSafe safeModel = new ModelSafe();
	
	public TileEntitySafeRender()
	{
	}
	
	public void renderAModelAt(TileEntitySafe tileentity, double d, double d1, double d2, float f)
    {   
        int x;
        if(tileentity.worldObj == null)
        {
        	x = 2;
        }else{
        	x = tileentity.getBlockMetadata();
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        if(x == 5) GL11.glRotatef((-1*90f), 0, 1f, 0);
        if(x == 4) GL11.glRotatef(( 1*90f), 0, 1f, 0);
        if(x == 3) GL11.glRotatef(( 1*180f), 0, 1f, 0);
        if(x == 2) GL11.glRotatef(( 0*180F), 0, 1f, 0);
        GL11.glRotatef(180, 1f, 0, 0);
        bindTextureByName("/zoo/modells/safe.png");
        GL11.glPushMatrix();
        safeModel.SafeDoor.rotateAngleY = -((tileentity.prevAngle + (tileentity.currentAngle - tileentity.prevAngle) * f) * (float)Math.PI / 1.5F);
        safeModel.renderModel(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
	
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		renderAModelAt((TileEntitySafe)var1, var2, var4, var6, var8);
	}

}
