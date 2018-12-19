package net.overcrave.morpheus.main;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import net.overcrave.morpheus.command.MorpheusCommand;
import net.overcrave.morpheus.listener.SleepListener;

public class Morpheus extends JavaPlugin 
{
	public static boolean toggled = true;
	public static boolean skippingNow = false;
	public static int sleepers = 0;
	
	private File customConfigFile;
	public static FileConfiguration customConfig;
	public static World world;
	
	@Override
	public void onEnable() 
	{
	    world = Bukkit.getWorlds().get(0);
	    createConfigFile();
	    registerCommand();
	    registerListener();
	  }

	  private void createConfigFile() 
	  {
	        customConfigFile = new File(getDataFolder(), "config.yml");
	        if (!customConfigFile.exists()) {
	            customConfigFile.getParentFile().mkdirs();
	            saveResource("config.yml", false);
	         }

	        customConfig = new YamlConfiguration();
	        
	        try 
	        {
	            customConfig.load(customConfigFile);
	        } 
	        
	        catch (IOException | InvalidConfigurationException e) 
	        {
	            e.printStackTrace();
	        }
	}

	private void registerCommand() 
	  {
	    getCommand("morpheus").setExecutor(new MorpheusCommand());
	  }

	  private void registerListener() 
	  {
	    getServer().getPluginManager().registerEvents(new SleepListener(), this);
	  }
}
