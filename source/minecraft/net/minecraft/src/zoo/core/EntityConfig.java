/**
 * This software is provided under the terms of the Minecraft Forge Public
 * License v1.0.
 */

package net.minecraft.src.zoo.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

import net.minecraft.src.Block;
import net.minecraft.src.forge.Property;

/**
 * This class offers advanced configurations capabilities, allowing to provide
 * various categories for configuration variables.
 */
public class EntityConfig
{
	public static final int ENTITY_ID = 0;
	public static final int SPAWNRATE = 1;

	File file;

	public TreeMap<String, Property> spawnrates = new TreeMap<String, Property>();
	public TreeMap<String, Property> entityIDs = new TreeMap<String, Property>();

	/**
	 * Create a configuration file for the file given in parameter.
	 */
	public EntityConfig(File file)
	{
		this.file = file;
	}

	public Property getOrCreateIntProperty(String key, int kind, int defaultValue)
	{
		Property prop = getOrCreateProperty(key, kind, Integer.toString(defaultValue));
		try
		{
			Integer.parseInt(prop.value);
			return prop;
		} catch (NumberFormatException e)
		{
			prop.value = Integer.toString(defaultValue);
			return prop;
		}
	}

	public Property getOrCreateProperty(String key, int kind, String defaultValue)
	{
		TreeMap<String, Property> source = null;
		switch (kind)
		{
		case ENTITY_ID:
			source = entityIDs;
			break;
		case SPAWNRATE:
			source = spawnrates;
			break;
		}

		if (source.containsKey(key))
		{
			return source.get(key);
		}
		else if (defaultValue != null)
		{
			Property property = new Property();

			source.put(key, property);
			property.name = key;

			property.value = defaultValue;
			return property;
		}
		else
		{
			return null;
		}
	}

	public void load()
	{
		try
		{
			if (file.getParentFile() != null)
			{
				file.getParentFile().mkdirs();
			}

			if (!file.exists() && !file.createNewFile())
			{
				return;
			}

			if (file.canRead())
			{
				FileInputStream fileinputstream = new FileInputStream(file);
				BufferedReader buffer = new BufferedReader(new InputStreamReader(fileinputstream, "8859_1"));

				String line;
				TreeMap<String, Property> currentMap = null;

				while (true)
				{
					line = buffer.readLine();

					if (line == null)
					{
						break;
					}

					int nameStart = -1, nameEnd = -1;
					boolean skip = false;

					for (int i = 0; i < line.length() && !skip; ++i)
					{
						if (Character.isLetterOrDigit(line.charAt(i)) || line.charAt(i) == '.')
						{
							if (nameStart == -1)
							{
								nameStart = i;
							}

							nameEnd = i;
						}
						else if (Character.isWhitespace(line.charAt(i)))
						{
							// ignore space charaters
						}
						else
						{
							switch (line.charAt(i))
							{
							case '#':
								skip = true;
								continue;
							case '{':
								String scopeName = line.substring(nameStart, nameEnd + 1);

								if (scopeName.equals("id"))
								{
									currentMap = entityIDs;
								}
								else if (scopeName.equals("spawnrate"))
								{
									currentMap = spawnrates;
								}
								else
								{
									throw new RuntimeException("unknown section " + scopeName);
								}

								break;
							case '}':
								currentMap = null;
								break;
							case '=':
								String propertyName = line.substring(nameStart, nameEnd + 1);

								if (currentMap == null)
								{
									throw new RuntimeException("property " + propertyName + " has no scope");
								}

								Property prop = new Property();
								prop.name = propertyName;
								prop.value = line.substring(i + 1);
								i = line.length();

								currentMap.put(propertyName, prop);

								break;
							default:
								throw new RuntimeException("unknown character " + line.charAt(i));
							}
						}
					}
				}

			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void save()
	{
		try
		{
			if (file.getParentFile() != null)
			{
				file.getParentFile().mkdirs();
			}

			if (!file.exists() && !file.createNewFile())
			{
				return;
			}

			if (file.canWrite())
			{
				FileOutputStream fos = new FileOutputStream(file);
				BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos, "8859_1"));

				buffer.write("# Zoo Entity Configuration file\r\n");
				buffer.write("# Generated on " + DateFormat.getInstance().format(new Date()) + "\r\n");
				buffer.write("\r\n");
				buffer.write("###############\r\n");
				buffer.write("# Entity ID's #\r\n");
				buffer.write("###############\r\n\r\n");

				buffer.write("id {\r\n");
				writeProperties(buffer, entityIDs.values());
				buffer.write("}\r\n\r\n");

				buffer.write("##############\r\n");
				buffer.write("# Spawnrates #\r\n");
				buffer.write("##############\r\n\r\n");

				buffer.write("spawnrate {\r\n");
				writeProperties(buffer, spawnrates.values());
				buffer.write("}\r\n\r\n");

				buffer.close();
				fos.close();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void writeProperties(BufferedWriter buffer, Collection<Property> props) throws IOException
	{
		for (Property property : props)
		{
			if (property.comment != null)
			{
				buffer.write("   # " + property.comment + "\r\n");
			}

			buffer.write("   " + property.name + "=" + property.value);
			buffer.write("\r\n");
		}
	}
}
