package gg.scala.buildtools.listener

import gg.scala.commons.annotations.Listeners
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.LeavesDecayEvent
import org.bukkit.event.weather.WeatherChangeEvent
import org.bukkit.event.world.ChunkUnloadEvent

/**
 * @author Topu
 * @date 2/27/2025
 */
@Listeners
object WorldListener : Listener
{

    @EventHandler
    fun onWeatherChange(event: WeatherChangeEvent)
    {
        if (event.toWeatherState()) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onLeavesDecay(event: LeavesDecayEvent)
    {
        event.isCancelled = true
    }

    @EventHandler
    fun onChunkUnload(event: ChunkUnloadEvent)
    {
        event.isCancelled = true
    }
}