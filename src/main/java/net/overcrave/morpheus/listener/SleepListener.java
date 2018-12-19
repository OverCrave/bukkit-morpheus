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
		
		if(!Morpheus.toggled)
		{
			return;
		}
		
		Morpheus.skippingNow = false;
		Morpheus.sleepers++;
		
		player.setStatistic(Statistic.TIME_SINCE_REST, 0);
		
		float ratio = Morpheus.sleepers / Morpheus.world.getPlayers().size();
		
		Bukkit.broadcastMessage(Morpheus.customConfig.getString("messages.wentToBed"));
		
		if(ratio >= Morpheus.customConfig.getDouble("shareOfPlayers"))
		{
			Morpheus.skippingNow = true;
			
			while(Morpheus.world.getTime() > 20)
			{
				Morpheus.world.setTime(Morpheus.world.getTime() + 10);
			}
			
			Bukkit.broadcastMessage(Morpheus.customConfig.getString("messages.goodMorning"));
			
			if(Morpheus.customConfig.getBoolean("informWithTitle"))
			{
				for(Player p : Bukkit.getOnlinePlayers())
				{
					p.sendTitle(Morpheus.customConfig.getString("messages.goodMorning"), "", 5, 15, 5);
				}
			}
		}
		
		Morpheus.sleepers = 0;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerBedLeave(PlayerBedLeaveEvent event)
	{
		Player player = event.getPlayer();
		
		if(!Morpheus.toggled)
		{
			return;
		}
		
		if(Morpheus.skippingNow)
		{
			if(Morpheus.customConfig.getBoolean("setBedSpawn"))
			{
				player.setBedSpawnLocation(player.getLocation());
				player.sendMessage(Morpheus.customConfig.getString("messages.setSpawn"));
			}
			
			return;
		}
		
		Morpheus.sleepers--;
		
		Bukkit.broadcastMessage(Morpheus.customConfig.getString("messages.leftBed"));
	}
}
