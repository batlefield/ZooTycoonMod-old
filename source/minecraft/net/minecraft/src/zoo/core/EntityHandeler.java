package net.minecraft.src.zoo.core;

import java.util.Map;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityEggInfo;
import net.minecraft.src.EntityList;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Zoo;
import net.minecraft.src.zoo.core.entities.ZooEntityAfricanWDog;
import net.minecraft.src.zoo.core.entities.ZooEntityAnteater;
import net.minecraft.src.zoo.core.entities.ZooEntityBighorn;
import net.minecraft.src.zoo.core.entities.ZooEntityElephant;
import net.minecraft.src.zoo.core.entities.ZooEntityFemaleLion;
import net.minecraft.src.zoo.core.entities.ZooEntityFennecFox;
import net.minecraft.src.zoo.core.entities.ZooEntityFlamingo;
import net.minecraft.src.zoo.core.entities.ZooEntityGazelle;
import net.minecraft.src.zoo.core.entities.ZooEntityGiraffe;
import net.minecraft.src.zoo.core.entities.ZooEntityHippo;
import net.minecraft.src.zoo.core.entities.ZooEntityLion;
import net.minecraft.src.zoo.core.entities.ZooEntityPanther;
import net.minecraft.src.zoo.core.entities.ZooEntityPrimate;
import net.minecraft.src.zoo.core.entities.ZooEntityRhino;
import net.minecraft.src.zoo.core.entities.ZooEntityTiger;
import net.minecraft.src.zoo.core.entities.ZooEntityWolf;
import net.minecraft.src.zoo.core.entities.ZooVisitorFemale;
import net.minecraft.src.zoo.core.entities.ZooVisitorMale;
import net.minecraft.src.zoo.core.models.ZooModelFemaleMarine;
import net.minecraft.src.zoo.core.models.visitors.FemaleBase;
import net.minecraft.src.zoo.core.render.RenderFemale;
import net.minecraft.src.zoo.core.render.ZooRenderAfricanWDog;
import net.minecraft.src.zoo.core.render.ZooRenderAnteater;
import net.minecraft.src.zoo.core.render.ZooRenderBighorn;
import net.minecraft.src.zoo.core.render.ZooRenderElephant;
import net.minecraft.src.zoo.core.render.ZooRenderFemaleLion;
import net.minecraft.src.zoo.core.render.ZooRenderFennecFox;
import net.minecraft.src.zoo.core.render.ZooRenderGazelle;
import net.minecraft.src.zoo.core.render.ZooRenderGiraffe;
import net.minecraft.src.zoo.core.render.ZooRenderHippo;
import net.minecraft.src.zoo.core.render.ZooRenderLion;
import net.minecraft.src.zoo.core.render.ZooRenderPrimate;
import net.minecraft.src.zoo.core.render.ZooRenderRhino;
import net.minecraft.src.zoo.core.render.ZooRenderTiger;
import net.minecraft.src.zoo.core.render.ZooRenderWolf;

public class EntityHandeler
{
	
	public static BiomeGenBase savana[] = {Zoo.savannah};
	
	public static final int bighornID = ZooEntityInfo.getEntityID("Bighorn", ModLoader.getUniqueEntityId());
	public static final int gazelleID = ZooEntityInfo.getEntityID("Gazelle", ModLoader.getUniqueEntityId());
	public static final int hippoID = ZooEntityInfo.getEntityID("Hippo", ModLoader.getUniqueEntityId());
	public static final int primateID = ZooEntityInfo.getEntityID("Primate", ModLoader.getUniqueEntityId());
	public static final int rhinoID = ZooEntityInfo.getEntityID("Rhino", ModLoader.getUniqueEntityId());
	public static final int tigerID = ZooEntityInfo.getEntityID("Tiger", ModLoader.getUniqueEntityId());
	public static final int elephantID = ZooEntityInfo.getEntityID("Elephant", ModLoader.getUniqueEntityId());
	public static final int africanWildDogID = ZooEntityInfo.getEntityID("African wild dog", ModLoader.getUniqueEntityId());
	public static final int anteaterID = ZooEntityInfo.getEntityID("Anteater", ModLoader.getUniqueEntityId());
	public static final int lionID = ZooEntityInfo.getEntityID("Lion", ModLoader.getUniqueEntityId());
	public static final int pantherID = ZooEntityInfo.getEntityID("Panther", ModLoader.getUniqueEntityId());
	public static final int fennecFoxID = ZooEntityInfo.getEntityID("Fennec fox", ModLoader.getUniqueEntityId());
	public static final int giraffeID = ZooEntityInfo.getEntityID("Giraffe", ModLoader.getUniqueEntityId());
	public static final int flamingoID = ZooEntityInfo.getEntityID("Flamingo", ModLoader.getUniqueEntityId());
	public static final int maleID = ZooEntityInfo.getEntityID("Male", ModLoader.getUniqueEntityId());
	public static final int femaleID = ZooEntityInfo.getEntityID("Female", ModLoader.getUniqueEntityId());
	public static final int greywolfID = ZooEntityInfo.getEntityID("GreyWolf", ModLoader.getUniqueEntityId());
	public static final int femaleMarineID = ZooEntityInfo.getEntityID("Female Marine", ModLoader.getUniqueEntityId());
	public static final int lionFemaleID = ZooEntityInfo.getEntityID("Female lion", ModLoader.getUniqueEntityId());
	
