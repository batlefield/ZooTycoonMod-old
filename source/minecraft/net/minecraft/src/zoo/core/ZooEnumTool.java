package net.minecraft.src.zoo.core;


public enum ZooEnumTool
{
    FENCEDES("FENCEDES", 5, 7, 50, 10F, 0),
    BS("BS", 6, 1, 131, 4F, 1);
/*
    public static ZooEnumTool[] values()
    {
        return (ZooEnumTool[])allToolMaterials.clone();
    }

    public static ZooEnumTool valueOf(String s)
    {
        return (ZooEnumTool)Enum.valueOf(net.minecraft.src.ZooEnumTool.class, s);
    }
*/
    private ZooEnumTool(String s, int i, int j, int k, float f, int l)
    {
//        super(s, i);
        harvestLevel = j;
        maxUses = k;
        efficiencyOnProperMaterial = f;
        damageVsEntity = l;
    }

    public int getMaxUses()
    {
        return maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return harvestLevel;
    }
/*
    public static final ZooEnumTool FENCEDES;
*/
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private static final ZooEnumTool allToolMaterials[]; /* synthetic field */

    static 
    {
/*
        FENCEDES = new ZooEnumTool("FENCEDES", 3, 3, 1561, 8F, 3);
*/
        allToolMaterials = (new ZooEnumTool[] {
            FENCEDES, BS
        });
    }
}