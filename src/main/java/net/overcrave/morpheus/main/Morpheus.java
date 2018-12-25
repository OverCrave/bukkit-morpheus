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
	public static boolean enabled;
	public static boolean skipping;
	public static int sleepers = 0;
	
	private File configFile;
	public static FileConfiguration config;
	public static World world;
	
	@Override
	public void onLoad() 
	{
		enabled = true;
	    loadConfig();
	    regCmds();
	}
	
	@Override
	public void onEnable() 
	{
	    world = Bukkit.getWorlds().get(0);
	    regLrs();
	}

	private void loadConfig() 
	{
        configFile = new File(getDataFolder(), "config.yml");
        
        if (!configFile.exists()) 
        {
	        configFile.getParentFile().mkdirs();
	        saveResource("config.yml", false);
	    }

	    config = new YamlConfiguration();
	        
	    try 
	    {
	        config.load(configFile);
	    } 
	    catch (IOException | InvalidConfigurationException e) 
	    {
	        e.printStackTrace();
	    }
	}

	private void regCmds() 
	{
	    getCommand("morpheus").setExecutor(new MorpheusCommand());
	}

	private void regLrs() 
	{
	    getServer().getPluginManager().registerEvents(new SleepListener(), this);
	}
}