	public static final int bighornSpawn = ZooEntityInfo.getSpawnrate("Bighorn", 1);
	public static final int gazelleSpawn = ZooEntityInfo.getSpawnrate("Gazelle", 1);
	public static final int hippoSpawn = ZooEntityInfo.getSpawnrate("Hippo", 1);
	public static final int primateSpawn = ZooEntityInfo.getSpawnrate("Primate", 1);
	public static final int rhinoSpawn = ZooEntityInfo.getSpawnrate("Rhino", 1);
	public static final int tigerSpawn = ZooEntityInfo.getSpawnrate("Tiger", 1);
	public static final int elephantSpawn = ZooEntityInfo.getSpawnrate("Elephant", 1);
	public static final int africanWildDogSpawn = ZooEntityInfo.getSpawnrate("African wild dog", 1);
	public static final int anteaterSpawn = ZooEntityInfo.getSpawnrate("Anteater", 1);
	public static final int lionSpawn = ZooEntityInfo.getSpawnrate("Lion", 1);
	public static final int pantherSpawn = ZooEntityInfo.getSpawnrate("Panther", 1);
	public static final int fennecFoxSpawn = ZooEntityInfo.getSpawnrate("Fennec fox", 1);
	public static final int giraffeSpawn = ZooEntityInfo.getSpawnrate("Giraffe", 1);
	public static final int flamingoSpawn = ZooEntityInfo.getSpawnrate("Flamingo", 1);
	public static final int maleSpawn = ZooEntityInfo.getSpawnrate("Male", 1);
	public static final int femaleSpawn = ZooEntityInfo.getSpawnrate("Female", 1);
	public static final int greywolfSpawn = ZooEntityInfo.getSpawnrate("GreyWolf", 1);
	public static final int femaleMarineSpawn = ZooEntityInfo.getSpawnrate("Female Marine", 1);
	public static final int lionFemaleSpawn = ZooEntityInfo.getSpawnrate("Female lion", 1);
	
	public static void init()
	{
		registerEntity(ZooEntityBighorn.class, "Bighorn", bighornID, bighornSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityGazelle.class, "Gazelle", gazelleID, gazelleSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityHippo.class, "Hippo", hippoID, hippoSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityPrimate.class, "Primate", primateID, primateSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityRhino.class, "Rhino", rhinoID, rhinoSpawn, 4, 4, EnumCreatureType.creature, true);
	    registerEntity(ZooEntityTiger.class, "Tiger", tigerID, tigerSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityElephant.class, "Elephant", elephantID, elephantSpawn, 10, 10, EnumCreatureType.creature, false);
		registerEntity(ZooEntityAfricanWDog.class, "AfricanWildDog", africanWildDogID, africanWildDogSpawn, 4, 8, EnumCreatureType.creature, savana, true);
		registerEntity(ZooEntityAnteater.class, "Anteater", anteaterID, anteaterSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityLion.class, "Lion", lionID, lionSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityPanther.class, "Panther", pantherID, pantherSpawn, 4, 4, EnumCreatureType.creature, false);
		registerEntity(ZooEntityFennecFox.class, "Fennec Fox", fennecFoxID, fennecFoxSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityGiraffe.class, "Giraffe", giraffeID, giraffeSpawn, 4, 4, EnumCreatureType.creature, true);
		registerEntity(ZooEntityFlamingo.class, "Flamingo", flamingoID, flamingoSpawn, 4, 4, EnumCreatureType.creature, false);
		registerEntity(ZooVisitorMale.class, "Male", maleID, maleSpawn, 1, 1, EnumCreatureType.creature, false);
		registerEntity(ZooVisitorFemale.class, "Female", femaleID, femaleSpawn, 1, 1, EnumCreatureType.creature, false);
		registerEntity(ZooEntityWolf.class, "GreyWolf", greywolfID, greywolfSpawn, 1, 1, EnumCreatureType.creature, false);
		registerEntity(ZooVisitorFemale.class, "Female Marine", femaleMarineID, femaleMarineSpawn, 1, 1, EnumCreatureType.creature, false);
		registerEntity(ZooEntityFemaleLion.class, "Female lion", lionFemaleID, lionFemaleSpawn, 1, 1, EnumCreatureType.creature, true);
		          
		initEggs();
	}
	
