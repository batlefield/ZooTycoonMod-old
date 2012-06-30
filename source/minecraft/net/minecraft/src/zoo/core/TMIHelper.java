package net.minecraft.src.zoo.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TMIHelper {
	
	private static boolean hasInit = false;
	private static Class tmiItemInfo;
	private static Method hideItem;
	private static Method packIDdmg;
	
	private static void init()
	{	
		if(hasInit)
		{
			return;
		}
		
		try {
			tmiItemInfo = Class.forName("net.minecraft.src.TMIItemInfo");
			System.out.println("Zoo: TMI plugin loaded");
		} catch (ClassNotFoundException e) {
			try {
				tmiItemInfo = Class.forName("TMIItemInfo");
				System.out.println("Zoo: TMI plugin loaded");
			} catch (ClassNotFoundException e1) {
				System.out.println("Zoo: TMI not installed, skipping TMI plugin.");
			}
		}
		
		if(tmiItemInfo != null)
		{
			try {
				hideItem = tmiItemInfo.getMethod("hideItem", Integer.TYPE);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			
			try {
				packIDdmg = tmiItemInfo.getMethod("packItemIDAndDamage", Integer.TYPE, Integer.TYPE);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		
		hasInit = true;
	}
	
	public static void hideItem(int i)
	{
		init();
		
		if(tmiItemInfo != null)
		{
			try {
				hideItem.invoke(null, Integer.valueOf(i));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void hideItem(int i, int j)
	{
		init();
		
		if(tmiItemInfo != null)
		{
			try {
				hideItem.invoke(null, packIDdmg.invoke(null, i, j));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
