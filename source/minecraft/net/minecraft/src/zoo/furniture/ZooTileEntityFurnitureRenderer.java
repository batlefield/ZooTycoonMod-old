package net.minecraft.src.zoo.furniture;

import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;

public class ZooTileEntityFurnitureRenderer extends TileEntitySpecialRenderer
{
	
	public ZooTileEntityFurnitureRenderer(String texture, Class class1)
	{
		try { aModel = (ZooModel)(class1.newInstance()); }
		catch(Exception e) { System.err.println(e); }
		strTexture = texture;
	}
	
    public void renderAModelAt(TileEntity tileentity1, double d, double d1, double d2, float f)
    {   
        int x = tileentity1.getBlockMetadata();
        if(aModel.isMultiBlock && x>3) return;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); 
        if(x == 0) GL11.glRotatef((-1*90f), 0, 1f, 0);
        if(x == 1) GL11.glRotatef(( 1*90f), 0, 1f, 0);
        if(x == 2) GL11.glRotatef(( 1*180f), 0, 1f, 0);
        if(x == 3) GL11.glRotatef(( 0*180F), 0, 1f, 0);
        GL11.glRotatef(180, 1f, 0, 0);
        bindTextureByName(strTexture);
        GL11.glPushMatrix();
        aModel.renderModel(0.0625F);
        GL11.glPopMatrix();     
        GL11.glPopMatrix();                     
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        renderAModelAt((TileEntity)tileentity, d, d1, d2, f);
    }

    private ZooModel aModel;
    private String strTexture;
}