	public static void addRender(Map map)
	{
		map.put(ZooEntityBighorn.class, new ZooRenderBighorn(0.5F));
		map.put(ZooEntityGazelle.class, new ZooRenderGazelle(0.5F));
		map.put(ZooEntityHippo.class, new ZooRenderHippo(0.5F));
		map.put(ZooEntityPrimate.class, new ZooRenderPrimate(0.5F));
		map.put(ZooEntityRhino.class, new ZooRenderRhino(0.5F));
		map.put(ZooEntityTiger.class, new ZooRenderTiger(0.5F));
		//map.put(ZooEntityElephant.class, new ZooRenderElephant(0.5F));
		map.put(ZooEntityAfricanWDog.class, new ZooRenderAfricanWDog(0.5F));
		map.put(ZooEntityAnteater.class, new ZooRenderAnteater(0.5F));
		//map.put(ZooVisitorFemale.class, new RenderFemale(new FemaleBase(), "/zoo/modells/npcs/girl npc.png", 0.5F));
		map.put(ZooEntityLion.class, new ZooRenderLion(0.5F));
		// map.put(ZooEntityPanther.class, new ZooRenderPanter(0.5F));
		map.put(ZooEntityFennecFox.class, new ZooRenderFennecFox(0.5F));
		map.put(ZooEntityGiraffe.class, new ZooRenderGiraffe(0.6F));
		// map.put(ZooEntityFlamingo.class, new ZooRenderFlamingo(0.5F));
		//map.put(ZooEntityWolf.class, new ZooRenderWolf(0.5F));
		map.put(ZooEntityFemaleLion.class, new ZooRenderFemaleLion(0.5F));
		//map.put(ZooVisitorFemale.class, new RenderFemale(new ZooModelFemaleMarine(), "/zoo/modells/npcs/female marine.png", 0.5F));
	}
	
	private static void initEggs()
	{
		addEgg(africanWildDogID, 0xD9BB89, 0x8C7958, "African wild dog");
		addEgg(anteaterID, 0x313423, 0x25240f, "Anteater");
		addEgg(bighornID, 0x573f14, 0xa0917e, "Bighorn");
		addEgg(primateID, 0x31312f, 0xccab9c, "Primate");
		addEgg(fennecFoxID, 0xd2c09c, 0xe2e0d3, "Fennec Fox");
		//addEgg(flamingoID, 0xffa7a7, 0xffc5b3, "Flamingo");
		addEgg(gazelleID, 0xc67d41, 0xd0d5d1, "Gazelle");
		addEgg(giraffeID, 0xe8bf9b, 0x815030, "Giraffe");
		addEgg(hippoID, 0x665a58, 0x473f3e, "Hippo");
		addEgg(lionID, 0x81622b, 0x463f2f, "Lion");
		addEgg(rhinoID, 0xc6d0d1, 0xd5e1e2, "Rhino");
		//addEgg(pantherID, 0x000000, 0x00002e, "Black panther");
		addEgg(elephantID, 0x4f4f4f, 0xe4e0dd, "Elephant");
		//addEgg(greywolfID, 0xe4e0dd, 0x4f4f4f, "Grey Wolf");
	}
	
	private static void registerEntity(Class class1, String name, int entityID, int spawnrate, int min, int max, EnumCreatureType type, boolean canSpawn)
	{
		registerEntity(class1, name, entityID, spawnrate, min, max, type, (BiomeGenBase[])null, canSpawn);
	}
	
	private static void registerEntity(Class class1, String name, int entityID, int spawnrate, int min, int max, EnumCreatureType type, BiomeGenBase[] biomeArray, boolean canSpawn)
	{
		ModLoader.registerEntityID(class1, name, entityID);
		if(canSpawn)
		{
			ModLoader.addSpawn(class1, spawnrate, min, max, type, biomeArray);
		}
	}
	
	
	private static void addEgg(int entityId, int primaryCol, int secondaryCol, String s)
	{
		ModLoader.addLocalization("entity." + EntityList.getStringFromID(entityId) + ".name", s);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityEggInfo(entityId, primaryCol, secondaryCol));
	}
}
