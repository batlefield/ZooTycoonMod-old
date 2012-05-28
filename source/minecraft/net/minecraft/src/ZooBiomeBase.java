package net.minecraft.src;

import net.minecraft.src.zoo.core.ZooPlatform;
import net.minecraft.src.zoo.dimension.ZooDimDecidious;
import net.minecraft.src.zoo.dimension.ZooDimSavannah;
import net.minecraft.src.zoo.dimension.ZooDimTropic;

public class ZooBiomeBase extends BiomeGenBase{

	public ZooBiomeBase(int i) {
		super(i);
		topBlock = (byte)Block.grass.blockID;
        fillerBlock = (byte)Block.dirt.blockID;
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        waterColorMultiplier = 0xffffff;
        temperature = 0.5F;
        rainfall = 0.5F;
	}
	
	public static final BiomeGenBase mesa = (new BiomeGenMesa(ZooPlatform.getFreeBiomeID(251))).setColor(0xFFEF00).setBiomeName("Mesa").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.2F, 0.8F);
    public static final BiomeGenBase ocean = (new BiomeGenOcean(ZooPlatform.getFreeBiomeID(246))).setColor(112).setBiomeName("Ocean").setMinMaxHeight(-1F, 0.4F);
    public static final BiomeGenBase savannah = (new ZooDimSavannah(ZooPlatform.getFreeBiomeID(247))).setColor(0xFFEF00).setBiomeName("Savannah").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
    public static final BiomeGenBase decidious = (new ZooDimDecidious(ZooPlatform.getFreeBiomeID(248))).setColor(0x8db360).setBiomeName("Decidious").setTemperatureRainfall(0.8F, 0.4F).func_4124_a(0x4eba31);
    public static final BiomeGenBase tropic = (new ZooDimTropic(ZooPlatform.getFreeBiomeID(249))).setColor(0x8db360).setBiomeName("Tropic").setTemperatureRainfall(2F, 2F);
}
