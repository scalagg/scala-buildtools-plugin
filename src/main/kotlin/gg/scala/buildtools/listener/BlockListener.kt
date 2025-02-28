package gg.scala.buildtools.listener

import com.boydti.fawe.`object`.FawePlayer
import com.sk89q.worldedit.EditSession
import com.sk89q.worldedit.Vector
import com.sk89q.worldedit.blocks.BaseBlock
import gg.scala.buildtools.ScalaBuildTools
import gg.scala.commons.annotations.Listeners
import net.evilblock.cubed.util.CC
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.PlayerInteractEvent

/**
 * @author Topu
 * @date 2/27/2025
 */
@Listeners
object BlockListener : Listener
{
    @EventHandler(priority = EventPriority.MONITOR)
    fun onBlockPlace(event: BlockPlaceEvent)
    {
        if (event.isCancelled) return

        val item = event.itemInHand
        if (item.type != Material.SKULL || !item.hasItemMeta() || !item.itemMeta!!.hasLore()) return

        val lore = item.itemMeta!!.lore ?: return
        if (!lore[0].startsWith("${CC.B_GRAY}ID${CC.GRAY} ")) return

        val (id, data) = lore[0].removePrefix("${CC.B_GRAY}ID${CC.GRAY} ").split(":").map { it.toInt() }

        Bukkit.getScheduler().runTaskLater(ScalaBuildTools.instance, Runnable {
            val material = Material.getMaterial(id) ?: return@Runnable
            val block = event.blockPlaced
            block.setType(material, true)
            block.data = data.toByte()
        }, 0L)

        event.isCancelled = true
    }

    @EventHandler(priority = EventPriority.MONITOR)
    fun onBlockInteract(event: PlayerInteractEvent)
    {
        if (event.isCancelled || event.action != Action.RIGHT_CLICK_BLOCK) return

        val player = event.player
        val item = player.itemInHand

        if (item.type != Material.SKULL_ITEM || !item.hasItemMeta() || !item.itemMeta!!.hasLore()) return

        val lore = item.itemMeta!!.lore ?: return
        if (!lore[0].startsWith("${CC.B_GRAY}ID${CC.GRAY} ")) return

        val (id, data) = lore[0].removePrefix("${CC.B_GRAY}ID${CC.GRAY} ").split(":").map { it.toInt() }

        Bukkit.getScheduler().runTaskLater(ScalaBuildTools.instance, Runnable
        {
            val clickedBlock = event.clickedBlock ?: return@Runnable
            val face = event.blockFace
            val newBlock = when (face) {
                BlockFace.DOWN -> clickedBlock.location.add(0.0, -1.0, 0.0).block
                BlockFace.UP -> clickedBlock.location.add(0.0, 1.0, 0.0).block
                BlockFace.NORTH -> clickedBlock.location.add(0.0, 0.0, -1.0).block
                BlockFace.EAST -> clickedBlock.location.add(1.0, 0.0, 0.0).block
                BlockFace.SOUTH -> clickedBlock.location.add(0.0, 0.0, 1.0).block
                BlockFace.WEST -> clickedBlock.location.add(-1.0, 0.0, 0.0).block
                else -> return@Runnable
            }

            try
            {
                val fawePlayer = FawePlayer.wrap<Any>(player)
                val editSession: EditSession = fawePlayer.newEditSession
                editSession.setBlock(
                    Vector(newBlock.x, newBlock.y, newBlock.z),
                    BaseBlock(id, data)
                )
                editSession.flushQueue()
            } catch (e: Exception)
            {
                e.printStackTrace()
            }
        }, 0L)

        event.isCancelled = true
    }
}