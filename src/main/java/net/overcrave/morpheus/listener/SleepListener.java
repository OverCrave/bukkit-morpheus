package net.overcrave.morpheus.listener;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import net.overcrave.morpheus.main.Morpheus;

public class SleepListener implements Listener 
{
	private static World world;
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerBedEnter(PlayerBedEnterEvent event)
	{
		if(!Morpheus.enabled)
		{
			return;
		}
		
		for(World w : Morpheus.worlds)
		{
			if(w.getName() == event.getBed().getLocation().getWorld().getName())
			{
				world = w;
			}
		}
		
		int worldIndex = Morpheus.worlds.indexOf(world);
		Morpheus.sleepers.set(worldIndex, Morpheus.sleepers.get(worldIndex) + 1);
		
		Morpheus.skipping = false;
		
		Player player = event.getPlayer();
		player.setStatistic(Statistic.TIME_SINCE_REST, 0);
		
		float ratio = Morpheus.sleepers.get(worldIndex) / world.getPlayers().size();
		
		Bukkit.broadcastMessage(Morpheus.config.getString("messages.wentToBed"));
		
		if(ratio >= (Morpheus.config.getDouble("shareOfPlayers")) / 100)
		{
			Morpheus.skipping = true;
			
			while(world.getTime() > 20)
			{
				world.setTime(world.getTime() + 10);
			}
			
			Bukkit.broadcastMessage(Morpheus.config.getString("messages.goodMorning"));
			
			if(Morpheus.config.getBoolean("informWithTitle"))
			{
				for(Player p : Bukkit.getOnlinePlayers())
				{
					p.sendTitle(Morpheus.config.getString("messages.goodMorning"), "", 5, 15, 5);
				}
			}
		}

		Morpheus.sleepers.set(worldIndex, 0);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerBedLeave(PlayerBedLeaveEvent event)
	{
		Player player = event.getPlayer();
		
		if(!Morpheus.enabled)
		{
			return;
		}
		
		if(Morpheus.skipping)
		{
			if(Morpheus.config.getBoolean("setBedSpawn"))
			{
				player.setBedSpawnLocation(player.getLocation());
				player.sendMessage(Morpheus.config.getString("messages.setSpawn"));
			}
			
			return;
		}

		for(World w : Morpheus.worlds)
		{
			if(w.getName() == event.getBed().getLocation().getWorld().getName())
			{
				world = w;
			}
		}
		
		int worldIndex = Morpheus.worlds.indexOf(world);
		Morpheus.sleepers.set(worldIndex, Morpheus.sleepers.get(worldIndex) - 1);
		
		Bukkit.broadcastMessage(Morpheus.config.getString("messages.leftBed"));
	}
}
