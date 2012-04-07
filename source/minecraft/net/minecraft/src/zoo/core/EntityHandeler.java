package net.minecraft.src.zoo.core;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityEggInfo;
import net.minecraft.src.EntityList;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Zoo;
import net.minecraft.src.zoo.core.entities.ZooEntityAfricanWDog;
import net.minecraft.src.zoo.core.entities.ZooEntityAnteater;
import net.minecraft.src.zoo.core.entities.ZooEntityBighorn;
import net.minecraft.src.zoo.core.entities.ZooEntityElephant;
import net.minecraft.src.zoo.core.entities.ZooEntityFennecFox;
import net.minecraft.src.zoo.core.entities.ZooEntityFlamingo;
import net.minecraft.src.zoo.core.entities.ZooEntityGazelle;
import net.minecraft.src.zoo.core.entities.ZooEntityGiraffe;
import net.minecraft.src.zoo.core.entities.ZooEntityGreyWolf;
import net.minecraft.src.zoo.core.entities.ZooEntityHippo;
import net.minecraft.src.zoo.core.entities.ZooEntityLion;
import net.minecraft.src.zoo.core.entities.ZooEntityPanther;
import net.minecraft.src.zoo.core.entities.ZooEntityPrimate;
import net.minecraft.src.zoo.core.entities.ZooEntityRhino;
import net.minecraft.src.zoo.core.entities.ZooEntityTiger;
import net.minecraft.src.zoo.core.entities.ZooVisitorFemale;
import net.minecraft.src.zoo.core.entities.ZooVisitorMale;

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
	public static final int greyWolfID = ZooEntityInfo.getEntityID("Grey wolf", ModLoader.getUniqueEntityId());
	public static final int maleID = ZooEntityInfo.getEntityID("Male", ModLoader.getUniqueEntityId());
	public static final int femaleID = ZooEntityInfo.getEntityID("Female", ModLoader.getUniqueEntityId());
	
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
	public static final int greyWolfSpawn = ZooEntityInfo.getSpawnrate("Grey wolf", 1);
	public static final int maleSpawn = ZooEntityInfo.getSpawnrate("Male", 1);
	public static final int femaleSpawn = ZooEntityInfo.getSpawnrate("Female", 1);
	
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
		registerEntity(ZooEntityGreyWolf.class, "Grey wolf", greyWolfID, greyWolfSpawn, 10, 10, EnumCreatureType.creature, false);
		registerEntity(ZooVisitorMale.class, "Male", maleID, maleSpawn, 1, 1, EnumCreatureType.creature, false);
		registerEntity(ZooVisitorFemale.class, "Female", femaleID, femaleSpawn, 1, 1, EnumCreatureType.creature, false);
		          
		addEggs();
	}
	
	private static void addEggs()
	{
		addEgg(africanWildDogID, 0xD9BB89, 0x8C7958, "African wild dog");
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
