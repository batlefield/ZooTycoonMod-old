package net.minecraft.src.zoo.core.render;
import org.lwjgl.opengl.GL11;

import net.minecraft.src.*;
import net.minecraft.src.zoo.core.entities.ZooEntityAfricanWDog;
import net.minecraft.src.zoo.core.entities.ZooEntityAnimal;
import net.minecraft.src.zoo.core.modells.ZooModelAfricanWDog;

public class ZooRenderAfricanWDog extends ZooRenderBase
{	
    public ZooRenderAfricanWDog(float f)
    {
        super(new ZooModelAfricanWDog(), f, -80);
    }
}
