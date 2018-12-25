package net.overcrave.morpheus.listener;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import net.overcrave.morpheus.main.Morpheus;

public class SleepListener implements Listener 
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerBedEnter(PlayerBedEnterEvent event)
	{
		Player player = event.getPlayer();
		
		if(!Morpheus.enabled)
		{
			return;
		}
		
		Morpheus.skipping = false;
		Morpheus.sleepers++;
		
		player.setStatistic(Statistic.TIME_SINCE_REST, 0);
		
		float ratio = Morpheus.sleepers / Morpheus.world.getPlayers().size();
		
		Bukkit.broadcastMessage(Morpheus.config.getString("messages.wentToBed"));
		
		if(ratio >= (Morpheus.config.getDouble("shareOfPlayers")) / 100)
		{
			Morpheus.skipping = true;
			
			while(Morpheus.world.getTime() > 20)
			{
				Morpheus.world.setTime(Morpheus.world.getTime() + 10);
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
		
		Morpheus.sleepers = 0;
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
		
		Morpheus.sleepers--;
		
		Bukkit.broadcastMessage(Morpheus.config.getString("messages.leftBed"));
	}
}
