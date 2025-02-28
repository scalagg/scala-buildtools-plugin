package gg.scala.buildtools.listener

import gg.scala.commons.annotations.Listeners
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockFadeEvent
import org.bukkit.event.block.BlockFormEvent
import org.bukkit.event.block.BlockSpreadEvent
import org.bukkit.event.block.LeavesDecayEvent
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.weather.ThunderChangeEvent
import org.bukkit.event.weather.WeatherChangeEvent


/**
 * @author Topu
 * @date 2/27/2025
 */
@Listeners
object EntityListener : Listener
{

    @EventHandler
    fun onEntityDamage(event: EntityDamageEvent)
    {
        when (event.cause) {
            EntityDamageEvent.DamageCause.VOID -> {
                val world: World = event.entity.world
                val location = Location(world, 0.5, 75.0, 0.5)
                event.entity.teleport(location)
            }
            EntityDamageEvent.DamageCause.FALL -> event.isCancelled = true
            else -> {}
        }
    }

    @EventHandler
    fun onCreatureSpawn(event: CreatureSpawnEvent)
    {
        if (event.spawnReason != CreatureSpawnEvent.SpawnReason.CUSTOM) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onBlockSpread(event: BlockSpreadEvent)
    {
        event.isCancelled = true
    }

    @EventHandler
    fun onLeavesDecay(event: LeavesDecayEvent)
    {
        event.isCancelled = true
    }

    @EventHandler
    fun onBlockFade(event: BlockFadeEvent)
    {
        event.isCancelled = true
    }

    @EventHandler
    fun onBlockForm(event: BlockFormEvent)
    {
        event.isCancelled = true
    }

    @EventHandler
    fun onThunderChange(event: ThunderChangeEvent)
    {
        event.isCancelled = true
    }

    @EventHandler
    fun onWeatherChange(event: WeatherChangeEvent)
    {
        event.isCancelled = true
    }
}